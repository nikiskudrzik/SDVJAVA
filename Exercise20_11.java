import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Exercise20_11 {
    public static void main(String[] args) {
        // Check that a source file name was provided.
        if (args.length != 1) {
            System.out.println("Usage: java Exercise20_11 sourceFile");
            System.exit(1);
        }

        File file = new File(args[0]);

        // Make sure the file exists.
        if (!file.exists()) {
            System.out.println("File not found: " + args[0]);
            System.exit(2);
        }

        try {
            // Check grouping symbols and print the result.
            if (hasCorrectGroupingPairs(file)) {
                System.out.println("Correct grouping pairs");
            } else {
                System.out.println("Incorrect grouping pairs");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be read: " + args[0]);
        }
    }

    public static boolean hasCorrectGroupingPairs(File file) throws FileNotFoundException {
        Stack<Character> stack = new Stack<>();
        Scanner input = new Scanner(file);

        // Read the file and process each character.
        while (input.hasNextLine()) {
            String line = input.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                // Push opening symbols onto the stack.
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
                // For closing symbols, check that it matches the top of the stack.
                else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) {
                        input.close();
                        return false;
                    }

                    char top = stack.pop();
                    if (!isMatchingPair(top, ch)) {
                        input.close();
                        return false;
                    }
                }
            }
        }

        input.close();

        // If the stack is empty, all grouping symbols were matched.
        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char open, char close) {
        // Return true if the open and close symbols are a correct pair.
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}