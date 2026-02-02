public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    // constructors
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // radius getter/setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // area and perimeter
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // print info
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated()
                + " and the radius is " + radius);
    }

    // compare circles by radius
    @Override
    public int compareTo(Circle other) {
        if (this.radius > other.radius) return 1;
        else if (this.radius < other.radius) return -1;
        else return 0;
    }

    // equal if radii are the same
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Circle)) return false;

        Circle other = (Circle) obj;
        return this.radius == other.radius;
    }
}