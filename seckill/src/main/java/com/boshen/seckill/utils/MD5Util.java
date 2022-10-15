package com.boshen.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt="la2b3c4d";
//salt.charAt(0) + salt.charAt(2) + salt.charAt(3) + salt.charAt(5) + inputPass
    public static String inputPassToFromPass(String inputPass){
        String str = inputPass;
        return md5(str);
    }
    public static String formPassToDBPass(String formPass, String salt) {
        String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        String dbPass = formPassToDBPass(fromPass, salt);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        System.out.println("e4332af42e3640df495b82f8a68b198c".equals(""));
    }
}
