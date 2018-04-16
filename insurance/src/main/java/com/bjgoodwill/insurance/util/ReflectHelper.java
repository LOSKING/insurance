package com.bjgoodwill.insurance.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.bjgoodwill.insurance.util
 * @Decription 反射工具类{653dd1f2-4fd3-4af6-96b6-0dac66917a4f}
 * @author zhangq
 * @date 2018年3月26日 下午5:08:42
 */
public class ReflectHelper {

    /**
     * 反射调用方法
     * 
     * @param className
     *            完整包名（含类名）
     * @param methodName
     *            方法名
     * @param parameterTypes
     *            方法参数类型
     * @param args
     *            参数
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static Object run(String className, String methodName, Class<?>[] parameterTypes, Object... args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        // String className = "com.bjggodwill.insurance.util.DataHelper;
        // String methodName = "getAge";
        // parameterTypes = java.util.Date
        // args = birthday
        Class<?> clz = Class.forName(className);
        Method m;
        Object result = "";
        // 创建新实例
        Object obj = clz.newInstance();
        // 判断形参
        if (parameterTypes.length <= 0) {
            // 获取方法
            m = obj.getClass().getDeclaredMethod(methodName);
            // 反射执行方法
            result = m.invoke(obj);
        } else {
            // 获取方法
            m = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
            // 反射执行方法
            result = m.invoke(obj, args);
        }
        return result;
    }

    /**
     * 反射调用方法
     * 
     * @param methodName
     *            方法完整包名
     * @param parameterTypes
     *            方法参数类型
     * @param args
     *            参数
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static Object run(String methodName, Class<?>[] parameterTypes, Object... args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException {
        // String methodName =
        // "com.bjggodwill.insurance.util.DataHelper.getAge";
        // parameterTypes = java.util.Date
        // args = birthday
        String className = methodName.substring(0, methodName.lastIndexOf("."));
        methodName = methodName.substring(methodName.lastIndexOf(".") + 1, methodName.length());
        return run(className, methodName, parameterTypes, args);
    }

    /**
     * 反射调用方法
     * 
     * @param methodName
     *            方法完整包名(包含参数)
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws ParseException
     */
    public static Object run(String methodName)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException, ParseException {
        // String methodName =
        // "com.bjggodwill.insurance.util.DataHelper.getAge(java.util.Date
        // birthday)";
        // com.bjggodwill.insurance.util.DataHelper
        String className = methodName.substring(0, methodName.indexOf("("));
        className = className.substring(0, className.lastIndexOf("."));
        // getAge(java.util.Date birthday)
        methodName = methodName.substring(className.length() + 1, methodName.length());
        // java.util.Date birthday
        String param = methodName.substring(methodName.indexOf("(") + 1, methodName.indexOf(")"));
        // getAge
        methodName = methodName.substring(0, methodName.indexOf("("));
        String[] params = param.split(",");
        List<Class<?>> classList = new ArrayList<Class<?>>();
        List<Object> argList = new ArrayList<Object>();
        for (int i = 0; i < params.length; i++) {
            String paramStr = params[i];
            // 循环删除开始的空格
            while (paramStr.startsWith(" ")) {
                paramStr = paramStr.substring(1, paramStr.length());
            }
            String[] classStr = paramStr.split(" ");
            classList.add(Class.forName(classStr[0]));
            switch (classStr[0]) {
                case "java.util.Date":
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    argList.add(format.parse(classStr[1]));
                    break;
                case "java.lang.String":
                    argList.add(new String(classStr[1]));
                    break;
                case "java.lang.Integer":
                    argList.add(new Integer(classStr[1]));
                    break;
                case "java.lang.Double":
                    argList.add(Double.parseDouble(classStr[1]));
                    break;
                case "java.lang.Boolean":
                    argList.add(Boolean.parseBoolean(classStr[1]));
                    break;
                case "java.lang.Short":
                    argList.add(Short.parseShort(classStr[1]));
                    break;
                default:
                    argList.add(new String(classStr[1]));
                    break;
            }
            // if (classStr[0].equals("java.util.Date")) {
            // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // argList.add(format.parse(classStr[1]));
            // }
        }
        // System.out.println("className:" + className);
        // System.out.println("methodName:" + methodName);
        // System.out.println("param:" + param);
        // System.out.println("classList.size:" + classList.size());
        // for (Iterator iterator = classList.iterator(); iterator.hasNext();) {
        // Class object = (Class) iterator.next();
        // System.out.println(object.getName());
        // }
        // System.out.println("argList.size:" + argList.size());
        // for (Iterator iterator = argList.iterator(); iterator.hasNext();) {
        // Object object = (Object) iterator.next();
        // System.out.println(object.toString());
        // }
        return run(className, methodName, classList.toArray(new Class[classList.size()]), argList.toArray());
    }

    /**
     * 获取类中所有属性
     * 
     * @param className 类名，完整包
     * @return
     * @throws ClassNotFoundException
     */
    public static Field[] getObjectFields(String className) throws ClassNotFoundException {
        Class<?> clz = Class.forName(className);
        Field[] fields = clz.getDeclaredFields();
        return fields;
    }

    /**
     * 获取类中所有方法
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    public static Method[] getObjectMethods(String className) throws ClassNotFoundException {
        Class<?> clz = Class.forName(className);
        Method[] methods = clz.getDeclaredMethods();
        return methods;
    }

    /**
     * 获取属性名数组
     * 
     * @param propertyStr 属性名字符串
     * @return
     */
    public static String[] getMethodFromPropertyName(String propertyStr) {
        return propertyStr.split("\\|");
    }

    /**
     * 获取属性名Map
     * 
     * @param properties 属性名数组
     * @return 属性名Map<实体内属性, 接口数据中属性>
     */
    public static HashMap<String, String> getPropertyMap(String[] properties) {
        HashMap<String, String> propertyMap = new HashMap<>();
        for (String property : properties) {
            String[] strings = property.split("=");
            propertyMap.put(strings[0], strings[1]);
        }
        return propertyMap;
    }

   /* // 把一个字符串的第一个字母大写、效率是最高的、
    private static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }*/

    /**
     * 通过反射获取接口泛型Model所指的具体泛型的类型
     * @param clazz
     * @return
     */
    public static Class<?> getSuperClassGenericType(Class<?> clazz) {
        Type genType = clazz.getGenericSuperclass();//得到泛型父类  
        //如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class  
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的Type对象的数组,数组里放的都是对应类型的Class   
        Type[] parameters = ((ParameterizedType) genType).getActualTypeArguments();
        for (Type t : parameters) {
            if (t.getTypeName().endsWith("Model")) {
                return (Class<?>) t;
            }
        }
        return Object.class;
    }
}
