package th.ac.kmutt.cpe.algorithm.wisit.lab.lab7.binPackingAddMethod;

import java.util.List;
import java.util.Scanner;

public class BinPackingMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== BIN PACKING ===\n");

            List<BoxSize> boxes = loadBoxes(scanner);
            if (boxes == null || boxes.isEmpty()) {
                System.out.println("No box data found or error reading file");
                return;
            }

            System.out.print("Enter bin width: ");
            double binWidth = scanner.nextDouble();
            System.out.print("Enter bin height: ");
            double binHeight = scanner.nextDouble();

            double binArea = binWidth * binHeight;
            System.out.printf("Custom bin size: %.1f x %.1f (Total area: %.2f)\n\n", binWidth, binHeight, binArea);

            System.out.println("Select packing algorithm:");
            System.out.println("1. Best-Fit Decreasing Algorithm");
            System.out.println("2. First-Fit Decreasing Algorithm");
            System.out.println("3. Compare both algorithms");
            System.out.print("Choose algorithm (1-3): ");
            int algorithmChoice = scanner.nextInt();

            if (algorithmChoice == 3) {
                compareBothAlgorithms(boxes, binWidth, binHeight);
            } else {
                BinPackingAlgorithm algorithm;
                switch (algorithmChoice) {
                    case 2:
                        algorithm = new FirstFitAlgorithm();
                        break;
                    case 1:
                    default:
                        algorithm = new BestFitAlgorithm();
                        break;
                }

                BinPackingResult result = algorithm.pack(boxes, binWidth, binHeight);
                showDetailedResults(boxes, result, binWidth, binHeight);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static List<BoxSize> loadBoxes(Scanner scanner) {
        System.out.println("Select box data file:");
        System.out.println("1. boxSize1.csv (9 items)");
        System.out.println("2. boxSize2.csv (2 items)");
        System.out.println("3. boxSize3.csv (6 items)");
        System.out.print("Choose (1-3): ");

        int choice = scanner.nextInt();
        String filename;
        switch (choice) {
            case 1:
                filename = "boxSize1.csv";
                break;
            case 2:
                filename = "boxSize2.csv";
                break;
            case 3:
                filename = "boxSize3.csv";
                break;
            default:
                System.out.println("Invalid choice. Using boxSize1.csv");
                filename = "boxSize1.csv";
        }

        try {
            String filePath = "src/th/ac/kmutt/cpe/algorithm/wisit/lab/lab7/binPackingAddMethod/" + filename;
            return BoxSizeReader.readFromCSV(filePath);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    private static void showDetailedResults(List<BoxSize> boxes, BinPackingResult result, double binWidth,
            double binHeight) {
        System.out.println("==================================================");
        System.out.println("BOX SUMMARY");
        System.out.println("==================================================");
        System.out.println("Total boxes: " + boxes.size());

        double totalBoxArea = 0;
        for (BoxSize box : boxes) {
            totalBoxArea += box.getArea();
        }
        System.out.printf("Total area of all boxes: %.2f\n\n", totalBoxArea);

        System.out.println("==================================================");
        System.out.println("PACKING RESULTS");
        System.out.println("==================================================");
        System.out.println("Algorithm used: " + result.getAlgorithmUsed());
        System.out.println("Bins used: " + result.getBins().size());
        System.out.printf("Average utilization: %.1f%%\n", result.getAverageUtilization());
        System.out.println();

        // Display unpacked items details
        System.out.println("==================================================");
        System.out.println("UNPACKED BOXES");
        System.out.println("==================================================");
        if (result.getUnpackedItems().isEmpty()) {
            System.out.println("All items successfully packed!");
            System.out.println("Number of unpacked boxes: 0");
        } else {
            System.out.println("Unpacked boxes:");
            for (BoxSize box : result.getUnpackedItems()) {
                System.out.printf("  %s (Too large for bin)\n", box);
            }
            System.out.println("Number of unpacked boxes: " + result.getUnpackedItems().size());
        }

        System.out.println("\n==================================================");
        System.out.println("BIN DETAILS AND REMAINING AREA");
        System.out.println("==================================================");
        double totalRemainingArea = 0;
        for (int i = 0; i < result.getBins().size(); i++) {
            Bin bin = result.getBins().get(i);
            double remainingArea = bin.getRemainingArea();
            totalRemainingArea += remainingArea;

            System.out.printf("Bin %d:\n", i + 1);

            List<BoxSize> boxesInBin = bin.getItems();
            System.out.printf("  Boxes in this bin: %d\n", boxesInBin.size());
            double totalUsedArea = 0.0;
            for (int j = 0; j < boxesInBin.size(); j++) {
                BoxSize box = boxesInBin.get(j);
                System.out.printf("    Box %d: Width=%.1f, Height=%.1f, Area=%.2f\n",
                        j + 1, box.getWidth(), box.getHeight(), box.getArea());
                totalUsedArea += box.getArea();
            }

            System.out.printf("  TOTAL USED AREA: %.2f\n", totalUsedArea);
            System.out.printf("  REMAINING AREA: %.2f\n", remainingArea);
        }

        System.out.println("\n==================================================");
        System.out.println("SUMMARY - BIN PACKING");
        System.out.println("==================================================");
        System.out.println("UNPACKED BOXES COUNT: " + result.getUnpackedItems().size());
        System.out.printf("TOTAL REMAINING AREA: %.2f\n", totalRemainingArea);
    }

    private static void compareBothAlgorithms(List<BoxSize> boxes, double binWidth, double binHeight) {
        System.out.println("\n==================================================");
        System.out.println("ALGORITHM COMPARISON");
        System.out.println("==================================================");

        BestFitAlgorithm bestFit = new BestFitAlgorithm();
        long startTime = System.nanoTime();
        BinPackingResult bestFitResult = bestFit.pack(boxes, binWidth, binHeight);
        long endTime = System.nanoTime();
        double bestFitTime = (endTime - startTime) / 1_000_000.0;

        FirstFitAlgorithm firstFit = new FirstFitAlgorithm();
        startTime = System.nanoTime();
        BinPackingResult firstFitResult = firstFit.pack(boxes, binWidth, binHeight);
        endTime = System.nanoTime();
        double firstFitTime = (endTime - startTime) / 1_000_000.0;

        System.out.printf("%-22s | %-10s | %-12s | %-10s\n", "Algorithm", "Bins Used", "Utilization", "Time(ms)");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-22s | %-10d | %-11.1f%% | %-10.3f\n", "Best-Fit Decreasing",
                bestFitResult.getBins().size(),
                bestFitResult.getAverageUtilization(), bestFitTime);
        System.out.printf("%-22s | %-10d | %-11.1f%% | %-10.3f\n", "First-Fit Decreasing",
                firstFitResult.getBins().size(),
                firstFitResult.getAverageUtilization(), firstFitTime);
        System.out.println("------------------------------------------------------------------");
    }
}