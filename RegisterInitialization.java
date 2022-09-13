/*
 * Java Program to initialize registers in A5/1 Stream cipher.
 * Author:
 * 
 * Changes required: * Make appropriate change at lines 13, 14, 15, 16.
 *                   * Implement the the required loadRegisters() function at line 37.
 */
import java.util.Scanner;

public class RegisterInitialization {

    private String key = null;
    static final int KEY_LENGTH = ; //Enter the key length in bits
    static final int LENGTH_REG_X = ; //Enter the length of the X register
    static final int LENGTH_REG_Y = ; //Enter the length of the Y register
    static final int LENGTH_REG_Z = ; //Enter the length of the Z register

    static int[] registerX = new int[LENGTH_REG_X];
    static int[] registerY = new int[LENGTH_REG_Y];
    static int[] registerZ = new int[LENGTH_REG_Z];

    
    boolean setKey(String key) {
        if (key.length() == 64) {
         this.key = key;
         this.loadRegisters(key);
         return true;
        }
        return false;
    }
    
    String getKey() {
        return this.key;
    }
    
    
    void loadRegisters(String key) {

        /* 
        
           The string 'key' is 64 chars long and contains the user supplied 64-bit key.
           Split the key string into 3 parts and fill it sequentially into the respective registers.
           For example, if the X, Y and Z registers are 4, 5 and 6 bits long, and the key is 15 bits long, the 
           first 4 bits belong to the X register, the next 5 bits in the Y register and the last 6 bits in the Z 
           register.  
           
           HINTS: While not an absolute necesscity, one of the ways to implement this is to use FOR loops for each register 
           along with a substring function from the string class to split each char, and then using the parseInt() function 
           of the Integer Class to convert the string/char to an integer and store it one by one in the required Register.
           
           Example 64-bit key: 1010101010101010101110011001100110011000111100001111000011110001

           Sample Output: 
           Input a 64-bit key: 
           1010101010101010101110011001100110011000111100001111000011110001

           Register X
           1010101010101010101
           Register Y
           1100110011001100110001
           Register Z
           11100001111000011110001
           
        */
        
     }

    public static void main(String[] args) throws Exception {

        RegisterInitialization a51 = new RegisterInitialization();
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter a 64-bit key: ");

	    while (a51.getKey() == null) {
	    if (!a51.setKey(scanner.nextLine()))
		    System.out.println("Make sure input is a 64-bit binary value");
	    }
        
        System.out.println();
        System.out.println("Register X");
        for(int i=0; i<LENGTH_REG_X;i++)
        System.out.print(registerX[i]);
        
        System.out.println();
        System.out.println("Register Y");
        for(int i=0; i<LENGTH_REG_Y;i++)
        System.out.print(registerY[i]);

        System.out.println();
        System.out.println("Register Z");
        for(int i=0; i<LENGTH_REG_Z;i++)
        System.out.print(registerZ[i]);

        scanner.close();
    }
}
       
