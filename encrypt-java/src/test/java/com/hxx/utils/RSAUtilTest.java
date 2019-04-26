package com.hxx.utils;

import java.security.NoSuchAlgorithmException;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/4/26 0026 17:51 </li>
 * <li>邮箱：houxiangxiang@cibfintech.com</li>
 * </ul>
 */
public class RSAUtilTest {
    public static void main(String[] args) throws Exception {
        genRSAKeyTest();

    }

    private static void genRSAKeyTest() throws NoSuchAlgorithmException {
        RSAKeyGenUtil.genKeyPair();
    }
}
