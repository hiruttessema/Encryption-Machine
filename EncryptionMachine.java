
package encryptionmachine;

import java.util.Scanner;

/**
 * The EncryptionMachine program implements an application
 * that encrypts a message with a key. It welcomes users and requires to enter the key
 * then asks for the number of words in the message and encrypts each words one by one. 
 * It only accepts accepts lower case letters.
 * At the end it displays encryption completion confirmation message.
 * 
 * @author Hirut Tessema
 * @version 1.0
 * @since 10/07/2021
 */
public class EncryptionMachine {
	
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static final int SHIFT = 3;
    
    /**
     * The encryptSingleLetter method encrypts single letter entered by users
	 * @param letter  single letter entered by users for encryption
	 * @return cipherLetter returns the encrypted letter
	 */
    public static char encryptSingleLetter(char letter) {

        int letterIndex = ALPHABET.indexOf(letter);

        int newLetterIndex = (letterIndex + SHIFT) % 26;

        char cipherLetter = ALPHABET.charAt(newLetterIndex);

        return cipherLetter;
        
    }
    
    /**
     * This is encryptWord method encrypts word entered by users
	 * @param word  the word the user enters for encryption
	 * @return String that includes the string "has been encrypted to" and the returned encrypted word
	 */
    public static String encryptWord(String word) {

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {

            char cipherWord = encryptSingleLetter(word.charAt(i));

            result.append(cipherWord);

        }

        return ("has been encrypted to: " + result);     
    }
    
    /**
     * The encryptMessage method implements the welcome message, user message encryption
     * and encryption completed message.
	 * @param obj accepts user input 
	 * @return void 
	 */
    public static void encryptMessage(Scanner obj) {
    	
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction." + "\n" 
        		           + "The program lets you encrypt a message" + "\n"
                            + "with a key for your recipient to decrypt!"+ "\n");
       
        System.out.println("Enter key: ");

    	String key = obj.next(); 
        
		String cipherKey = encryptWord(key);
		
		System.out.println("\"" + key + "\" " + cipherKey + "\n");
    	
        System.out.println("How many words is your message?:");
       
        String number = obj.next();
        
        int numberOfWords = Integer.parseInt(number);

        for (int i = 0; i < numberOfWords; i++) {
        	
        	System.out.println("Next word:");
        	
            String plainWord = obj.next();  

            String cipherWord = encryptWord(plainWord);

            System.out.println("\"" + plainWord + "\" " + cipherWord + "\n");

        }
        
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }

	/**
	 * This is the main method that uses the encryptMessage method.
	 * @param args command-line arguments
	 * @return void
	 */
    public static void main(String[] args) {

    	Scanner Obj = new Scanner(System.in);
    	
        encryptMessage(Obj);
        
    }
}
