package com.bjgoodwill.insurance.consts;
/**
 * 安全工具常量
 *
 * @author daiqing.ydq
 */
public interface SecurityConst {
    int AES_KEY_LEN = 16;

    String ASE_CHARSET = "UTF-8";
    String AES_KEY_SPEC = "AES";
    String AES_CIPHER_PROVIDER = "AES/ECB/PKCS5Padding";

    String RSA_KEY_ALGORITHM = "RSA";
    String RSA_SIGNATURE_ALGORITHM = "MD5withRSA";
    String RSA_PUBLIC_KEY = "RSAPublicKey";
    String RSA_PRIVATE_KEY = "RSAPrivateKey";
    int RSA_MAX_ENCRYPT_BLOCK = 117;
    int RSA_MAX_DECRYPT_BLOCK = 128;

    String JSON_KEY_CONTENT = "content";
    String JSON_KEY_ENCODE_RULES = "encodeRules";
    String JSON_KEY_TIMESTAMP = "timestamp";
    String JSON_KEY_SIGN = "sign";

    int REQUEST_TIMEOUT = 3000;

    String RANDOM_BASE_STR = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 文件读取缓冲区大小
     */
    int BASE64_CACHE_SIZE = 1024;

    String API_CONF_KEY_LEN = "keyLength";
    String API_CONF_KEY_WORK_MODE = "workMode";
    String API_CONF_KEY_WORK_PADDING = "padding";

    String API_AES_KEY_LEN = "128";
    String API_CRYPT_CHARSET = "utf-8";
    String API_DATA_ENC_ALG = "KeyCenter_AES";
    String API_AES_WORKING_MODE = "CBC";
    String API_AES_WORKING_PADDING = "PKCS5Padding";
}
