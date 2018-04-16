package com.bjgoodwill.insurance.consts;

/**
 * @Package: com.bjgoodwill.insurance.base.constant
 * @Description: 系统静态常量；命名规则：第一个单词是模块名，第二个单词是模型名
 * @author li_jun 
 * @date 2018年4月4日 下午2:45:26
 * @GUID {713c5906-b1ae-4e07-bd6f-286595801c5b}
 */
public interface SystemConstant {

    /**
     * 基于视图查询模式
     */
    public static final String  VIEW_MODEL               = "0";
    /**
     * 基于Http请求模式
     */
    public static final String  HTTP_MODEL               = "1";
    /**
     * 基于Http的get请求
     */
    public static final String  HTTP_REQUEST_METHOD_GET  = "get";
    /**
     * 基于Http的post请求
     */
    public static final String  HTTP_REQUEST_METHOD_POST = "post";
    /**
     * 模块编码键名，即外部请求数据中模块编码对应的键值
     */
    public static final String  MODEL_CODE_KEY           = "modelCode";
    /**
     * 患者基本信息模块编码
     */
    public static final String  PATIENT_MODEL_CODE       = "100";
    /**
     * 门诊就诊信息模块编码             
     */
    public static final String  OUTPATIENT_MODEL_CODE    = "101";
    /**
     * 住院入院信息模块编码             
     */
    public static final String  HOSPITALIZED_MODEL_CODE  = "102";
    /**
     * 费用信息模块编码             
     */
    public static final String  FEE_MODEL_CODE           = "103";
    /**
     * 病历信息模块编码             
     */
    public static final String  RECORD_MODEL_CODE        = "104";
    /**
     * 其他模块信息（检验、检查）编码             
     */
    public static final String  OTHER_MODEL_CODE         = "105";
    /**
     * 异常类型：本地异常日志
     */
    public static final Integer TYPE_LOCAL_LOG           = 0;
    /**
     * 异常类型：院端可查看日志
     */
    public static final Integer TYPE_BUSINESS_LOG        = 1;
    /**
     * 请求成功
     */
    public static final Integer REQUEST_SUCCESS          = 0;
    /**
     * 请求失败
     */
    public static final Integer REQUEST_FAIL             = 1;
    /**
     * 请求等待
     */
    public static final Integer REQUEST_WAITING          = 2;
}
