package com.hxx.demo;

import org.bouncycastle.util.encoders.Hex;

import java.util.Base64;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;

/**
 * <ul>
 * <li>功能说明：国密算法加解密示例（用于与 js 配合进行加解密）</li>
 * <li>作者：Tal on 2021\4\24 0024 23:53 </li>
 * </ul>
 */
public class SmDemoForJs {

    public static void main(String[] args) {
        createSM2KeyForJs();
        /**
         * 公钥：MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEuUnSjh78IqIl/R9LuL8mQ65fu8Y+9Re+8JzUionf33S1R7iJSyKhjtuiqwYkeEGVifN9PYcIphhH6MoLIEH/nA==
         * 公钥 Hex（用于前端加密）：04b949d28e1efc22a225fd1f4bb8bf2643ae5fbbc63ef517bef09cd48a89dfdf74b547b8894b22a18edba2ab062478419589f37d3d8708a61847e8ca0b2041ff9c
         * 私钥：MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg/XyvMXNA3Mi+psJz2z7OfUzUUh2vpXyniqSDkhC+/mugCgYIKoEcz1UBgi2hRANCAAS5SdKOHvwioiX9H0u4vyZDrl+7xj71F77wnNSKid/fdLVHuIlLIqGO26KrBiR4QZWJ8309hwimGEfoygsgQf+c
         */
        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQg/XyvMXNA3Mi+psJz2z7OfUzUUh2vpXyniqSDkhC+/mugCgYIKoEcz1UBgi2hRANCAAS5SdKOHvwioiX9H0u4vyZDrl+7xj71F77wnNSKid/fdLVHuIlLIqGO26KrBiR4QZWJ8309hwimGEfoygsgQf+c";
        String ciphertextFormJs = "04812c392f94c15ea46ead7eec7274027d06a25743ad4d7aa6db1491f623aa82e32a2af048580bb0d85925479869a8a20f929b4fd378a0370a779b2f8942389b8a29cf9f1f782debbe0a3a6eca7b3efe34c8864eec4c34501610c70aeb494b3d1a85c408ae03814ff08877011c";
        sm2DecryptForJs(privateKey, ciphertextFormJs);
    }

    /**
     * 创建 SM2 公私钥对
     */
    private static void createSM2KeyForJs() {
        SM2 sm2 = new SM2();
        System.out.println("公钥：" + sm2.getPublicKeyBase64());
        System.out.println("公钥 Hex（用于前端加密）：" + Hex.toHexString(sm2.getQ(false)));
        System.out.println("私钥：" + sm2.getPrivateKeyBase64());
    }

    /**
     * SM2 私钥解密
     *
     * @param privateKey
     * @param ciphertextFormJs
     */
    public static String sm2DecryptForJs(String privateKey, String ciphertextFormJs) {
        System.out.println("SM2 私钥解密");
        System.out.println("密文：" + ciphertextFormJs);
        SM2 sm2 = new SM2(privateKey, null);
        String plainText = new String(Base64.getDecoder().decode(sm2.decrypt(Hex.decode(ciphertextFormJs), KeyType.PrivateKey)));
        System.out.println("明文：" + plainText);
        return plainText;
    }


}


