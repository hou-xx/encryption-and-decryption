package com.hxx.utils;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/4/26 0026 17:51 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */
public class RSAUtilTest {
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn976TkK9i7pdOEPJ/9HpbjIcQnrwwXb6lD1Z5a3borpBqAcMgV2UjlxPCvMnI/BuWTkhVh2CJoGoS03a7yONb3NzJ11S1/VDWS8rMWFaAD0Qv7Pe6PuHvMEDx4rMQoXAfYqhRnSD/PbXzx85vPq2OclYxuNAzlnMoc/bt5b6W2uUKo+ZjjLIOwUhND0+pOj6VInRQ8weCkeIwUnpOY8vMu0fGn2mP2a/8H2R31q6ZOR2K2IcHt/9RcFMX13nLZaJQi6gFSCmLwVvTM0MPkcZqtbsjPzCVV4+mtVwVKkSk5BBx4y/qjbdrKpJf5Lwc4DWgSB3ILoFBJsAJjezOFOEgwIDAQAB";
    private static final String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCf3vpOQr2Lul04Q8n/0eluMhxCevDBdvqUPVnlrduiukGoBwyBXZSOXE8K8ycj8G5ZOSFWHYImgahLTdrvI41vc3MnXVLX9UNZLysxYVoAPRC/s97o+4e8wQPHisxChcB9iqFGdIP89tfPHzm8+rY5yVjG40DOWcyhz9u3lvpba5Qqj5mOMsg7BSE0PT6k6PpUidFDzB4KR4jBSek5jy8y7R8afaY/Zr/wfZHfWrpk5HYrYhwe3/1FwUxfXectlolCLqAVIKYvBW9MzQw+Rxmq1uyM/MJVXj6a1XBUqRKTkEHHjL+qNt2sqkl/kvBzgNaBIHcgugUEmwAmN7M4U4SDAgMBAAECggEALsSoLOTRVmL6ik8qdLAPvbDjG3+jlrUbsOoRtmMZ8YzTUDhfrCiYIN1YMjfXp2faoDdaTTrsrB8aAI2SEoswAP6hHU7rwUl6nkhyNkvobFFw6OPRvg53Mvy0AlfUUVGXciJv85B6XDJKB8l2tpYRYO5KDkTE3JjgiCWqfRapvrxPZn+aJ7z2xigr7eRjAZTvQOU++wEH7DW4UVPOL/RLyQ8h4rSjyb2n6yjMq+hC9GJg12Qrh6fwHgKGX5h9BYfnKZhfxOJIzfxVBkOAMzLGMgqLUqcirNOxklHUexPi0wOzmmH4t1uVXHXDI13KtQdXT2XChzn0pOvjqoO6kHB2wQKBgQDUa7qpOWniqOv8gctLtYDbN/NVcTz5qfrt20a1C/GKyMLnUflUZE5LpSk/wEdlRt3aF7d1DKtoC4E/cyTJhM+X0TmSIYsRCO6TfV9vVkVEc6fd3ZAlvMMNKdTGZtvUnDFJz4eYzY481UH0ptza7I8WrZgjdSyKobtzg58zi+qO+QKBgQDAq1maghbX9msntsRnZhZWeYRFqQFL1JthLHXUrp/IPEyTTjmQbAjIWkZh+Z8to0Te7I5b7IESIWDyWVuBIy7s70fuNVwJQtzeBNUXSexzJEQwo4i93y8p4jBgQ0E50J02DumaiGzZ/alkRG3l2L4z9YqLXWfTK7E75g/pbOrCWwKBgDB4LG10pk6L0N0bGLI7xh0/VQzH++vT92fSwv2IriLG0IJL2CKDiMIF+7WKQEBBvVmIU9one+0PwvwhX+GDpoKzwPkxIjRO33FUCDS1cLS/1yvu5HdX7QHR67Uhv0NyKGT5L62UKcKDvrr+YCKsG7JHBhIBKJqxcL5Y6Diw0mKxAoGARBoNEQUch/eNBruejqHSEXzgWTMUxzX+OgnaGHQk/ET8GDFVPYxCSndGW4k9T4dfZ6Cb7Tgao0rzFpapNms2Qf+OIE/yGT/uC/gPTi0OC+DszXhwdBS4egh+avg6zPHFL/9zaPEB8MetoUhixBSpnnoTH5HDiivueKqoQy0BifMCgYAXsyo9jwTy6n5r/vqYtWmoRAhdswfz9xgk8GSNgp94h9KEDJGbUi9a+YBEwuv/CQR04mXlxKkF1IDJ3nnQdUcI3iyGJiun++ZB1fiTZVftgEBbnH/q+P33cPLl37ap4ww7shh1c2iU/UQtsXqt2GeOZ1mL3yTY6B245jFC+lxBxw==";

    public static void main(String[] args) throws Exception {
//        genRSAKeyTest();
//        encryptTest();
        decryptTest();
    }

    private static void encryptTest() throws Exception {
        String plainText = "123abc";
        String ciphertext = RSAUtil.encrypt(PUBLIC_KEY, plainText);
        System.out.println("------------------------>");
        System.out.println("plainText --> " + plainText);
        System.out.println("ciphertext --> " + ciphertext);
        System.out.println("<------------------------");
    }

    private static void decryptTest() throws Exception {
        String ciphertext = "nA5K+5LSGS242KMhJZ+DGKQv3DpYigL88q+THLcy0872D+1BSv8JRMIrUCbKoVPMXfqFK8E1mhMzEZKiZudR+TJkgdWIxxhaE00SNuCpXQptntgu0Ej59k6fQlFELKj4SAnBc7mYeLcOBa1CXZYPzHLu1ms5W4ek3gjN5BkBz2tSTjOViwFIQmQoP3W3ltfbpIC7KPU0ppMjUVB/khIXZhqLk7b4pDXbxUTEIMjqZFlvJ/BVKBEdVMFIj0qVbFsJmdAA4sFt3xIFcbL4WoOUcKBOA7VeGguXUfyGYpU7GXXilUdLOFlJGYygXdGyTcrDUWP/S+iaaBRvAY0XNSHWsg==";
        Date dateStart = new Date();
        String plainText = RSAUtil.decrypt(PRIVATE_KEY, ciphertext);
        Date dateEnd = new Date();
        System.out.println("------------------------>");
        System.out.println("ciphertext --> " + ciphertext);
        System.out.println("plainText --> " + plainText);
        System.out.println("用时：" + (dateEnd.getTime() - dateStart.getTime()) + "ms");
        System.out.println("<------------------------");
    }

    private static void genRSAKeyTest() throws NoSuchAlgorithmException {
        RSAKeyGenUtil.genKeyPair();
    }
}
