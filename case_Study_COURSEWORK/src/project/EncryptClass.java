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
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @encrytionAuthor Narayanaswamy
 * @avaiable https://narayanatutorial.com/java-tutorial/java-security/how-to-encrypt-and-decrypt-password-in-java
 */
public class EncryptClass {//Encrypt AES
    //key : 
    private static  String KEY = "7D764C9798662E1E53B6808EEC9B868D";
    /*- later- Try to find a way to use a dinamic key for each password -*/
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
     * @return plain text -> AEStype- string, Decrypt
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
    private static String setEncryptedPassword(String password) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        //String key 256AES = "7D764C9798662E1E53B6808EEC9B868D";
        


        byte[] bytekey = hexStringToByteArray(EncryptClass.KEY);
        SecretKeySpec sks = new SecretKeySpec(bytekey, EncryptClass.AES);
        Cipher cipher = Cipher.getInstance(EncryptClass.AES);
        cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
        byte[] encrypted = cipher.doFinal(password.getBytes());
        String encryptedpwd = byteArrayToHexString(encrypted);
        
        return encryptedpwd;
        
    
    }
    
    
    /**
     * private
     * Generate a key for encryption string in AES
     * not in use - later use
     * @return {key}: 128 bytes Key
     */ 
    
    private static String generateKey128() throws NoSuchAlgorithmException{
        KeyGenerator keyGen = KeyGenerator.getInstance(EncryptClass.AES);
        keyGen.init(128);
        SecretKey sk = keyGen.generateKey();
        String key = byteArrayToHexString(sk.getEncoded());
        return key;
    
    }

    
    
    public static String setPassword2Hash(String password){//String reading fails
    
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
    
    
    public static String getPlainText(String encrypPW){
        
        try {
            return getPlainPassword(encrypPW);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(EncryptClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
   
    
}
