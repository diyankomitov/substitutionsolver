package main;

import java.util.Map;

public class Decryptor {

    /**
     * Decrypts a given cipher with the given key and returns the decrypted plaintext
     * @param cipher the cipher to decrypt
     * @param key the key to use which is a Map of letters to letters. The key map must have assigned
     *            values for all characters that are in the cipher aka no cipher letter can be assigned to null
     * @return returns the decrypted plaintext
     */
    public static String decrypt(String cipher, Map<Character, Character> key) {

        char[] plainText = cipher.toCharArray();


        for (int i = 0; i < plainText.length; i++) {
            System.out.println(plainText[i]);
            plainText[i] = key.get(plainText[i]);
        }

        return new String(plainText);
    }
}
