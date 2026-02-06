import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise21_03 {
    public static void main(String[] args) {
        // Get file name from command line
        if (args.length != 1) {
            System.out.println("Usage: java Exercise21_03 sourceFile");
            System.exit(1);
        }

        File file = new File(args[0]);

        // Check that the file exists
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist");
            System.exit(2);
        }

        try {
            // Count keywords and display result
            System.out.println("The number of keywords in the program is " + countKeywords(file));
        } catch (FileNotFoundException e) {
            System.out.println("File could not be read: " + args[0]);
        }
    }

    public static int countKeywords(File file) throws FileNotFoundException {
        String[] keywordString = {
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
                "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
                "volatile", "while", "true", "false", "null"
        };

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

        Scanner input = new Scanner(file);
        int count = 0;

        boolean inBlockComment = false;

        while (input.hasNextLine()) {
            String line = input.nextLine();
            StringBuilder cleanedLine = new StringBuilder();
            boolean inString = false;

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                // Skip block comments: /* ... */
                if (inBlockComment) {
                    if (ch == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        inBlockComment = false;
                        i++;
                    }
                    continue;
                }

                if (!inString && ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                    inBlockComment = true;
                    i++;
                    continue;
                }

                // Stop at line comments: //
                if (!inString && ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    break;
                }

                // Ignore characters inside "..."
                if (ch == '"') {
                    inString = !inString;
                    continue;
                }

                if (!inString) {
                    cleanedLine.append(ch);
                }
            }

            Scanner lineScanner = new Scanner(cleanedLine.toString());
            while (lineScanner.hasNext()) {
                String word = lineScanner.next();
                if (keywordSet.contains(word)) {
                    count++;
                }
            }
            lineScanner.close();
        }

        input.close();
        return count;
    }
}