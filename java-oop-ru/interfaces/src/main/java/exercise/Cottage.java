package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override()
    public double getArea() {
        return area;
    }

    @Override()
    public int compareTo(Home item) {
        return Double.compare(getArea(), item.getArea());
    }

    @Override()
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }
}
// END
