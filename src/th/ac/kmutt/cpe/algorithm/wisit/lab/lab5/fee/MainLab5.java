package th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee;

import java.util.Scanner;

public class MainLab5 {

    private static CSVReader.EMSData emsData;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            loadEMSData();
            displayLoadedData();
            runCalculator(scanner);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void loadEMSData() {
        System.out.println("============================================================");
        System.out.println("EMS FEE CALCULATOR");
        System.out.println("============================================================");
        System.out.println("Loading EMS rate data...");

        try {
            emsData = CSVReader.loadEMSData();
            System.out.println("EMS data loaded successfully!");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load EMS data: " + e.getMessage(), e);
        }
    }

    private static void displayLoadedData() {
        System.out.println("Data Summary:");
        System.out.println("   - Domestic rates: " + emsData.getDomesticCount());
        System.out.println("   - World rates: " + emsData.getWorldCount());
    }

    private static void runCalculator(Scanner scanner) {
        FeeCalculationContext context = new FeeCalculationContext(new BinarySearchFee());
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.println("\n============================================================");
            System.out.println("EMS COST CALCULATION");
            System.out.println("============================================================");

            try {
                System.out.println("Choose delivery type:");
                System.out.println("1. EMS Domestic");
                System.out.println("2. EMS World");
                System.out.print("Enter your choice (1-2): ");

                int choice = scanner.nextInt();

                System.out.print("Enter package weight (grams): ");
                int weight = scanner.nextInt();

                switch (choice) {
                    case 1:
                        String domesticResult = context.findDomesticCost(weight);
                        displayDomesticResult(weight, domesticResult);
                        break;

                    case 2:
                        scanner.nextLine();
                        System.out.print("Enter destination zone (1-10): ");
                        int zone = scanner.nextInt();

                        String worldResult = context.findWorldCost(weight, zone);
                        displayWorldResult(weight, zone, worldResult);
                        break;

                    default:
                        System.out.println("Invalid choice! Please select 1 or 2.");
                        continue;
                }

                System.out.print("\nDo you want to calculate another package? (y/n): ");
                scanner.nextLine();
                String answer = scanner.nextLine().toLowerCase();
                continueCalculation = answer.equals("y") || answer.equals("yes");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
                scanner.nextLine();
            }
        }

        System.out.println("\nThank you for using EMS Calculator!");
    }

    private static void displayDomesticResult(int weight, String cost) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("CALCULATION RESULT - EMS DOMESTIC");
        System.out.println("=".repeat(50));
        System.out.printf("Package Weight: %d grams%n", weight);
        System.out.printf("Service Type: EMS Domestic%n");
        System.out.printf("Shipping Cost: %s%n", cost);
        System.out.println("=".repeat(50));
    }

    private static void displayWorldResult(int weight, int zone, String cost) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("CALCULATION RESULT - EMS WORLD");
        System.out.println("=".repeat(50));
        System.out.printf("Package Weight: %d grams%n", weight);
        System.out.printf("Service Type: EMS World%n");
        System.out.printf("Destination Zone: %d%n", zone);
        System.out.printf("Shipping Cost: %s%n", cost);
        System.out.println("=".repeat(50));
    }
}
