package main;

import java.util.Map;

public class Decryptor {

    /**
     * Decrypts a given cipher with the given key and returns the decrypted plaintext
     * @param cipher the cipher to decrypt
     * @param key the key to use which is a Map of letters to letters
     * @return returns the decrypted plaintext
     */
    public static String decrypt(String cipher, Map<Character, Character> key) {

        String plainText = cipher;

        for (Character letter : key.keySet()){

            plainText = plainText.replace(letter, key.get(letter));
        }

        return plainText;
    }

}
