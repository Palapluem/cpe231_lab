package th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking;

import java.util.ArrayList;
import java.util.List;

public class BinPackingComparison {
    public static void main(String[] args) {
        List<BoxSize> boxes = new ArrayList<>();
        boxes.add(new BoxSize(3.0, 4.0));
        boxes.add(new BoxSize(2.0, 3.0));
        boxes.add(new BoxSize(4.0, 2.0));
        boxes.add(new BoxSize(1.0, 2.0));
        boxes.add(new BoxSize(2.0, 2.0));
        boxes.add(new BoxSize(3.0, 1.0));

        double binWidth = 5.0;
        double binHeight = 5.0;

        System.out.println("=== BIN PACKING COMPARISON ===");
        System.out.println("Bin Size: " + binWidth + " x " + binHeight);
        System.out.println("Boxes to pack: " + boxes.size());
        for (BoxSize box : boxes) {
            System.out.println("  " + box);
        }
        System.out.println();

        System.out.println("=== BEST-FIT ALGORITHM ===");
        BestFitAlgorithm bestFit = new BestFitAlgorithm();
        BinPackingResult bestFitResult = bestFit.pack(boxes, binWidth, binHeight);
        printResults(bestFitResult);

        System.out.println();

        System.out.println("=== FIRST-FIT ALGORITHM ===");
        FirstFitAlgorithm firstFit = new FirstFitAlgorithm();
        BinPackingResult firstFitResult = firstFit.pack(boxes, binWidth, binHeight);
        printResults(firstFitResult);

        System.out.println();

        // Compare results
        System.out.println("=== COMPARISON ===");
        System.out.println("Best-Fit: " + bestFitResult.getBins().size() + " bins used");
        System.out.println("First-Fit: " + firstFitResult.getBins().size() + " bins used");

        if (bestFitResult.getBins().size() < firstFitResult.getBins().size()) {
            System.out.println("Best-Fit performed better!");
        } else if (firstFitResult.getBins().size() < bestFitResult.getBins().size()) {
            System.out.println("First-Fit performed better!");
        } else {
            System.out.println("Both algorithms used the same number of bins!");
        }
    }

    private static void printResults(BinPackingResult result) {
        System.out.println("Algorithm: " + result.getAlgorithmUsed());
        System.out.println("Bins used: " + result.getBins().size());
        System.out.println("Unpacked items: " + result.getUnpackedItems().size());
        System.out.println("Average utilization: " + String.format("%.1f%%", result.getAverageUtilization()));

        for (int i = 0; i < result.getBins().size(); i++) {
            Bin bin = result.getBins().get(i);
            System.out.println("  Bin " + (i + 1) + ": " + bin);
            for (BoxSize item : bin.getItems()) {
                System.out.println("    - " + item);
            }
        }

        if (!result.getUnpackedItems().isEmpty()) {
            System.out.println("Unpacked items:");
            for (BoxSize item : result.getUnpackedItems()) {
                System.out.println("  - " + item);
            }
        }
    }
}