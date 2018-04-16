package com.bjgoodwill.insurance.main.setting.model;

/**
 * @Package: com.bjgoodwill.insurance.setting.model
 * @author zhangq 
 * @Decription 配置实体{653dd1f2-4fd3-4af6-96b6-0dac66917a4f}
 * @date 2018年3月26日 下午3:03:19
 * 
 */

public class SettingModel {

    /**
     * 模块ID，如patientInfo
     */
    private String  modelId;
    /**
     * 模块名，如患者基本信息
     */
    private String  modelName;
    /**
     * 接口方式（0：视图，1：web）
     */
    private String interfaceMode;
    /**
     * 接口名（如果是web方式，写完整URL），如http://localhost:8091/getPatientBase
     */
    private String  interfaceName;
    /**
     * 获取属性名（用“|”分隔）
     * 如：patientId=id|name=name|age=com.bjggodwill.insurance.util.getAge(Date birthday)
     */
    private String  propertyName;
    /**
     * 访问方式（get, post）
     */
    private String  method;
    /**
     * 参数（用“&”链接）
     * 如：settingModel.setRequestParams("id=" + patientId + "&name=" + patientName);
     */
    private String  requestParams;
    /**
     * 返回值类型（json或其它，需要补充）
     */
    private String  reutrnValue;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getInterfaceMode() {
        return interfaceMode;
    }

    public void setInterfaceMode(String interfceMode) {
        this.interfaceMode = interfceMode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getReutrnValue() {
        return reutrnValue;
    }

    public void setReutrnValue(String reutrnValue) {
        this.reutrnValue = reutrnValue;
    }

    @Override
    public String toString() {
        return "SettingModel [modelId=" + modelId + ", modelName=" + modelName + ", interfceMode=" + interfaceMode + ", interfaceName=" + interfaceName + ", propertyName=" + propertyName + ", method="
                + method + ", requestParams=" + requestParams + ", funcParams=" + ", reutrnValue=" + reutrnValue + "]";
    }
}
