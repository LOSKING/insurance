package com.bjgoodwill.insurance.base.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.main.setting.model.SettingModel;

/**
 * @Package  com.bjgoodwill.insurance.base
 * @Decription 基础服务类
 * @author li_jun
 * @date 2018年3月28日 下午4:06:39
 * @GUID {dc4531e0-360a-4dcd-a991-ac3fc665505b}
 */
public interface BaseService<Model> {

    /**
     * @Title  convertToModel
     * @Description  将采集到的数据转换成领域模型数据
     * @param setting 单条配置实体
     * @return String    返回值说明
     * @throws
      */
    public String convertToModel(SettingModel settingModel);

    /**
     * @Title convertToModel
     * @Description  将采集到的数据转换成领域模型数据
     * @param settings 多条配置实体
     * @return String    返回值说明
     * @throws
      */
    public String convertToModel(List<SettingModel> settingModels);

    /**
     * @Title  getModelInfo
     * @Description 获取模型信息
     * @param  interfceMode 接口方式（0：视图，1：web）
     * @param  requestJson 外部请求参数
     * @param  settingModels 配置实体，如果接口方式为 0 ，则该参数为null
     * @return String    将模型数据转换成String返回
     * @throws BusinessException
     */
    public String getModelInfo(String interfceMode, JSONObject requestJson, List<SettingModel> settingModels);
}
