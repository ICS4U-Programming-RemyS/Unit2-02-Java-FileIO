import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

/**
* The FileIO program will read from the input.txt file with integers,
* decimal and non numerics on each line.
* It will then try to convert each of the different data types
* from a string to an integer.
* If it is successful, it will add the integer to the sum and
* display the sum of the integers on the line.
* If it is not successful, it will display an error message.
* If there are no integers on the line, it will display an error message.
* It will then write the output to the output.txt file.
*
* @author Remy Skelton
* @version 1.0
* @since 2025-03-07
*/

final class FileIO {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output String
        String outputStr = "";

        // Initialize the sum to 0
        int sum = 0;

        // Create a file writer object to write to the output file
        FileWriter myWriter = new FileWriter("./Unit2-02-output.txt");

        // Create a file object to read the input file
        File file = new File("./Unit2-02-input.txt");

        // Create a scanner object to read the file
        Scanner scanner = new Scanner(file);

        // While loop to run until there is another line in the file
        while (scanner.hasNextLine()) {

            // set the sum to 0 for each line
            sum = 0;

            // Initialize numValidInt
            int numValidInt = 0;

            // Read the line from the file
            String line = scanner.nextLine();

            // Display the line
            System.out.println(line);

            // Split the line into an array of strings
            String[] arrayNumString = line.split(" ");

            // Loop through the array for valid integers
            for (String numAsString : arrayNumString) {
                // Convert the string to an integer
                try {
                    // Declare and initialize the number as a integer
                    int numAsInt = Integer.parseInt(numAsString);
                    // Add the integer to the sum
                    sum += numAsInt;

                    // If the integer is valid
                    numValidInt += 1;
                // Catch non-numeric and decimal values
                } catch (Exception exception) {
                    // Error message
                    outputStr += (numAsString + " is not an valid integer. \n");
                }
            }

            // If statement to check if there are no valid integers
            if (numValidInt == 0) {
                // Error message
                outputStr += "Error: no integers were found on this line.\n";
                // Add new line to output string
                outputStr += "\n";
            } else {
                // Display the sum of the valid numbers on the line
                outputStr += "The sum of the valid numbers is "
                + Integer.toString(sum) + "\n";
                // Add a new line for spacing
                outputStr += "\n";
            }
        }

        // Write the output string to the file
        myWriter.write(outputStr);

        // Added a new line at end of output file
        System.out.println("");

        // Display that the file was written to successfully
        System.out.println("Wrote to the file successful.");

        // Close the file writer
        myWriter.close();
        // Close the scanner
        scanner.close();
    }
}
