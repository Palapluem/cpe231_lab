package th.ac.kmutt.cpe.algorithm.wisit.lab.lab7.binPackingAddMethod;

public class BoxSize implements Comparable<BoxSize> {
    private double width;
    private double height;

    public BoxSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("BoxSize{width=%.1f, height=%.1f, area=%.2f}", width, height, getArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        BoxSize boxSize = (BoxSize) obj;
        return Double.compare(boxSize.width, width) == 0 &&
                Double.compare(boxSize.height, height) == 0;
    }

    @Override
    public int compareTo(BoxSize other) {
        return Double.compare(other.getArea(), this.getArea());
    }
}