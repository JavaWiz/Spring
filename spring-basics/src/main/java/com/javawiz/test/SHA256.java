package com.javawiz.test;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
  
public class SHA256 { 
    public static String encryptThisString(String input) 
    { 
        try { 
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8)); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16);
            
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        } catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
}