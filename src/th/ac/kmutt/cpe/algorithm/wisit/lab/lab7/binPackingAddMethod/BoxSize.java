package th.ac.kmutt.cpe.algorithm.wisit.lab.lab7.binPackingAddMethod;

public class BoxSize implements Comparable<BoxSize> {
    private double width;
    private double height;
    private double x;
    private double y;
    private boolean placed;

    public BoxSize(double width, double height) {
        this.width = width;
        this.height = height;
        this.x = -1;
        this.y = -1;
        this.placed = false;
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
        this.placed = true;
    }

    public void resetPosition() {
        this.x = -1;
        this.y = -1;
        this.placed = false;
    }

    @Override
    public String toString() {
        if (placed) {
            return String.format("BoxSize{width=%.1f, height=%.1f, area=%.2f, pos=(%.1f,%.1f)}",
                    width, height, getArea(), x, y);
        } else {
            return String.format("BoxSize{width=%.1f, height=%.1f, area=%.2f, pos=NOT_PLACED}",
                    width, height, getArea());
        }
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