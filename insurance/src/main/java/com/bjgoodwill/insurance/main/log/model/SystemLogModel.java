package com.bjgoodwill.insurance.main.log.model;

import java.util.Date;

/**
 * @Package: com.bjgoodwill.insurance.base.model
 * @Description: 系统日志模型
 * @author li_jun 
 * @date 2018年4月10日 下午4:08:05
 * @GUID {2d671973-7a44-4b9c-b411-e0d63564dcee}
 */
public class SystemLogModel {

    private Long    id;
    //    请求时间戳
    private String  requestTimeStamp;
    //    日志类型，区分调试和流程恢复
    private Integer type;
    //    状态 0:成功，1：失败
    private Integer status;
    //    模块ID
    private String  modelId;
    //    抛异常的方法名
    private String  methodName;
    //    异常类型名
    private String  exceptionType;
    //    友好异常编码
    private Integer friendlyCode;
    //    友好异常提示
    private String  friendlyMessage;
    //    异常信息（主要为自定义提示消息）
    private String  exceptionMessage;
    //    日志记录时间
    private Date    createTime;
    //    院端返回给平台的信息
    private Object  responseMessage;
    private String  responseMessageStr;

    public String getResponseMessageStr() {
        return responseMessageStr;
    }

    public void setResponseMessageStr(String responseMessageStr) {
        this.responseMessageStr = responseMessageStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public void setRequestTimeStamp(String requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public Integer getFriendlyCode() {
        return friendlyCode;
    }

    public void setFriendlyCode(Integer friendlyCode) {
        this.friendlyCode = friendlyCode;
    }

    public String getFriendlyMessage() {
        return friendlyMessage;
    }

    public void setFriendlyMessage(String friendlyMessage) {
        this.friendlyMessage = friendlyMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Object getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(Object responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
        result = prime * result + ((exceptionMessage == null) ? 0 : exceptionMessage.hashCode());
        result = prime * result + ((exceptionType == null) ? 0 : exceptionType.hashCode());
        result = prime * result + ((friendlyCode == null) ? 0 : friendlyCode.hashCode());
        result = prime * result + ((friendlyMessage == null) ? 0 : friendlyMessage.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
        result = prime * result + ((modelId == null) ? 0 : modelId.hashCode());
        result = prime * result + ((requestTimeStamp == null) ? 0 : requestTimeStamp.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
}
