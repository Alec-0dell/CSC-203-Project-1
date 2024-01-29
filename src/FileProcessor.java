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
     * @throws IOException 
     */
    public static void parseLineUsingLittleNumber(String line){
        String[] arguments = line.replaceAll("^ +| +$|( )+", "$1").split(" ");

        if(arguments.length != 3){
            return;
        }
        LittleNumber result;
        switch (arguments[1]){
            case "+":
                result = LittleNumber.add(LittleNumber.fromString(arguments[0]), LittleNumber.fromString(arguments[2]));
                break;
            case "*":
                result = LittleNumber.multiply(LittleNumber.fromString(arguments[0]), LittleNumber.fromString(arguments[2]));
                break;
            case "^":
                result = LittleNumber.exponentiate(LittleNumber.fromString(arguments[0]), Integer.parseInt(arguments[2]));
                break;
            default:
                return;
        }

        System.out.println(arguments[0] + " " + arguments[1] + " " + arguments[2] + " = " + result);
    }

    /**
     * Automatically called multiple times when parsing an input text file, once for each line.
     * The included tests control whether the LittleNumber or BigNumber version is used.
     *
     * @param line The line from the input file, including any newline characters
     */
    public static void parseLineUsingBigNumber(String line) {
        String[] arguments = line.replaceAll("^ +| +$|( )+", "$1").split(" ");

        if(arguments.length != 3){
            return;
        }
        BigNumber result;
        switch (arguments[1]){
            case "+":
                result = BigNumber.fromString(arguments[0]).addition( BigNumber.fromString(arguments[2]));
                break;
            case "*":
                result = BigNumber.fromString(arguments[0]).multiplication(BigNumber.fromString(arguments[2]));
                break;
            case "^":
                result = BigNumber.fromString(arguments[0]).exponentiation(Integer.parseInt(arguments[2]));
                break;
            default:
                return;
        }

        System.out.println(arguments[0] + " " + arguments[1] + " " + arguments[2] + " = " + result);
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
