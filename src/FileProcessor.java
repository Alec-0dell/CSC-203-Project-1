import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Contains file processing behavior for the project.
 * You will modify only the following methods:
 * - parseLineUsingLittleNumber()
 * - parseLineUsingBigNumber()
 * You do not need to run this class directly.
 *
 * @author Vanessa Rivera
 */
public class FileProcessor {
    /**
     * Automatically called multiple times when parsing an input text file, once for each line.
     * The included tests control whether the LittleNumber or BigNumber version is used.
     *
     * @param line The line from the input file, including any newline characters
     */
    public static void parseLineUsingLittleNumber(String line) {
        //TODO: Clean and parse the line (Hint: use the 'split()' method which accepts a regular expression)

        //TODO: Ensure the line contains the expected values and number of arguments, returning if necessary

        //TODO: Parse numeric text as objects
        // Hint: Use the 'LittleNumber' class's 'fromString' method
        // Hint: For exponentiation, use Integer.parseInt for the power

        //TODO: Determine which operator the line contains (Hint: Use conditionals or a switch)

        //TODO: Perform the operation, storing the result

        //TODO: Print the result of the operation in the proper format, e.g. "x + y = z"

        //TODO: Remove the this and the above TODO comments
    }

    /**
     * Automatically called multiple times when parsing an input text file, once for each line.
     * The included tests control whether the LittleNumber or BigNumber version is used.
     *
     * @param line The line from the input file, including any newline characters
     */
    public static void parseLineUsingBigNumber(String line) {
        //TODO: Clean and parse the line (Hint: use the 'split()' method which accepts a regular expression)

        //TODO: Ensure the line contains the expected values and number of arguments, returning if necessary

        //TODO: Parse numeric text as objects (Hint: Use the 'BigNumber' class's 'fromString' method)

        //TODO: Determine which operator the line contains
        // Hint: Use the 'LittleNumber' class's 'fromString' method
        // Hint: For exponentiation, use Integer.parseInt for the power

        //TODO: Perform the operation, storing the result

        //TODO: Print the result of the operation in the proper format, e.g. "x + y = z"

        //TODO: Remove the this and the above TODO comments
    }

    /**
     * Called by the included test file. You do not need to run this method directly.
     * <strong>Do not</strong> modify this method.
     *
     * @param args Command-line arguments
     *             0: The input file path. (Required)
     *             1: Option to use "little" or "big" number parsing. (Required)
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                switch (args[1]) {
                    case "little":
                        parseLineUsingLittleNumber(line);
                        break;
                    case "big":
                        parseLineUsingBigNumber(line);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Expected 2 command-line arguments, got %d.%n", args.length);
        } catch (IOException e) {
            System.out.printf("Failed to read file %s.%n", args[0]);
        } catch (IllegalArgumentException e) {
            System.out.printf("Option %s is invalid, must be 'little' or 'big'.%n", args[1]);
        }
    }
}
