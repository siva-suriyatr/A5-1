After finishing Excercise 2, copy the entire code from KeyStreamGen.java to another file and name it - 'A51Encryption.java'. Make sure to change
the name of the class to A51Encryption so that the code works! (Java expects the Class name and the name of the file to be the same)

1. Add the following function to aid with decryption

    public String toStr(String binary) {
	StringBuilder s = new StringBuilder();
	for (int i = 0; i <= binary.length() - 8; i += 8)
	 s.append((char) Integer.parseInt(binary.substring(i, i + 8), 2));
	return s.toString();
 }


2. Replace the main() function with the following code into 'A51Encryption.java'.
    
    public static void main(String[] args) {

        A51Encryption A51 = new A51Encryption();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string to be encrypted.");
        String plaintext = scanner.nextLine();

        int[] input = A51.toBinary(plaintext);
        int[] ks_bits = A51.getKeystream(input.length);
        System.out.println("Plaintext is - "+ plaintext);
        int [] ciphertext = new int [input.length];

        /* Final task (a) Encryption
        *
        *1) Create an encrypt() function that takes both input[] and ks_bits[] as input and returns the ciphertext in the form of an int [].
        *
        *2) Call the function. (HINT: Code would look somewhat along the lines of ciphertext = classInstance.encrypt(input,ks_bits); )
        *
        *3) If done correctly. the rest of the process of displaying output to the terminal has been impelmented already and should work. 
        */

        ciphertext = A51.encrypt(input,ks_bits);

        System.out.println("The corresponding ciphertext is - ");
        for(int i=0; i< ciphertext.length; i++)
        System.out.print(ciphertext[i]);

        int [] decrypted_text = new int [ciphertext.length];

        /* Final task (b) Decryption
        *
        *1) Create an decrypt() function that takes both ciphertext[] and ks_bits[] as input and returns the decrypted text in the form of an int [].
        *
        *2) Call the function. (HINT: Code would look somewhat along the lines of decrypted_text = classInstance.decrypt(ciphertext,ks_bits); )
        *
        *3) If done correctly. the rest of the process of displaying output to the terminal has been impelmented already and should work. 
        */
        
        decrypted_text = A51.decrypt(ciphertext,ks_bits);
        System.out.println("\nThe decrypted plaintext is - ");
        for(int i=0; i< decrypted_text.length; i++)
        System.out.println(decrypted_text[i]);
        String lol = Arrays.toString(decrypted_text).replaceAll("\\[|\\]|,|\\s", "");;
        System.out.println(A51.toStr(lol));

        scanner.close();
    }

3. Add "import java.util.Arrays;" to the top of the file. 

4. (Optional) Add this comment snippet to aid with clarity at the top of the new file.
/*
 * Java Program to implement A5/1 Encryption and Decryption functions.
 * Author:
 * 
 * Changes required: * Implement functions to perform encryption and decryption operations. More information is provided in the main function.
 *                    
 * Sample Output:
 * Enter the string to be encrypted.
 * CSEC 604
 *
 * Plaintext is - CSEC 604
 *
 * The corresponding ciphertext is -
 * 1000000000100000101001011111001100011010100010101010010100100101
 *
 * The decrypted plaintext in binary form is -
 * 0100001101010011010001010100001100100000001101100011000000110100
 *
 * The decrypted plaintext in translated to String form is -
 * CSEC 604 
 * 
 */