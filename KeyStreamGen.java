/*
 * Java Program to implement the A51 stream cipher.
 * Author:
 * 
 * Changes required: * Make appropriate change at line 33.
 *                   * Implement Stepping for Register Y at line 53 (Observe how stepping for Register X is done from line 37).
 *                   * Implement Stepping for Register Z at line 70 (Observe how stepping for Register X is done from line 37).
 *                   * Implement the prescribed changed at line 88
 *                   * Implement the a function to find and return the greatest among 3 numbers at line 94.
 * Sample Output: 
 * Enter the length of the KeyStream required.
 * 10
 * 1100001101
 */
import java.util.Scanner;;
public class KeyStreamGen {

    int [] registerX = new int [] {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
    int [] registerY = new int [] {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1};
    int [] registerZ = new int [] {1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1};


    int[] getKeystream(int length) {
        int[] regX = this.registerX.clone();
        int[] regY = this.registerY.clone();
        int[] regZ = this.registerZ.clone();
        int[] keystream = new int[length];

        for (int i = 0; i < length; i++) {
         
        /* Replace *'s with the required bits that need to be compared
           HINT: Arrays indices start from 0 and not from 1.
        */
         int maj = this.getMajority(regX[*] , regY[*] , regZ[*]); 
         
         /* If Register X needs to be stepped */
         // ^ is the XOR Operator
         if (regX[8] == maj) {

            /* Calculating New First bit after stepping for Register X 
             * 
             *Note that the First Bit formula changes based on which register is involved.
             *
            */
            int newStart = regX[13] ^ regX[16] ^ regX[17] ^ regX[18]; 
            int[] temp = regX.clone();
            for (int j = 1; j < regX.length; j++)
             regX[j] = temp[j - 1];
            regX[0] = newStart;
         }
    
         /* If Register Y needs to be stepped */
         // ^ is the XOR Operator
         if (regY[10] == maj) {
            /* a) Calculating New First bit after stepping for Register Y
             * 
             * Note that the First Bit formula changes based on which register is involved.
             *
             * b) Copy integer array by cloning regY using clone() function
             * 
             * c) Assign new values from index 1 to last index of Register Y from the temp array using a FOR loop.
             * 
             * d) Assign the 0th index of Register Y from the calculated first bit from (a).
             * 
             * HINT: Look at Register X's stepping above for help.
            */
         }
    
         /* If Register Z needs to be stepped */
         // ^ is the XOR Operator
         if (regZ[10] == maj) {
            /* a) Calculating New First bit after stepping for Register Z
             * 
             * Note that the First Bit formula changes based on which register is involved.
             *
             * b) Copy integer array by cloning regZ using clone() function
             * 
             * c) Assign new values from index 1 to last index of Register Y from the temp array using a FOR loop.
             * 
             * d) Assign the 0th index of Register Z from the calculated first bit from (a).
             * 
             * HINT: Look at Register X's stepping above for help.
            */
         }
         
        /* Replace *'s with the required bits for Keystream Bit generation.
        */
         keystream[i] = regX[*] ^ regY[*] ^ regZ[*]; 

        }
        return keystream;
     }
    
     private int getMajority(int x, int y, int z) {
        /*
         * Write a function to return the greatest among the 3 arguments.
         * Function should return an integer.
         */
     }
    
     public int[] toBinary(String text) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
         String temp = Integer.toBinaryString(text.charAt(i));
         for (int j = temp.length(); j < 8; j++)
            temp = "0" + temp;
         s.append(temp);
        }
        String binaryStr = s.toString();
        int[] binary = new int[binaryStr.length()];
        for (int i = 0; i < binary.length; i++){
         binary[i] = Integer.parseInt(binaryStr.substring(i, i + 1));
         System.out.println(binary[i]);
         
        }
        return binary;
     }
    public static void main(String[] args) throws Exception {

      KeyStreamGen ks = new KeyStreamGen();
      Scanner scanner = new Scanner(System.in);
	   System.out.println("Enter the length of the KeyStream required.");
      int ks_length = scanner.nextInt();
      int[] output = ks.getKeystream(ks_length);
      for(int i=0; i<output.length; i++)
      System.out.print(output[i]);
      scanner.close();

    }
}
