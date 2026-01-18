import java.util.Scanner;

public class Exercise06_31 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ask for a number
        System.out.print("Enter a credit card number as a long integer: ");
        long cardNumber = input.nextLong();

        // show result
        if (isValid(cardNumber)) {
            System.out.println(cardNumber + " is valid");
        } else {
            System.out.println(cardNumber + " is invalid");
        }
    }

    // true if the number is ok
    public static boolean isValid(long cardNumber) {
        int size = getSize(cardNumber);

        if (size < 13 || size > 16) {
            return false;
        }

        // must start with 4, 5, 37, or 6
        if (!prefixMatched(cardNumber, 4) &&
            !prefixMatched(cardNumber, 5) &&
            !prefixMatched(cardNumber, 37) &&
            !prefixMatched(cardNumber, 6)) {
            return false;
        }

        int sum = sumOfDoubleEvenPlace(cardNumber) + sumOfOddPlace(cardNumber);

        return (sum % 10 == 0);
    }

    // add doubled even place digits
    public static int sumOfDoubleEvenPlace(long cardNumber) {
        int sum = 0;

        cardNumber = cardNumber / 10;

        while (cardNumber != 0) {
            int digit = (int)(cardNumber % 10);
            sum += getDigit(digit * 2);

            cardNumber = cardNumber / 100;
        }

        return sum;
    }

    // if 2 digits, add them
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return (number / 10) + (number % 10);
        }
    }

    // add odd place digits
    public static int sumOfOddPlace(long cardNumber) {
        int sum = 0;

        while (cardNumber != 0) {
            int digit = (int)(cardNumber % 10);
            sum += digit;

            cardNumber = cardNumber / 100;
        }

        return sum;
    }

    // true if number starts with d
    public static boolean prefixMatched(long cardNumber, int d) {
        return getPrefix(cardNumber, getSize(d)) == d;
    }

    // count digits
    public static int getSize(long d) {
        int count = 0;

        while (d != 0) {
            count++;
            d = d / 10;
        }

        return count;
    }

    // get first k digits
    public static long getPrefix(long cardNumber, int k) {
        int numberSize = getSize(cardNumber);

        if (numberSize <= k) {
            return cardNumber;
        }

        for (int i = 0; i < numberSize - k; i++) {
            cardNumber = cardNumber / 10;
        }

        return cardNumber;
    }
}