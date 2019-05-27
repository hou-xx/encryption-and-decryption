package com.hxx.utils;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/5/27 0027 14:18 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */
public class DesUtil {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String plaintext = "huehgaui4eghuigeuhia";
        // 密码长度必须是8的倍数
        String password = "Xysh2019";
        System.out.println("密　钥：" + password);
        System.out.println("加密前：" + plaintext);
        Date date = new Date();
        String result = encrypt(plaintext, password);
        Date date1 = new Date();
        System.out.println("加密后：" + result);
        System.out.println("加密用时：" + (date1.getTime() - date.getTime()) + "ms");
        String decryResult = decrypt(result, password);
        Date date2 = new Date();
        System.out.println("解密后：" + decryResult);
        System.out.println("解密用时：" + (date2.getTime() - date1.getTime()) + "ms");
    }

    /**
     * 加密
     *
     * @param plaintext 待加密内容
     * @param key       加密的密钥
     * @return
     */
    public static String encrypt(String plaintext, String key) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            return base64Encode(cipher.doFinal(plaintext.getBytes()));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param ciphertext 待解密内容
     * @param key        解密的密钥
     * @return
     */
    public static String decrypt(String ciphertext, String key) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            byte[] result = cipher.doFinal(base64Decode(ciphertext));
            return new String(result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 此为 jdk 1.8 的实现，可替换为其它实现
     *
     * @param data
     * @return
     * @throws IOException
     */
    private static byte[] base64Decode(String data) throws IOException {
        long t = new Date().getTime();
        byte[] decode = Base64.getDecoder().decode(data);
        System.out.println("base64Decode 用时：" + (new Date().getTime() - t) + "ms");
        return decode;
    }

    private static String base64Encode(byte[] data) {
        long t = new Date().getTime();
        String encode = Base64.getEncoder().encodeToString(data);
        System.out.println("base64Encode 用时：" + (new Date().getTime() - t) + "ms");
        return encode;
    }
}
