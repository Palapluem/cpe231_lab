package th.ac.kmutt.cpe.algorithm.wisit.lab.lab5.fee;

import java.io.*;
import java.util.*;

public class CSVReader {

    // Class for holding all EMS data
    public static class EMSData {
        private List<EMSDomesticRate> domesticRates;
        private List<EMSWorldRate> worldRates;

        public EMSData() {
            this.domesticRates = new ArrayList<>();
            this.worldRates = new ArrayList<>();
        }

        // Getters
        public List<EMSDomesticRate> getDomesticRates() {
            return domesticRates;
        }

        public List<EMSWorldRate> getWorldRates() {
            return worldRates;
        }

        // Helper methods
        public int getDomesticCount() {
            return domesticRates.size();
        }

        public int getWorldCount() {
            return worldRates.size();
        }

        public int getTotalCount() {
            return domesticRates.size() + worldRates.size();
        }
    }

    // Class for holding EMS Domestic data (From, To, Cost)
    public static class EMSDomesticRate {
        private int from;
        private int to;
        private int cost;

        public EMSDomesticRate(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        // Getters
        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return String.format("From: %d, To: %d, Cost: %d", from, to, cost);
        }
    }

    // Class for holding EMS World data (From, To, Zone1-10 costs)
    public static class EMSWorldRate {
        private int from;
        private int to;
        private int[] zoneCosts; // Zone 1 to Zone 10

        public EMSWorldRate(int from, int to, int[] zoneCosts) {
            this.from = from;
            this.to = to;
            this.zoneCosts = zoneCosts.clone();
        }

        // Getters
        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int[] getZoneCosts() {
            return zoneCosts.clone();
        }

        public int getZoneCost(int zone) {
            if (zone >= 1 && zone <= 10) {
                return zoneCosts[zone - 1]; // zone 1 = index 0
            }
            return -1; // Invalid zone
        }

        // Method for checking if a zone is available for shipping
        public boolean isZoneAvailable(int zone) {
            if (zone >= 1 && zone <= 10) {
                return zoneCosts[zone - 1] != -1;
            }
            return false;
        }

        // Method for getting zone cost display string
        public String getZoneCostDisplay(int zone) {
            if (zone >= 1 && zone <= 10) {
                int cost = zoneCosts[zone - 1];
                if (cost == -1) {
                    return "N/A"; // Not available for shipping
                } else {
                    return String.valueOf(cost);
                }
            }
            return "Invalid";
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("From: %d, To: %d, Zones: ", from, to));
            for (int i = 0; i < zoneCosts.length; i++) {
                if (zoneCosts[i] == -1) {
                    sb.append(String.format("Z%d=N/A", i + 1));
                } else {
                    sb.append(String.format("Z%d=%d", i + 1, zoneCosts[i]));
                }
                if (i < zoneCosts.length - 1)
                    sb.append(", ");
            }
            return sb.toString();
        }
    }

    // Method to read CSV file and return all rows
    public static List<String[]> readCSV(String filePath) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
        return records;
    }

    // Method to get all CSV files in the fee folder
    public static List<String> getCSVFilesInFeeFolder() {
        List<String> csvFiles = new ArrayList<>();
        String currentDir = System.getProperty("user.dir");
        String feeFolder = currentDir + "\\src\\th\\ac\\kmutt\\cpe\\algorithm\\wisit\\fee";

        File folder = new File(feeFolder);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
                        csvFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return csvFiles;
    }

    // Method for loading EMS data from both CSV files
    public static EMSData loadEMSData() {
        EMSData emsData = new EMSData();
        String currentDir = System.getProperty("user.dir");
        String feeFolder = currentDir + "\\src\\th\\ac\\kmutt\\cpe\\algorithm\\wisit\\lab\\lab5\\fee";

        // Load EMS Domestic data
        String domesticPath = feeFolder + "\\EMS_Domestic.csv";
        File domesticFile = new File(domesticPath);
        if (domesticFile.exists()) {
            List<String[]> rawData = readCSV(domesticPath);
            List<EMSDomesticRate> domesticRates = parseDomesticData(rawData);
            emsData.domesticRates.addAll(domesticRates);
            System.out.println("Loaded EMS_Domestic.csv: " + domesticRates.size() + " rates");
        } else {
            System.out.println("EMS_Domestic.csv not found!");
        }

        // Load EMS World data
        String worldPath = feeFolder + "\\EMS_World.csv";
        File worldFile = new File(worldPath);
        if (worldFile.exists()) {
            List<String[]> rawData = readCSV(worldPath);
            List<EMSWorldRate> worldRates = parseWorldData(rawData);
            emsData.worldRates.addAll(worldRates);
            System.out.println("Loaded EMS_World.csv: " + worldRates.size() + " rates");
        } else {
            System.out.println("EMS_World.csv not found!");
        }

        return emsData;
    }

    // Method for converting Domestic data from String[] to EMSDomesticRate
    private static List<EMSDomesticRate> parseDomesticData(List<String[]> rawData) {
        List<EMSDomesticRate> rates = new ArrayList<>();
        // Skip header row (index 0)
        for (int i = 1; i < rawData.size(); i++) {
            String[] row = rawData.get(i);
            if (row.length >= 3) {
                try {
                    int from = Integer.parseInt(row[0].trim());
                    int to = Integer.parseInt(row[1].trim());
                    int cost = Integer.parseInt(row[2].trim());
                    rates.add(new EMSDomesticRate(from, to, cost));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing domestic row " + i + ": " + String.join(",", row));
                }
            }
        }
        return rates;
    }

    // Method for converting World data from String[] to EMSWorldRate
    private static List<EMSWorldRate> parseWorldData(List<String[]> rawData) {
        List<EMSWorldRate> rates = new ArrayList<>();
        // Skip header row (index 0)
        for (int i = 1; i < rawData.size(); i++) {
            String[] row = rawData.get(i);
            if (row.length >= 12) { // From, To, Zone1-Zone10 = 12 columns
                try {
                    int from = Integer.parseInt(row[0].trim());
                    int to = Integer.parseInt(row[1].trim());
                    int[] zoneCosts = new int[10];
                    for (int j = 0; j < 10; j++) {
                        String zoneValue = row[j + 2].trim();
                        if (zoneValue.isEmpty()) {
                            // If no value (e.g. Zone 9 for more than 20001 grams), set to -1 to indicate
                            // not available for shipping
                            zoneCosts[j] = -1;
                        } else {
                            zoneCosts[j] = Integer.parseInt(zoneValue);
                        }
                    }
                    rates.add(new EMSWorldRate(from, to, zoneCosts));
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing world row " + i + ": " + String.join(",", row));
                }
            }
        }
        return rates;
    }

    // Method for displaying EMS data by category
    public static void displayEMSData(EMSData emsData) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("EMS DATA SUMMARY");
        System.out.println("=".repeat(80));
        System.out.println("Domestic rates: " + emsData.getDomesticCount());
        System.out.println("World rates: " + emsData.getWorldCount());
        System.out.println("Total rates: " + emsData.getTotalCount());

        // Display data from EMS Domestic
        if (!emsData.getDomesticRates().isEmpty()) {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("EMS DOMESTIC RATES");
            System.out.println("-".repeat(40));
            List<EMSDomesticRate> domesticRates = emsData.getDomesticRates();
            for (int i = 0; i < domesticRates.size(); i++) {
                System.out.printf("Dom-Rate %-3d: %s%n", (i + 1), domesticRates.get(i).toString());
            }
        }

        // Display data from EMS World
        if (!emsData.getWorldRates().isEmpty()) {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("EMS WORLD RATES (ALL ZONES)");
            System.out.println("-".repeat(40));
            List<EMSWorldRate> worldRates = emsData.getWorldRates();
            for (int i = 0; i < worldRates.size(); i++) {
                EMSWorldRate rate = worldRates.get(i);
                System.out.printf("World-Rate %-3d: From: %d-%-5d | ", (i + 1), rate.getFrom(), rate.getTo());

                // Display all zone costs in a neat format
                for (int zone = 1; zone <= 10; zone++) {
                    System.out.printf("Z%d:%s", zone, rate.getZoneCostDisplay(zone));
                    if (zone < 10)
                        System.out.print(", ");
                }
                System.out.println();
            }
        }
    }

    // Method for displaying all world rates in a detailed table
    public static void displayAllWorldRates(EMSData emsData) {
        List<EMSWorldRate> worldRates = emsData.getWorldRates();
        if (worldRates.isEmpty()) {
            System.out.println("No world rates available.");
            return;
        }

        System.out.println("\n" + "=".repeat(100));
        System.out.println("EMS WORLD RATES - ALL ZONES DETAILED VIEW");
        System.out.println("=".repeat(100));
        System.out.printf("%-4s %-12s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s %-8s%n", "No.", "Weight(g)", "Zone1",
                "Zone2", "Zone3", "Zone4", "Zone5", "Zone6", "Zone7", "Zone8", "Zone9", "Zone10");
        System.out.println("-".repeat(100));

        for (int i = 0; i < worldRates.size(); i++) {
            EMSWorldRate rate = worldRates.get(i);
            System.out.printf("%-4d %-12s ", (i + 1), rate.getFrom() + "-" + rate.getTo());

            for (int zone = 1; zone <= 10; zone++) {
                String costDisplay = rate.getZoneCostDisplay(zone);
                System.out.printf("%-8s ", costDisplay);
            }
            System.out.println();
        }
        System.out.println("=".repeat(100));
    }

    // Method for reading and displaying EMS data from both files
    public static void ReadCSV() {
        System.out.println("Loading EMS data from both CSV files...");

        EMSData emsData = loadEMSData();

        displayEMSData(emsData);
        displayAllWorldRates(emsData);

        // Example usage
        System.out.println("\n" + "=".repeat(80));
        System.out.println("EXAMPLE USAGE");
        System.out.println("=".repeat(80));

        // access Domestic data
        List<EMSDomesticRate> domesticRates = emsData.getDomesticRates();
        if (!domesticRates.isEmpty()) {
            System.out.println("First domestic rate: " + domesticRates.get(0).toString());
            System.out.println("Example: Weight 150g costs " + findDomesticCost(domesticRates, 150) + " baht");
        }

        // access World data
        List<EMSWorldRate> worldRates = emsData.getWorldRates();
        if (!worldRates.isEmpty()) {
            System.out.println("First world rate: " + worldRates.get(0).toString());
            System.out.println("Example: Weight 150g to Zone 3 costs " + findWorldCostDisplay(worldRates, 150, 3));
            System.out.println("Example: Weight 150g to Zone 5 costs " + findWorldCostDisplay(worldRates, 150, 5));
            System.out.println("Example: Weight 150g to Zone 9 costs " + findWorldCostDisplay(worldRates, 150, 9));
            System.out.println("Example: Weight 150g to Zone 10 costs " + findWorldCostDisplay(worldRates, 150, 10));

            // Test with heavy packages (which cannot be shipped to Zone 9)
            System.out.println("\nTesting heavy packages (20001g+):");
            System.out.println("Example: Weight 25000g to Zone 3 costs " + findWorldCostDisplay(worldRates, 25000, 3));
            System.out.println("Example: Weight 25000g to Zone 9 costs " + findWorldCostDisplay(worldRates, 25000, 9));
            System.out
                    .println("Example: Weight 25000g to Zone 10 costs " + findWorldCostDisplay(worldRates, 25000, 10));
        }
    }

    // Helper method to find domestic cost for a given weight
    private static int findDomesticCost(List<EMSDomesticRate> rates, int weight) {
        for (EMSDomesticRate rate : rates) {
            if (weight >= rate.getFrom() && weight <= rate.getTo()) {
                return rate.getCost();
            }
        }
        return -1; // Not found
    }

    // Helper method to find world cost for a given weight and zone
    private static String findWorldCostDisplay(List<EMSWorldRate> rates, int weight, int zone) {
        for (EMSWorldRate rate : rates) {
            if (weight >= rate.getFrom() && weight <= rate.getTo()) {
                if (rate.isZoneAvailable(zone)) {
                    return rate.getZoneCost(zone) + " baht";
                } else {
                    return "cannot be shipped to Zone (N/A)";
                }
            }
        }
        return "Not found cost";
    }

    // Helper method to find world cost for a given weight and zone (สำหรับการคำนวณ)
    private static int findWorldCost(List<EMSWorldRate> rates, int weight, int zone) {
        for (EMSWorldRate rate : rates) {
            if (weight >= rate.getFrom() && weight <= rate.getTo()) {
                return rate.getZoneCost(zone);
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        ReadCSV();
    }
}