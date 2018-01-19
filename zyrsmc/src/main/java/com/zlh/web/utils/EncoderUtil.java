package com.zlh.web.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class EncoderUtil {

    private static String public_key="12345678";
    
    // 加密
    public static String encry(String painStr) {
        String enString=painStr;
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(public_key.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 现在，获取数据并加密
            // 正式执行加密操作
            for(int i=0;i<=2;i++){
                enString= new sun.misc.BASE64Encoder().encode(cipher.doFinal(enString.getBytes()));
            }
        } catch (Exception e) {

        }
        return enString;
    }

    // 解密
    public static String decry(String entryStr) {
        String deString=entryStr;
        try {
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(public_key.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            for(int i=0;i<=2;i++){
                deString= new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(deString)));
            }
        } catch (Exception e) {

        }
        return deString;
    }

    public static void main(String[] args) {
        try {
            System.out.println(EncoderUtil.encry("320320"));
            System.out.println(EncoderUtil.decry(EncoderUtil.encry("Abc123")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
