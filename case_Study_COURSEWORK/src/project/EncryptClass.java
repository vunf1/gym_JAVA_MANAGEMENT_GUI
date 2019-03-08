/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Narayanaswamy
 * @version https://narayanatutorial.com/java-tutorial/java-security/how-to-encrypt-and-decrypt-password-in-java
 */
public class EncryptClass {//Encrypt AES
    //key : 
    private static  String KEY = "8D1EECA816447188D02655C2AA8F831FE62B9DB43A7B761BD744184C3AA0DF34";
    /*- Try to find a way to use a dinamic key for each password -*/
    public static final String AES = "AES";

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    private static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }
    
    
    
    /**
     *
     *  Decrypt hash
     * @param hashpassword : String
     * @return plain text pw
     */
    private static String getPlainPassword(String hashpassword) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
    
        byte[] bytekey = hexStringToByteArray(EncryptClass.KEY);
        SecretKeySpec sks = new SecretKeySpec(bytekey, EncryptClass.AES);
        Cipher cipher = Cipher.getInstance(EncryptClass.AES);
        cipher.init(Cipher.DECRYPT_MODE, sks);
        byte[] decrypted = cipher.doFinal(hexStringToByteArray(hashpassword));
        String OriginalPassword = new String(decrypted);
        
        return OriginalPassword.toString();
        
    }
    
    /**
     *
     *  Encrypt
     * @param password : String
     * @return password to hashpassword
     */
    private static String setEncryptedPassword(String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
        //String key = "DB99A2A8EB6904F492E9DF0595ED683C";
        


        byte[] bytekey = hexStringToByteArray(EncryptClass.KEY);
        SecretKeySpec sks = new SecretKeySpec(bytekey, EncryptClass.AES);
        Cipher cipher = Cipher.getInstance(EncryptClass.AES);
        cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
        byte[] encrypted = cipher.doFinal(password.getBytes());
        String encryptedpwd = byteArrayToHexString(encrypted);
        
        return encryptedpwd;
        
    
    }
    
    
    /**
     *
     * Generate a key for encryption
     * @return {key}: 256 bytes Key
     * 
     */
    private static String generateKey256() throws NoSuchAlgorithmException{
        KeyGenerator keyGen = KeyGenerator.getInstance(EncryptClass.AES);
        keyGen.init(256);
        SecretKey sk = keyGen.generateKey();
        String key = byteArrayToHexString(sk.getEncoded());
        return key;
    
    }

    
    
    public static String setPassword2Hash(String password){
    
        try {
            return setEncryptedPassword(password);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
        //String key = "DB99A2A8EB6904F492E9DF0595ED683C";
        //String password = "Admin";
        /*System.out.println(KEY);
        
        String encrypPW=setPassword2Hash("m");
        System.out.println(encrypPW);
        
        System.out.println(getPlainPassword(encrypPW));*/
        
        
    }
}
