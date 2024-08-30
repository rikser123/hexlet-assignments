package exercise;

// BEGIN
public class Segment {
    private Point statPoint;
    private Point endPoint;

    public Segment(Point startPoint, Point endPoint) {
        this.statPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return statPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        var xMiddle = (statPoint.getX() + endPoint.getX()) / 2;
        var yMiddle = (statPoint.getY() + endPoint.getY()) / 2;

        return new Point(xMiddle, yMiddle);
    }
}
// END
