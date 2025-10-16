package th.ac.kmutt.cpe.algorithm.wisit.lab.lab6.binPacking;

import java.util.ArrayList;
import java.util.List;

public class Bin {
    private double width;
    private double height;
    private List<BoxSize> items;
    private double remainingArea;

    public Bin(double width, double height) {
        this.width = width;
        this.height = height;
        this.items = new ArrayList<>();
        this.remainingArea = width * height;
    }

    public boolean canFit(BoxSize box) {
        Point position = findBottomLeftPosition(box);
        return position != null;
    }

    public boolean canFitDimensions(BoxSize box) {
        return (box.getWidth() <= width && box.getHeight() <= height) ||
                (box.getHeight() <= width && box.getWidth() <= height);
    }

    public boolean addBox(BoxSize box) {
        Point position = findBottomLeftPosition(box);
        if (position != null) {
            if (position.x + box.getWidth() <= width && position.y + box.getHeight() <= height) {
                box.setPosition(position.x, position.y);
                items.add(box);
                remainingArea -= box.getArea();
                return true;
            }
        }
        return false;
    }

    private Point findBottomLeftPosition(BoxSize box) {
        Point pos = findPosition(box.getWidth(), box.getHeight());
        if (pos != null) {
            return pos;
        }
        return null;
    }

    private Point findPosition(double boxWidth, double boxHeight) {
        if (canPlaceAt(0, 0, boxWidth, boxHeight)) {
            return new Point(0, 0);
        }

        java.util.Set<Point> positions = new java.util.HashSet<>();
        positions.add(new Point(0, 0));

        for (BoxSize existingBox : items) {
            if (existingBox.isPlaced()) {
                double ex = existingBox.getX();
                double ey = existingBox.getY();
                double ew = existingBox.getWidth();
                double eh = existingBox.getHeight();

                positions.add(new Point(ex + ew, ey));
                positions.add(new Point(ex, ey + eh));
                positions.add(new Point(ex + ew, ey + eh));
            }
        }

        return positions.stream()
                .filter(p -> canPlaceAt(p.x, p.y, boxWidth, boxHeight))
                .min((p1, p2) -> {
                    int yCompare = Double.compare(p1.y, p2.y);
                    return yCompare != 0 ? yCompare : Double.compare(p1.x, p2.x);
                })
                .orElse(null);
    }

    private boolean canPlaceAt(double x, double y, double boxWidth, double boxHeight) {
        if (x + boxWidth > width || y + boxHeight > height) {
            return false;
        }

        for (BoxSize existingBox : items) {
            if (existingBox.isPlaced()) {
                double ex = existingBox.getX();
                double ey = existingBox.getY();
                double ew = existingBox.getWidth();
                double eh = existingBox.getHeight();

                if (!(x + boxWidth <= ex || ex + ew <= x ||
                        y + boxHeight <= ey || ey + eh <= y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Point))
                return false;
            Point point = (Point) obj;
            return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(x, y);
        }
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public List<BoxSize> getItems() {
        return new ArrayList<>(items);
    }

    public double getRemainingArea() {
        return remainingArea;
    }

    public double getUsedArea() {
        return (width * height) - remainingArea;
    }

    public double getUtilization() {
        return getUsedArea() / (width * height) * 100;
    }

    @Override
    public String toString() {
        return String.format("Bin{size=%.1fx%.1f, items=%d, utilization=%.1f%%}",
                width, height, items.size(), getUtilization());
    }
}