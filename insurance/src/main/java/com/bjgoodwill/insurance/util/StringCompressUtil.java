package com.bjgoodwill.insurance.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Package: com.bjgoodwill.insurance.util
 * @Description: 字符串压缩工具类
 * @author li_jun 
 * @date 2018年4月11日 上午10:36:18
 * @GUID {87ea1c4a-7ef1-42c7-8939-1139fe5b0d48}
 */
public class StringCompressUtil {

    /**
     * @Title: compress
     * @Description: 压缩
     * @param  参数说明
     * @return byte[]    返回值说明
     * @throws
     */
    public static final byte[] compress(String paramString) {
        if (paramString == null){
            return null;            
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        ZipOutputStream zipOutputStream = null;
        byte[] arrayOfByte;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            zipOutputStream.putNextEntry(new ZipEntry("0"));
            zipOutputStream.write(paramString.getBytes());
            zipOutputStream.closeEntry();
            arrayOfByte = byteArrayOutputStream.toByteArray();
        } catch (IOException localIOException5) {
            arrayOfByte = null;
        } finally {
            if (zipOutputStream != null){
                try {
                    zipOutputStream.close();
                } catch (IOException localIOException6) {}
                
            }
            if (byteArrayOutputStream != null){
                
                try {
                    byteArrayOutputStream.close();
                } catch (IOException localIOException7) {}
            }
        }
        return arrayOfByte;
    }

    /**
     * @Title: decompress
     * @Description: 解压
     * @param  参数说明
     * @return String    返回值说明
     * @throws
     */
    public static final String decompress(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null){
            
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ZipInputStream zipInputStream = null;
        String str;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
            zipInputStream = new ZipInputStream(byteArrayInputStream);
            zipInputStream.getNextEntry();
            byte[] arrayOfByte = new byte[1024];
            int i = -1;
            while ((i = zipInputStream.read(arrayOfByte)) != -1){
                byteArrayOutputStream.write(arrayOfByte, 0, i);
                
            }
            str = byteArrayOutputStream.toString();
        } catch (IOException localIOException7) {
            str = null;
        } finally {
            if (zipInputStream != null){
                
                try {
                    zipInputStream.close();
                } catch (IOException localIOException8) {}
            }
            if (byteArrayInputStream != null){
                
                try {
                    byteArrayInputStream.close();
                } catch (IOException localIOException9) {}
            }
            if (byteArrayOutputStream != null){
                
                try {
                    byteArrayOutputStream.close();
                } catch (IOException localIOException10) {}
            }
        }
        return str;
    }
}
