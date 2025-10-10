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
        return box.getArea() <= remainingArea;
    }

    public boolean canFitDimensions(BoxSize box) {
        return (box.getWidth() <= width && box.getHeight() <= height) ||
                (box.getHeight() <= width && box.getWidth() <= height);
    }

    public boolean addBox(BoxSize box) {
        if (canFit(box) && canFitDimensions(box)) {
            items.add(box);
            remainingArea -= box.getArea();
            return true;
        }
        return false;
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