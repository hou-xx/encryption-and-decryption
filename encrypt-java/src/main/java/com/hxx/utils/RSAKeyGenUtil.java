package com.hxx.utils;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/4/26 0026 17:32 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */
public class RSAKeyGenUtil {

    private static final String RSA_ALGORITHM = "RSA";
    private static final int KEYSIZE = 2048;

    public static void genKeyPair() throws NoSuchAlgorithmException {

        // RSA算法要求有一个可信任的随机数源
        SecureRandom secureRandom = new SecureRandom();

        // 为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        // 利用上面的随机数据源初始化这个KeyPairGenerator对象
        keyPairGenerator.initialize(KEYSIZE, secureRandom);
        // 生成密匙对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 得到公钥
        Key publicKey = keyPair.getPublic();
        // 得到私钥
        Key privateKey = keyPair.getPrivate();
        byte[] publicKeyBytes = publicKey.getEncoded();
        byte[] privateKeyBytes = privateKey.getEncoded();
        // 公钥
        String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKeyBytes);
        // 私钥
        String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKeyBytes);
        System.out.println("------------------------>");
        System.out.println("publicKeyBase64 --> " + publicKeyBase64);
        System.out.println("privateKeyBase64 --> " + privateKeyBase64);
        System.out.println("<------------------------");
    }


}
