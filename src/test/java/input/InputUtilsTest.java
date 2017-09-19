package input;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static input.InputUtils.*;
import static input.CatchStandardOut.catchStandardOut;
import static input.CatchStandardOut.resetStandardOut;
import static org.junit.Assert.*;

/**
 * Created by clara on 8/9/17.
 */
public class InputUtilsTest {
    
    private static double delta = 0.000001;
    
    @org.junit.Test
    public void testStringInput() throws Exception {
        
        String data = "User response";
        String data2 = "More user data";
        
        String in = data + "\n";
        
        replaceInputUtilScanner(in);
        
        assertEquals(data, stringInput());
    
        in = data2 + "\n";
        
        replaceInputUtilScanner(in);
        
        assertEquals(data2, stringInput());
        
    }
    
    @org.junit.Test
    public void testStringInputMessage() throws Exception {
        String data = "User response";
        
        replaceInputUtilScanner(data);
        
        String message = "This should be printed";
        catchStandardOut();
        assertEquals(data, stringInput(message));
        String out = resetStandardOut();
        assertTrue(out.contains(message));
    }
    
    @org.junit.Test
    public void testDoubleInputValid() throws Exception {
    
        // User types in valid data
        Double[] validData = {5.0, 0.0, -5.0, 00343245354345.0};
        String validInput = joinWithNewlines(validData);
        
        System.out.println(validInput);
        
        replaceInputUtilScanner(validInput);
        
        for (double data : validData) {
            System.out.println("data");
            assertEquals(data, doubleInput(), delta);
        }
    
    }
    
    @org.junit.Test
    public void testDoubleInputInvalid() throws Exception {
        
        // Invalid things; all together
        String[] invalidInputs = {"5 5", "qwerty", "23sdf"};
        double finalValid = 6.6;
        String invalidInputsFollowedByValid = joinWithNewlines(invalidInputs);

        invalidInputsFollowedByValid += finalValid;
        invalidInputsFollowedByValid += "\n";   //So loop ends, eventually

        //setStandardIn(invalidInputsFollowedByValid);
        ByteArrayInputStream mockIn = new ByteArrayInputStream(invalidInputsFollowedByValid.getBytes());
        InputUtils.scanner = new Scanner(mockIn);

        assertEquals(finalValid, doubleInput(), delta);
        
    }
    
    @org.junit.Test
    public void testDoubleInputMessage() throws Exception {
        double data = 123.556;
        String inData = data + "\n";
        
        replaceInputUtilScanner(inData);

        String message = "This should be printed";
        catchStandardOut();
        assertEquals(data, doubleInput(message), delta);
        String out = resetStandardOut();
        assertTrue(out.contains(message));
    }

    @org.junit.Test
    public void testPositiveDoubleInputValid() throws Exception {

        // User types in valid data, 0 or greater
        Double[] validData = {5.0, 0.0, 45.0, 67.323, 00343245354345.0, 6783542.23456734554};
        String validInput = joinWithNewlines(validData);
    
        replaceInputUtilScanner(validInput);
        
        for (double data : validData) {
            assertEquals(data, positiveDoubleInput(), delta);
        }

    }


    @org.junit.Test
    public void testPositiveDoubleInputInvalid() throws Exception {

        // Invalid things; all together

        String[] invalidInputs = {"5 5", "-5", "-10345345354", "qwerty", "23sdf"};
        double finalValid = 6.6;
        String invalidInputsFollowedByValid = joinWithNewlines(invalidInputs);

        invalidInputsFollowedByValid += finalValid;
        invalidInputsFollowedByValid += "\n";   //So loop ends, eventually

        replaceInputUtilScanner(invalidInputsFollowedByValid);
        assertEquals(finalValid, positiveDoubleInput(), delta);

    }

    @org.junit.Test
    public void testPositiveDoubleInputMessage() throws Exception {
        double data = 123.556;
        replaceInputUtilScanner(data + "\n");
        String message = "This should be printed";
        catchStandardOut();
        assertEquals(data, positiveDoubleInput(message), delta);
        String out = resetStandardOut();
        assertTrue(out.contains(message));
    }

    @org.junit.Test
    public void testIntInputValid() throws Exception {

        // User types in valid data
        Integer[] validData = {5, 0, -5, 003445354345};
        String validInput = joinWithNewlines(validData);

        replaceInputUtilScanner(validInput);
 
        for (int data : validData) {
            assertEquals(data, intInput());
        }

    }

    @org.junit.Test
    public void testIntInputMessage() throws Exception {
        
        replaceInputUtilScanner( 6 + "\n");
    
        String message = "This should be printed";
        catchStandardOut();
        assertEquals(6, intInput(message));
        String out = resetStandardOut();
        assertTrue(out.contains(message));

    }

    @org.junit.Test
    public void testPositiveIntInput() throws Exception {

        // Invalid things; all together

        String[] invalidInputs = {"5 5", "-45", "-10345345354", "qwerty", "23sdf"};
        int finalValid = 6;

        String invalidInputsFollowedByValid = joinWithNewlines(invalidInputs);

        invalidInputsFollowedByValid += finalValid;
        invalidInputsFollowedByValid += "\n";   //So loop ends, eventually

        replaceInputUtilScanner(invalidInputsFollowedByValid);
        assertEquals(finalValid, positiveIntInput());


    }

    @org.junit.Test
    public void testPositiveIntInputMessage() throws Exception {
        replaceInputUtilScanner( 6 + "\n");
    
        String message = "This should be printed";
        catchStandardOut();
        assertEquals(6, positiveIntInput(message));
        String out = resetStandardOut();
        assertTrue(out.contains(message));
    }

    @org.junit.Test
    public void testYesNoInputYesValid() throws Exception {

        boolean expected = true;
        String[] inputs = { "Y", "yes", "y", "YES", "yeS"} ;
        String inputString = joinWithNewlines(inputs);
        replaceInputUtilScanner(inputString);

        for (String y : inputs) {
            assertEquals(expected, yesNoInput());
        }

    }

    @org.junit.Test
    public void testYesNoInputNoValid() throws Exception {

        boolean expected = false;
        String[] inputs = { "N", "no", "NO", "n", "nO"} ;
        String inputString = joinWithNewlines(inputs);
        replaceInputUtilScanner(inputString);

        for (String n : inputs) {
            assertEquals(expected, yesNoInput());
        }

    }

    @org.junit.Test
    public void testYesNoInputYesAndNoValid() throws Exception {

        boolean[] expected = { false, true, false, true, true, false};
        String[] inputs = { "N", "Y", "NO", "Y", "yEs", "n"} ;
        String inputString = joinWithNewlines(inputs);
        replaceInputUtilScanner(inputString);

        for (boolean e : expected) {
            assertEquals(e, yesNoInput());
        }

        
    }



    @org.junit.Test
    public void testYesNoInputInvalid() throws Exception {

        // bunch of invalid stuff followed by final valid response
        String[] inputs = { "Nope", "234567", "tacos", "y y", "y n", "yiss", "y"} ;
        String inputString = joinWithNewlines(inputs);
        replaceInputUtilScanner(inputString);

        boolean expected = true;

        assertEquals(expected, yesNoInput());

    }

    @org.junit.Test
    public void testYesNoInputMessage() throws Exception {
    
        replaceInputUtilScanner( "yes" + "\n");
    
        String message = "This should be printed";
        catchStandardOut();
        assertTrue(yesNoInput(message));
        String out = resetStandardOut();
        assertTrue(out.contains(message));
    
    
    }

    
    @org.junit.Test
    public void testCombination() throws Exception {
        
        // Numbers, strings, numbers, strings...
        
        String data = joinWithNewlines(4, "Hello", 1234.345, "Bye!");
        replaceInputUtilScanner(data);
        
        assertEquals(intInput(), 4);
        assertEquals(stringInput(), "Hello");
        assertEquals(doubleInput(), 1234.345, 0.001);
        assertEquals(stringInput(), "Bye!");
        
    }
    

    private String joinWithNewlines(Object... data) {
        StringBuilder out = new StringBuilder();
        for (Object s : data) {
            out.append(s);
            out.append("\n");
        }

        return out.toString();
    }
    
    
    
    private void replaceInputUtilScanner(String data) {
        ByteArrayInputStream mockIn = new ByteArrayInputStream(data.getBytes());
        InputUtils.scanner = new Scanner(mockIn);
    
    }
    
    
    
    

}