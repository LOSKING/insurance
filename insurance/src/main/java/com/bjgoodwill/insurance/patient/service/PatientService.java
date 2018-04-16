package com.bjgoodwill.insurance.patient.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.service.BaseService;
import com.bjgoodwill.insurance.patient.model.PatientModel;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package: com.bjgoodwill.insurance.patient.service
 * @Descripetion:患者基本信息
 * @author zhangq 
 * @date 2018年3月22日 下午6:34:24
 * 
 */
public interface PatientService extends BaseService<PatientModel> {

    /**
     * @Title: getByPrimaryKey
     * @Description: 根据患者id获取患者信息
     * @param  参数说明
     * @return PatientModel    患者基本信息
     */ 
    PatientModel getByPrimaryKey(String patientId);

    /**
     * @Title: getHisDataByView
     * @Description: 根据视图查询患者基本信息
     * @param  参数说明
     * @return String    患者基本信息
     * @throws
     */
    String getHisDataToView(JSONObject jsonObject);

    /**
     * @Title: getHisDataByHttp
     * @Description: 基于Http请求查询患者基本信息
     * @param  settingModel 单个配置实体
     * @return String    患者基本信息
     * @throws
     */
    String getHisDataToSetting(SettingModel settingModel, JSONObject jsonObject);

    /**
     * @Title: getHisDataByHttp
     * @Description: 基于Http请求查询患者基本信息
     * @param  settingModels 多个配置实体
     * @return String    患者基本信息
     * @throws
     */
    String getHisDataToSettingList(List<SettingModel> settingModels, JSONObject jsonObject);
}
