import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * The SortedStack class is an extension of Stack<Integer> <br>
 * - add() will always sort the Stack when adding a new Integer <br>
 * - static methods to create a SortedStack from user input are provided
 */
public class SortedStack extends Stack<Integer> {

    /**
     * Add an element to the SortedStack. The stack will remain sorted after the addition
     * 
     * @param i The Integer to add to the SortedStack
     * 
     * @return true
     */
    @Override
    public boolean add(Integer i) {
        super.add(i);
        this.sort(Comparator.<Integer>naturalOrder());
        
        return true;
    }

    /**
     * Get whitespace separated Integers from the user, continuously prompting the user until an input
     * containing at least one Integer value is specified. (Example: "1", "0 1", "2 1 10 21")
     * 
     * @return A SortedStack object gauranteed to be in ascending Integer order
     */
    public static SortedStack getIntsFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Prompt the user for a list of ints separated by whitespace and get the raw string input
            System.out.print("Please enter a list of ints, separated by a space. (Example \"0 1 2...\"): ");
            String raw_input = scanner.nextLine();

            // Attempt to convert the raw string input into a SortedStack of ints
            try {
                // If the attempt to convert the raw input to a SortedStack doesn't throw, the input was valid
                SortedStack list_to_return = parseInput(raw_input);
                scanner.close();
                return list_to_return;
            } catch (Exception e) {
                // Print an error message and re-prompt the user for input
                System.err.println("Exception occured while parsing input: " + e);
                System.err.println("Please try again");
                // Implicit continue
            }
        }
    }

    /** 
     * An inner method of parseInput used to validate user provided input to be a whitespace separated list of integer values.
     * 
     * @throws IllegalArgumentException if the input was empty
     * @throws NumberFormatException if a non-numeric element is detected - These exceptions are meant to be handled internally by getIntsFromUser()
     * 
     * @return A SortedStack created based on the user's input
     */
    private static SortedStack parseInput(String raw_input) {
        // Split the input string into a list of whitespace separated substrings, and attempt to 
        // convert each one to an int. If one is not valid, an exception will be thrown and parsing will end
        SortedStack list_to_return = new SortedStack();
        for (String piece : raw_input.split("\\s+")) {            
            try {
                list_to_return.add(Integer.parseInt(piece));
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("Non numeric piece of int array \"" + piece + "\" found while parsing input");
                throw e;
            }
        }

        // Return the input if is not empty
        if (!list_to_return.isEmpty()) {
            return list_to_return;
        } else {
            throw new IllegalArgumentException("Input must not be an empty int array");
        }
    }
}