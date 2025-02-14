package pet_shelter.dev_code;

import java.io.*;
import java.util.*;

class PasswordSecurityManager {

    //Vars

    private static String path = "../../../resources/security/Key.txt";

    private static File file = new File(path);
    private static String key;

    //Encoding Methods
   
    /**
     * Generates encryption key, encrypts and returns input str, and stores encryption key.
     * @param String str String to be encrypted
     * @return String encrypted string
     **/
    public static String encrypt(String str){
        if(key == null){
            generateKey();
        }
        while(str.length() > key.length()){
            key = key + key;
            stoKey();
        }
        String encrypted = "";
        String[] cypher = key.split("");
        for(int i = 0; i < str.length(); i++){
            encrypted += Character.toString((char)((int)(str.charAt(i)) - Integer.parseInt(cypher[i])));
        }
        return encrypted;
    }

    /**
     * Fetches encryption key, decrypts and returns input string
     * @param String str String to be decrypted
     * @return String string decrypted string
     **/
    public static String decrypt(String str){
        if(key == null){
            fetchKey();
        }
        String decrypted = "";
        String[] cypher = key.split("");
        for(int i = 0; i < str.length(); i++){
            decrypted += Character.toString((char)((int)(str.charAt(i)) + Integer.parseInt(cypher[i])));
        }
        return decrypted;
    }

    //Key Methods

    /**
     * Generates encryption key and stores to file
     **/
    private static void generateKey(){
        key = "";
        for(int i = 0; i < (int)(Math.random() * 100) + 50; i++){
            key += (int)(Math.random() * 10) + "";
        }
        stoKey();
    }

    //File Methods

    /**
     * Stores encryption key to file
     **/
    private static void stoKey(){
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.close();
            writer = new FileWriter(file, true);
            writer.write(key);
            writer.close();
        } catch (IOException e){
            System.out.println("Error in PasswordSecurityManager.stoKey()");
        }
    }

    /**
     * Fetches encryption key from file and stores to key variable
     **/
    private static void fetchKey(){
        try {
            Scanner scan = new Scanner(file);
            key = scan.nextLine();
            scan.close();
        } catch (FileNotFoundException e){
            System.out.println("Error in PasswordSecurityManager.fetchKey()");
        }
    }
    
    /**
     * Main method for PasswordSecurityManager file
     **/
    public static void main(String[] args){
        String str = "Hello, World!";
        String enc = encrypt(str);
        String dec = decrypt(enc);
        System.out.print(str + " => " + enc + " => " + dec);
    }

}
