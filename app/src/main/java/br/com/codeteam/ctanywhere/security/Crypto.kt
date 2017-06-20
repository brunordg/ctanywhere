package br.com.codeteam.ctanywhere.security

import android.util.Base64

import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.AlgorithmParameterSpec

import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * Classe de criptografia utilizada o método AES256
 * Created by bruno on 01/03/17.
 */
object Crypto {

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
    @Throws(NoSuchPaddingException::class, NoSuchAlgorithmException::class, InvalidAlgorithmParameterException::class, InvalidKeyException::class, BadPaddingException::class, IllegalBlockSizeException::class)
    fun encrypt(text: String, key: String): String {
        val ivSpec = IvParameterSpec(ByteArray(16))
        val secretKey = SecretKeySpec(key.toByteArray(), "AES")

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec)

        return String(Base64.encode(cipher.doFinal(text.toByteArray()), Base64.CRLF))
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
    @Throws(NoSuchPaddingException::class, NoSuchAlgorithmException::class, InvalidAlgorithmParameterException::class, InvalidKeyException::class, BadPaddingException::class, IllegalBlockSizeException::class)
    fun decrypt(text: String, key: String): String {
        val ivSpec = IvParameterSpec(ByteArray(16))
        val secretKey = SecretKeySpec(key.toByteArray(), "AES")

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec)

        //return new String(cipher.doFinal(Base64.decodeBase64(text.getBytes())));
        return String(cipher.doFinal(Base64.decode(text.toByteArray(), Base64.CRLF)))
    }

    /**
     * Retorna uma chave de 64 bytes, inicialmente será usada para encryptar os dados do Realm.
     * @return byte[]
     */
    val key: ByteArray
        get() {
            val key = ByteArray(64)
            SecureRandom().nextBytes(key)
            return key
        }
}
