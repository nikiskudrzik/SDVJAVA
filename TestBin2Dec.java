import java.util.Scanner;

public class TestBin2Dec {

    // Turns a binary string into a decimal number
    public static int bin2Dec(String binaryString) throws BinaryFormatException {

        // Check that the string only has 0 or 1
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new BinaryFormatException("Not a binary string: " + binaryString);
            }
        }

        // Convert binary to decimal
        int decimal = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            decimal = decimal * 2 + (binaryString.charAt(i) - '0');
        }

        return decimal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a binary string: ");
        String s = input.nextLine();

        // Try to convert it
        try {
            int value = bin2Dec(s);
            System.out.println("Decimal value: " + value);
        } catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }

        input.close();
    }
}