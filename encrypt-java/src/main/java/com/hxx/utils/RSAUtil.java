package com.hxx.utils;

import com.hxx.Const;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * <ul>
 * <li>功能说明： </li>
 * <li>作者：tal on 2019/4/26 0026 17:32 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
public class RSAUtil {

    private static final String RSA_ALGORITHM = "RSA";

    public static String encrypt(String publicKey, String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, loadPublicKey(publicKey));
        return base64Encode(cipher.doFinal(plainText.getBytes(Const.DEAULT_CHARSET)));
    }

    public static String decrypt(String privateKey, String pwd) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, loadPrivateKey(privateKey));
        return new String(cipher.doFinal(base64Decode(pwd)), Const.DEAULT_CHARSET);
    }

    /**
     * 从字符串中加载公钥
     */
    private static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
        byte[] buffer = base64Decode(publicKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    private static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] buffer = base64Decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }

    /**
     * 此为 jdk 1.8 的实现，可替换为其它实现
     *
     * @param data
     * @return
     * @throws IOException
     */
    private static byte[] base64Decode(String data) throws IOException {
        return Base64.getDecoder().decode(data);
    }

    private static String base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
}
