public class Exercise09_09 {
    public static void main(String[] args) {

        // make 3 polygons
        RegularPolygon p1 = new RegularPolygon();
        RegularPolygon p2 = new RegularPolygon(6, 4);
        RegularPolygon p3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // show p1
        System.out.println("Polygon 1");
        System.out.println("Perimeter: " + p1.getPerimeter());
        System.out.println("Area: " + p1.getArea());
        System.out.println();

        // show p2
        System.out.println("Polygon 2");
        System.out.println("Perimeter: " + p2.getPerimeter());
        System.out.println("Area: " + p2.getArea());
        System.out.println();

        // show p3
        System.out.println("Polygon 3");
        System.out.println("Perimeter: " + p3.getPerimeter());
        System.out.println("Area: " + p3.getArea());
    }
}

class RegularPolygon {

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