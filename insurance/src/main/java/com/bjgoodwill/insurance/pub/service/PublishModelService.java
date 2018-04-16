package com.bjgoodwill.insurance.pub.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Package: com.bjgoodwill.insurance.pub.service
 * @Description: 对外提供的接口，分别获取各模块整合信息
 * @author li_jun 
 * @date 2018年4月8日 下午4:36:40
 * @GUID {0b585eb2-3226-455a-98a4-b0d856cff9ba}
 */
public interface PublishModelService {

    /**
     * @Title: getPatientInfo
     * @Description: 患者基本信息
     * @return String    整合信息，由JsonObject转为String
     */
    public String getPatientInfo(JSONObject requestJson);

    /**
     * @Title: getOutPatientInfo
     * @Description: 门诊就诊信息
     * @return String    整合信息，由JsonObject转为String
     */
    public String getOutPatientInfo(JSONObject requestJson);

    /**
     * @Title: getHospitalizedInfo
     * @Description: 住院入院信息
     * @return String    整合信息，由JsonObject转为String
     */
    public String getHospitalizedInfo(JSONObject requestJson);

    /**
     * @Title: getFeeInfo
     * @Description: 费用信息
     * @return String    整合信息，由JsonObject转为String
     */
    public String getFeeInfo(JSONObject requestJson);

    /**
     * @Title: getRecordInfo
     * @Description: 病历信息
     * @return String    整合信息，由JsonObject转为String
     */
    public String getRecordInfo(JSONObject requestJson);

    /**
     * @Title: getOtherInfo
     * @Description: 其他模块信息（检验、检查）
     * @return String    整合信息，由JsonObject转为String
     */
    public String getOtherInfo(JSONObject requestJson);
}
