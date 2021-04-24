package com.hxx.demo;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.digest.SM3;

/**
 * <ul>
 * <li>功能说明：国密算法加解密示例（用于java后端加解密）</li>
 * <li>作者：Tal on 2021\4\24 0024 23:53 </li>
 * </ul>
 */
public class SmDemo {

    private static final byte[] SM3_SALT = "AABBCC112233".getBytes();

    public static void main(String[] args) {
        // 创建 SM2 公私钥对
        createSM2Key();

        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgXvCy40dLdzlGHkRSGPewU2xVMOfEIS30QkjNlhizZAugCgYIKoEcz1UBgi2hRANCAATlW8w8aYUvyeQiOk+hgzfIsi9K708gI8d17W3K6VARyJtZ3f8bUVxDZUZDbfhMCTvvKVRQuJrrhxrB8eGJ/pNd";
        String publicKey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE5VvMPGmFL8nkIjpPoYM3yLIvSu9PICPHde1tyulQEcibWd3/G1FcQ2VGQ234TAk77ylUULia64cawfHhif6TXQ==";
        String plainText = "abc123";
        // SM2 公钥加密
        String ciphertext = sm2Encrypt(publicKey, plainText);
        // SM2 私钥解密
        sm2Decrypt(privateKey, ciphertext);

        // SM3 取摘要
        SM3 sm3 = new SM3(SM3_SALT);
        System.out.println(sm3.digestHex(plainText));
    }

    /**
     * 创建 SM2 公私钥对
     */
    private static void createSM2Key() {
        SM2 sm2 = new SM2();
        System.out.println("公钥：" + sm2.getPublicKeyBase64());
        System.out.println("私钥：" + sm2.getPrivateKeyBase64());
    }

    /**
     * SM2 公钥加密
     *
     * @param publicKey
     * @param plainText
     */

    public static String sm2Encrypt(String publicKey, String plainText) {
        System.out.println("SM2 公钥加密");
        System.out.println("明文：" + plainText);
        SM2 sm2 = new SM2(null, publicKey);
        String ciphertext = sm2.encryptBase64(plainText, KeyType.PublicKey);
        System.out.println("密文：" + ciphertext);
        return ciphertext;
    }

    /**
     * SM2 私钥解密
     *
     * @param privateKey
     * @param ciphertext
     */
    public static String sm2Decrypt(String privateKey, String ciphertext) {
        System.out.println("SM2 私钥解密");
        System.out.println("密文：" + ciphertext);
        SM2 sm2 = new SM2(privateKey, null);
        String plainText = sm2.decryptStr(ciphertext, KeyType.PrivateKey);
        System.out.println("明文：" + plainText);
        return plainText;
    }

}
