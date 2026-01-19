public class RegularPolygon {

    // number of sides
    private int n = 3;

    // length of each side
    private double side = 1;

    // center x and y
    private double x = 0;
    private double y = 0;

    // default polygon
    public RegularPolygon() {
    }

    // polygon at (0,0)
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    // polygon at (x,y)
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // get and set n
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    // get and set side
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    // get and set x
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    // get and set y
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // perimeter
    public double getPerimeter() {
        return n * side;
    }

    // area
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}