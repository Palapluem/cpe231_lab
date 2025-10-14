package th.ac.kmutt.cpe.algorithm.wisit.lab.lab7.binPackingAddMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoxSizeReader {
    public static List<BoxSize> readFromCSV(String filename) throws IOException {
        List<BoxSize> boxes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    String[] parts = line.split(",");
                    if (parts.length != 2) {
                        System.err.printf("Warning: Line %d has invalid format: %s%n", lineNumber, line);
                        continue;
                    }

                    double width = Double.parseDouble(parts[0].trim());
                    double height = Double.parseDouble(parts[1].trim());

                    if (width <= 0 || height <= 0) {
                        System.err.printf("Warning: Line %d has invalid dimensions: %.1f, %.1f%n",
                                lineNumber, width, height);
                        continue;
                    }

                    boxes.add(new BoxSize(width, height));

                } catch (NumberFormatException e) {
                    System.err.printf("Warning: Line %d has invalid numbers: %s%n", lineNumber, line);
                }
            }
        }

        System.out.printf("Successfully loaded %d boxes from %s%n", boxes.size(), filename);
        return boxes;
    }

    public static void printBoxSummary(List<BoxSize> boxes) {
        if (boxes.isEmpty()) {
            System.out.println("No boxes loaded.");
            return;
        }

        System.out.println("\n=== Box Summary ===");
        System.out.printf("Total boxes: %d%n", boxes.size());

        double totalArea = boxes.stream().mapToDouble(BoxSize::getArea).sum();
        double avgArea = totalArea / boxes.size();
        double minArea = boxes.stream().mapToDouble(BoxSize::getArea).min().orElse(0);
        double maxArea = boxes.stream().mapToDouble(BoxSize::getArea).max().orElse(0);

        System.out.printf("Total area: %.2f%n", totalArea);
        System.out.printf("Average area: %.2f%n", avgArea);
        System.out.printf("Min area: %.2f%n", minArea);
        System.out.printf("Max area: %.2f%n", maxArea);

        System.out.println("\nBox details:");
        for (int i = 0; i < boxes.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, boxes.get(i));
        }
    }
}