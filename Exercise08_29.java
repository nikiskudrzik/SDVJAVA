import java.util.Scanner;

public class Exercise08_29 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // make two 3x3 arrays
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        // read m1
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                m1[row][col] = input.nextInt();
            }
        }

        // read m2
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                m2[row][col] = input.nextInt();
            }
        }

        // check if they match
        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }

    // true if both arrays have the same numbers
    public static boolean equals(int[][] m1, int[][] m2) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m1[row][col] != m2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}