package com.codeteam.ctanywhere.security;

import android.util.Base64;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Classe de criptografia utilizada o método AES256
 * Created by bruno on 01/03/17.
 */
public class Crypto {

    /**
     * Método para criptografar uma String
     * @param text
     * @param key
     * @return String
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encrypt(String text, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(new byte[16]);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        //return new String(Base64.encodeBase64(cipher.doFinal(text.getBytes())));
        return new String(Base64.encode(cipher.doFinal(text.getBytes()), Base64.CRLF));
    }

    /**
     * Método para decriptografar uma String
     * @param text
     * @param key
     * @return String
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String decrypt(String text, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(new byte[16]);
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        //return new String(cipher.doFinal(Base64.decodeBase64(text.getBytes())));
        return new String(cipher.doFinal(Base64.decode(text.getBytes(), Base64.CRLF)));
    }
}
