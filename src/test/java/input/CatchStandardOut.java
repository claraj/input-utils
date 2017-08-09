package input;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by clara on 8/9/17.
 */
public class CatchStandardOut {
    
    static PrintStream out;
    static ByteArrayOutputStream bytesOut;
    
    static PrintStream originalOut = System.out;
    
    public static void catchStandardOut() {
        
        bytesOut = new ByteArrayOutputStream();
        out = new PrintStream(bytesOut);
        System.setOut(out);
        
    }
    
    public static String resetStandardOut() {
        System.setOut(originalOut);
        return bytesOut.toString();
    }
}
