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