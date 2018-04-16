package com.bjgoodwill.insurance.enums;

/**
* @Package com.bjgoodwill.insurance.base.enums
* @Description: 所有本地异常的枚举，用于本地日志和错误查找，颗粒度较细
* @author li_jun
* @date 2018年4月2日 上午9:42:47
* @GUID {0b585eb2-3226-455a-98a4-b0d856cff9ba}
 */
public enum LocalExceptionEnum {
    // region 本地异常编码暂定7开头
    /**
     * 配置实体为空
     */
    SETTING_MODEL_ISNULL(700, "配置实体为空"),
    /**
     * 模型ID为空
     */
    MODEL_ID_ISNULL(701, "模型ID为空"),
    /**
     * 查询结果为空
     */
    QUERY_RESULT_ISNULL(702, "查询结果为空"),
    /**
     * 配置实体接口方式不一致
     */
    SETTING_INTERFACE_MODE_ISDIFFER(703, "配置实体接口方式不一致"),
    /**
     * 获取泛型类型失败
     */
    GET_GENERIC_SUPER_CLASS_FAILED(704, "获取泛型类型失败"),
    /**
     * 获取泛型类型失败
     */
    GET_CLASS_FOR_NAME_FAILED(705, "未找到相关的类"),
    /**
     * 通过反射执行方法失败
     */
    INVOKE_METHOD_WITH_REFLECTION_FAILED(706, "通过反射执行方法失败"),
    /**
     * Http请求方法类型不正确
     */
    REQUEST_METHOD_INCORRECT(707, "Http请求方法类型不正确"),
    /**
     * Http请求结果不包含对应key
     */
    REQUEST_RESULT_NOT_CONTAIN_KEY(708, "Http请求结果不包含对应key"),
    /**
     * 请求URL格式不正确
     */
    REQUEST_URL_INCORRECT(709, "请求URL格式不正确"),
    /**
     * 字典映射失败
     */
    CONTRAST_DIC_TOMODEL_FAILED(710, "字典映射失败"),
    /**
     * 日志写入失败
     */
    LOG_INSERT_FAILED(711, "日志写入失败"),
    /**
     * 获取时间戳失败
     */
    GET_TIMESTAMP_FAILED(712, "获取时间戳失败"),
    /**
     * 其它错误
     */
    OTHER_ERROR(799, "其它错误");

    // endregion
    LocalExceptionEnum(int code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    LocalExceptionEnum(int code, String message, String urlPath) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
        this.urlPath = urlPath;
    }

    private int    friendlyCode;
    private String friendlyMsg;
    private String urlPath;

    public int getCode() {
        return friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
