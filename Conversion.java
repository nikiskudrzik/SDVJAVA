public class Conversion {

    // Convert from feet to meters
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    // Convert from meters to feet 
    public static double meterToFoot(double meter) {
        return meter / 0.305;
    }
}