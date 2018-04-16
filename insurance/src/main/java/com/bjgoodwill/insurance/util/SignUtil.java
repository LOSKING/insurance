package com.bjgoodwill.insurance.util;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.consts.SecurityConst;

/**
 * 加签加密验签解密工具类
 *
 * @author daiqing.ydq
 */
public class SignUtil {
    /**
     * 签名参数生成
     * @param selfPrivateKey 我方私钥
     * @param targetPublicKey 对方公钥
     * @param param 参数
     * @return 签名之后的JSON格式参数
     * @throws Exception
     */
    public static String paramSign(String selfPrivateKey, String targetPublicKey ,String param)throws Exception {
        String encodeRules = getRandomString(SecurityConst.AES_KEY_LEN);
        byte[] enContent = AesUtil.encrypt(param, encodeRules);
        byte[] enKey = RsaUtil.encryptByPublicKey(encodeRules.getBytes(), targetPublicKey);
        String sign = RsaUtil.sign(enContent, selfPrivateKey);
        JSONObject object = new JSONObject();
        object.put(SecurityConst.JSON_KEY_CONTENT, Base64Util.encode(enContent));
        object.put(SecurityConst.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
        object.put(SecurityConst.JSON_KEY_ENCODE_RULES, Base64Util.encode(enKey));
        object.put(SecurityConst.JSON_KEY_SIGN,sign);
        String json = object.toJSONString();

        //log.debug(">>>加签加密后："+json);
        return json;
    }

    /**
     * 签名校验
     * @param content 接收到的数据
     * @param selfPrivateKey 我方私钥
     * @param targetPublicKey 对方公钥
     * @return 解密后的数据
     * @throws Exception 验签失败
     */
    public static String checkSign(String content,String selfPrivateKey,String targetPublicKey)throws Exception {
        JSONObject parse = JSON.parseObject(content);
        byte[] byteContent = Base64Util.decode(parse.getString(SecurityConst.JSON_KEY_CONTENT));
        String sign = parse.getString(SecurityConst.JSON_KEY_SIGN);
        Long timestamp = parse.getLong(SecurityConst.JSON_KEY_TIMESTAMP);
        byte[] encodeRules = Base64Util.decode(parse.getString(SecurityConst.JSON_KEY_ENCODE_RULES));
        long now = System.currentTimeMillis();

        // 3秒之内请求
        //if((now - timestamp) > SecurityConst.REQUEST_TIMEOUT){
        //    throw new RuntimeException("非法请求");
        //}
        boolean verify = RsaUtil.verify(byteContent, targetPublicKey, sign);
        if(!verify){
            throw new RuntimeException("验签失败");
        }
        byte[] bytesKey = RsaUtil.decryptByPrivateKey(encodeRules, selfPrivateKey);

        byte[] decodeContent = AesUtil.decrypt(byteContent, new String(bytesKey));
        String strDecodeContent = new String(decodeContent, SecurityConst.ASE_CHARSET);
        return strDecodeContent;
    }

    /**
     * 生成指定长度随机串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String base = SecurityConst.RANDOM_BASE_STR;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
