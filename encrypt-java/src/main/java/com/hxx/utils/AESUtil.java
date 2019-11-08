package com.hxx.utils;

import java.nio.charset.Charset;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/4/26 0026 17:28 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
public class AESUtil {
    public static final String KEY_ALGORITHM = "AES";
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static final Charset UTF8 = Charset.forName("UTF-8");

    public static byte[] encrypt(String data, String key) throws Exception {
        return encrypt(data.getBytes(UTF8), key.getBytes(UTF8));
    }

    public static byte[] encrypt(String data, byte[] key) throws Exception {
        return encrypt(data.getBytes(UTF8), key);
    }

    public static byte[] encrypt(byte[] data, String key) throws Exception {
        return encrypt(data, key.getBytes(UTF8));
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        Key k = genSecretKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(String data, String key) throws Exception {
        return decrypt(data.getBytes(UTF8), key.getBytes(UTF8));
    }

    public static byte[] decrypt(String data, byte[] key) throws Exception {
        return decrypt(data.getBytes(UTF8), key);
    }

    public static byte[] decrypt(byte[] data, String key) throws Exception {
        return decrypt(data, key.getBytes(UTF8));
    }

    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        Key k = genSecretKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    /**
     * AES only supports key sizes of 16, 24 or 32 bytes
     */
    public static Key genSecretKey(byte[] key) throws Exception {
        if (key.length == 16 || key.length == 24 || key.length == 32) {
            return new SecretKeySpec(key, KEY_ALGORITHM);
        }
        throw new IllegalArgumentException("AES only supports key sizes of 16, 24 or 32 bytes");
    }
}
