package com.bjgoodwill.insurance.util;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.bjgoodwill.insurance.consts.SecurityConst;

/**
 * AES加解密工具
 *
 * @author za-wanggang 2017/8/2 10:21
 */
public class AesUtil {
    /**
     * AES加密
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != SecurityConst.AES_KEY_LEN) {
            return null;
        }

        byte[] raw = sKey.getBytes(SecurityConst.ASE_CHARSET);
        SecretKeySpec sKeySpec = new SecretKeySpec(raw, SecurityConst.AES_KEY_SPEC);

        // "算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance(SecurityConst.AES_CIPHER_PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(SecurityConst.ASE_CHARSET));

        return encrypted;
    }

    /**
     * AES解密
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }

            // 判断Key是否为16位
            if (sKey.length() != SecurityConst.AES_KEY_LEN) {
                System.out.print("Key长度不是16位");
                return null;
            }

            byte[] raw = sKey.getBytes(SecurityConst.ASE_CHARSET);
            SecretKeySpec sKeySpec = new SecretKeySpec(raw, SecurityConst.AES_KEY_SPEC);
            Cipher cipher = Cipher.getInstance(SecurityConst.AES_CIPHER_PROVIDER);
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
            // 先用base64解密+
            byte[] encrypted1 = sSrc;
            try {
                byte[] original = cipher.doFinal(encrypted1);
                return original;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
