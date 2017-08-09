package input;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * Utility methods for
 *   - getting validated integer and double input from user.
 *   - getting positive integer or double input from user.
 *   - turning yes/no responses into boolean values
 *   - String input - doesn't do much more than the basic scanner, but there for consistency
 */

public class InputUtils {
    
    
    static Scanner stringScanner = new Scanner(System.in);
        
    
    /** Print question, wait for user to type and press return, return the data entered.
     * @param question Text to print for the user
     * @return whatever user types as a String. */
    public static String stringInput(String question) {
        if (question != null) {
            System.out.println(question);
        }
        return stringScanner.nextLine();
    }
    
    /**  Wait for user to type and press return, return the data entered.
     *
     * @return the String the user types.  */
    public static String stringInput() {
        return stringInput(null);
    }
    
    
    
    /** Gets a double number from the user.
     *  Print question, wait for user to type and press return,
     *  verify data is a double, ask for input again if not.
     *
     * @param question A question to print for the user.
    @return the double value entered. */
    public static double doubleInput(String question) {
        
        while (true) {
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.println(question);
            }
            
            //Try to read what the user typed, expect it to be a double.
            try {
                // If the input can be read as a double, that double value will be returned
                // This ends the loop, and this method, and control returns to the calling method.
                
                String line = stringScanner.nextLine();
                return Double.parseDouble(line);
                
            } // if the input can't be read as a double, then an error will be raised.
            // That error can be 'caught' by this code, and we can print an error message.
            // Since we are inside a while loop, then the loop can repeat and ask the user for input again.
            catch (NumberFormatException nfe) {
                System.out.println("Error - please enter a number");
            }
            
        }
        
    }
    
    
    /** Gets a double number from the user.
     *  Wait for user to type and press return,
     *  Verify data is a double, ask for input again if not.
     *
     @return the double value entered. */

    public static double doubleInput() {
        return doubleInput(null);
    }
    
    /** Gets a double number from the user.
     *  Wait for user to type and press return,
     *  Verify data is a positive double, ask for input again if not.
     *  0 is considered positive.
     *
     @return the double value entered. */
    
    public static double positiveDoubleInput() { return positiveDoubleInput(null); }
    
    
    /** Gets a double number from the user.
     *  Wait for user to type and press return,
     *  Verify data is a positive double, ask for input again if not.
     *  0 is considered positive.
     *
     * @param question A question to print for the user.
     @return the double value entered. */
  
    public static double positiveDoubleInput(String question) {
        
        while (true) {
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.println(question);
            }
            
            //Try to read what the user typed, expect it to be a POSITIVE (0 or greater) double.
            try {
                // If the input can be read as a double, that double value will be returned
                // This ends the loop, and this method, and control returns to the calling method.
    
    
                String line = stringScanner.nextLine();
                double userInput = Double.parseDouble(line);
                if (userInput >= 0)  {
                    return userInput;
                }
                
                else {
                    throw new NumberFormatException(userInput + "is not valid. Number must be positive");
                }
                
            } // if the input can't be read as a double, then an error will be raised.
            // That error can be 'caught' by this code, and we can print an error message.
            // Since we are inside a while loop, then the loop can repeat and ask the user for input again.
            catch (NumberFormatException ne) {
                System.out.println("Error - please enter a positive number");
               
                /* If the value fetched from numberScanner.nextDouble can't be interpreted as a double,
                then that value is 'left' in the scanner, in case you wanted to try and read it with a numberScanner.nextLine()
                or other scanner method.
                So as your loop repeats, it keeps trying to read the same invalid data from the scanner.
                To fix, in the event of an exception, clear the invalid input with numberScanner.next()
                */
            }
        }
        
    }
    
    
    /** Asks user a question, waits for response, checks to make sure user enters a integer.
     *
     * @param question the question that will be displayed for the user
     * @return the int value entered. */
    public static int intInput(String question) {
        
        while (true) {
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.println(question);
            }
            
            //Try to read what the user typed as an int.
            try {
                // If the input can be read as a int, that int will be returned
                // This ends the loop, and this method, and control returns to the calling method.
                String line = stringScanner.nextLine();
                return Integer.parseInt(line);
    
    
            } // if the input can't be read as an int, then an error will be raised.
            // For example, if the user enters 'ten' or 1.4 or 123456543454343434, these are not ints, so will cause an error.
            // That error can be 'caught' by this code, and we can print an error message.
            // Since we are inside a while loop, then the loop can repeat and ask the user for input again.
            catch (NumberFormatException ime) {
                System.out.println("Error - please enter an integer number");
                //numberScanner.next();
                /* If the value fetched from numberScanner.nextInt can't be interpreted as a int,
                then that value is 'left' in the scanner, in case you wanted to try and read it with a
                numberScanner.nextLine() or numberScanner.nextDouble() or other scanner method.
                So as your loop repeats, it keeps trying to read the same invalid data from the scanner.
                To fix, in the event of an exception, clear the invalid input with numberScanner.next()
                */
            }
        }
        
    }
    
    /** Waits for user to type, checks to make sure user enters a integer.
     *
     * @return the int value entered. */
    
    public static int intInput() {
        return intInput(null);
    }
    
    
    /** Waits for user to type, checks to make sure user enters a positive integer.
     * 0 is considered positive.
     * @return the int value entered. */
    
    public static int positiveIntInput() {
        return positiveIntInput(null);
    }
    
    
    /** Asks user a question, waits for response, checks to make sure user enters a positive integer.
     * 0 is considered positive.
     * @return the int value entered. */

    public static int positiveIntInput(String question) {
        
        while (true) {
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.println(question);
            }
            
            //Try to read what the user typed as an int.
            try {
                // If the input can be read as a int, that int will be returned
                // This ends the loop, and this method, and control returns to the calling method.
                String line = stringScanner.nextLine();
                int userInput = Integer.parseInt(line);
                if (userInput >= 0) {
                    return userInput;
                } else {
                    throw new NumberFormatException(userInput + "is not valid. Number must be positive.");
                }
                
            } // if the input can't be read as an int, then an error will be raised.
            // For example, if the user enters 'ten' or 1.4 or 123456543454343434, these are not ints, so will cause an error.
            // That error can be 'caught' by this code, and we can print an error message.
            // Since we are inside a while loop, then the loop can repeat and ask the user for input again.
            catch (NumberFormatException ime) {
                System.out.println("Error - please enter a positive integer number");
                /* If the value fetched from numberScanner.nextInt can't be interpreted as a int,
                then that value is 'left' in the scanner, in case you wanted to try and read it with a
                numberScanner.nextLine() or numberScanner.nextDouble() or other scanner method.
                So as your loop repeats, it keeps trying to read the same invalid data from the scanner.
                To fix, in the event of an exception, clear the invalid input with numberScanner.next()
                */
            }
        }
        
    }
    
    
    /** Converts a Yes or No input to a boolean value
     *
     * @param question a question to print for the user
    @return "yes" or "y" or uppercase variants returns true
    "no" or "n" or uppercase variants return false
    All other inputs ask user to re-enter data
   
     */
   
    public static boolean yesNoInput(String question) {
        
        // Values that are considered to be a yes response
        ArrayList<String> yesValues = new ArrayList<String>();
        yesValues.add("yes"); yesValues.add("y");
        
        // Same for no responses
        
        ArrayList<String> noValues = new ArrayList<String>();
        noValues.add("no"); noValues.add("n");
        
        
        while (true) {
            
            // If user has provided a question, then print it for the user
            if (question != null) {
                System.out.print(question);
            }
            
            // Suggest expected responses
            System.out.println(" Y/N? ");
            
            String response = stringScanner.nextLine().toLowerCase();
            
            if (yesValues.contains(response)) {
                return true;
            }
            
            if (noValues.contains(response)) {
                return false;
            }
            
            // If the user input is not a yes or a no response, the loop will repeat.
            
        }
        
    }
    
    
    /** Converts a Yes or No input to a boolean value
  
     @return "yes" or "y" or uppercase variants returns true
     "no" or "n" or uppercase variants return false
     All other inputs ask user to re-enter data
     
     */
    
    
    
    public static boolean yesNoInput() {
        return yesNoInput(null);
    }
    
    
    
}



