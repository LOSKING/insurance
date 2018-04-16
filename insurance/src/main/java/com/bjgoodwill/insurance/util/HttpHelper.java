package com.bjgoodwill.insurance.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;

/**
 * @Package: com.bjgoodwill.insurance.util
 * @Decription Http请求工具类{653dd1f2-4fd3-4af6-96b6-0dac66917a4f}
 * @author zhangq 
 * @date 2018年3月26日 下午4:03:51
  */
public class HttpHelper {

    /**
     * 发送request请求
     * 
     * @param requestName 请求平台服务controller完整路径
     * @param method	     请求方式
     * @param paramKey 	     参数key
     * @param paramValue  参数value
     * @return 管道正常时，返回平台服务返回值；平台服务出问题时对应的返回错误信息，格式（Err:错误信息|e.getMessage()）
     * 		       例如：（Err:管道输入输出错误，或是管道连接平台服务失败|Connection refused: connect）
      */
    public static String request(String requestName, String method, String params) {
        HttpURLConnection conn = null;
        Reader reader = null;
        try {
            // 访问准备
            URL url = new URL(requestName);
            // 开始访问
            StringBuilder postData = new StringBuilder();
            postData.append(params);
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (int c; (c = reader.read()) >= 0;) {
                sb.append((char) c);
            }
            String response = sb.toString();
            return response;
        } catch (MalformedURLException e) {
            throw new BusinessException(BizExceptionEnum.CONNECT_SERVER_ERROR, e.getMessage());
            //			StringBuilder sBuilder = new StringBuilder();
            //			sBuilder.append("Err:").append("连接服务地址错误").append("|").append(e.getMessage());
            //			return sBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(BizExceptionEnum.CODE_CONVERT_ERROR, e.getMessage());
            //            StringBuilder sBuilder = new StringBuilder();
            //            sBuilder.append("Err:").append("编码转换错误").append("|").append(e.getMessage());
            //            return sBuilder.toString();
        } catch (IOException e) {
            throw new BusinessException(BizExceptionEnum.CONNECT_CHANNEL_ERROR, e.getMessage());
            //            StringBuilder sBuilder = new StringBuilder();
            //            sBuilder.append("Err:").append("输入输出错误，或是管道连接平台服务失败").append("|").append(e.getMessage());
            //            return sBuilder.toString();
        } catch (Exception e) {
            throw new BusinessException(BizExceptionEnum.OTHER_ERROR, e.getMessage());
            //            StringBuilder sBuilder = new StringBuilder();
            //            sBuilder.append("Err:").append("其它错误").append("|").append(e.getMessage());
            //            return sBuilder.toString();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    reader = null;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
    }

    /**
     * 验证url串是否合法
     * @param url 地址串
     * @return 布尔值
     */
    public static boolean validURL(String url) {
        String regEx = "^((https|http|ftp|rtsp|mms)?://)" +
                "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" +
                "(([0-9]{1,3}.){3}[0-9]{1,3}|" +
                "([0-9a-z_!~*'()-]+.)*" +
                "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]." +
                "[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
        String regEx1 = "^((/?)[_a-zA-Z0-9-]+)+(\\.[_a-zA-Z0-9-]+)?((/?)|((/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?))$";
        return url.matches(regEx) || url.matches(regEx1);
    }
}
