package com.bjgoodwill.insurance.util;

import java.lang.reflect.Field;

import com.alibaba.fastjson.JSONObject;

/**
 * @Package: com.bjgoodwill.insurance.util
 * @author zhangq 
 * @date 2018年3月22日 下午7:35:27
 * 
 */
public class JsonHelper {

	@SuppressWarnings("rawtypes")
	public static JSONObject getJsonObject(Object obj) throws IllegalArgumentException, IllegalAccessException {
		
		JSONObject jsonObject = new JSONObject();
		
		// 得到类对象
        Class userCla = (Class) obj.getClass();
		/*
         * 得到类中的所有属性集合
         */
        Field[] fs = userCla.getDeclaredFields();
        for(int i = 0;i < fs.length;i++)
        {
            Field f = fs[i];
            // 设置些属性是可以访问的
            f.setAccessible(true); 
            // 得到此属性的值
            Object val = f.get(obj);
            jsonObject.put(f.getName(), val);
        }
		
		return jsonObject;
	}
}
