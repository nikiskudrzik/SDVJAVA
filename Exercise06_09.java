public class Exercise06_09 {
    public static void main(String[] args) {

        System.out.printf("%-8s%-12s%12s%12s%n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("--------------------------------------------");

        double foot = 1.0;
        double meter = 20.0;

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-8.1f%-12.3f%12.1f%12.3f%n",
                    foot, Conversion.footToMeter(foot),
                    meter, Conversion.meterToFoot(meter));

            foot++;
            meter += 5;
        }
    }
}