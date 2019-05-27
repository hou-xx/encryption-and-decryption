package com.hxx.utils;

import java.util.Date;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/4/26 0026 17:51 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */
public class DESUtilTest {
    private static final String key = "houxiang";

    public static void main(String[] args) throws Exception {
//        encryptTest();
        decryptTest();
    }

    private static void encryptTest() throws Exception {

        String plainText = "123abc";
        Date dateStart = new Date();
        String ciphertext = DesUtil.encrypt(plainText, key);
        Date dateEnd = new Date();
        System.out.println("----------- encrypt ------------->");
        System.out.println("plainText --> " + plainText);
        System.out.println("ciphertext --> " + ciphertext);
        System.out.println("用时：" + (dateEnd.getTime() - dateStart.getTime()) + "ms");
        System.out.println("<---------------------------------");
    }

    private static void decryptTest() throws Exception {
        String ciphertext = "HyllCfEBRUc=";
        Date dateStart = new Date();
        String plainText = DesUtil.decrypt(ciphertext, key);
        Date dateEnd = new Date();
        System.out.println("----------- decrypt ------------->");
        System.out.println("ciphertext --> " + ciphertext);
        System.out.println("plainText --> " + plainText);
        System.out.println("用时：" + (dateEnd.getTime() - dateStart.getTime()) + "ms");
        System.out.println("<---------------------------------");
    }
}
