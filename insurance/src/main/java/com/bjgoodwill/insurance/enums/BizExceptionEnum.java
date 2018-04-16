package com.bjgoodwill.insurance.enums;

/**
* @Package com.bjgoodwill.insurance.base.enums
* @Description: 所有业务异常的枚举，直接提供给外部请求，颗粒度较粗
* @author li_jun
* @date 2018年4月2日 上午9:42:47
* @GUID {10850904-c4ec-4e93-b35a-2992ded61858}
 */
public enum BizExceptionEnum {
    // region 请求的错误以4开头
    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    /**
     * 文件读取
     */
    FILE_READING_ERROR(401, "文件读取错误"),
    /**
     * 文件没有找到
     */
    FILE_NOT_FOUND(402, "文件没有找到"),
    /**
     * 系统错误（未处理的错误）
     */
    UNKNOW_ERROR(410, "系统出现错误，我们会尽快处理"),
    // endregion 请求的错误以4开头
    // region 服务端异常以5开头
    SERVER_ERROR(500, "服务器异常"),
    /**
     * 其他
     */
    WRITE_ERROR(510, "渲染界面错误"), USER_NAME_LENGTH_LONG(511, "用户名长度应小于等于6"),
    /**
     * 数据库连接失败
     */
    DATABASE_CONNECTION_FAILD(512, "数据库连接失败"),
    /**
     * 日志服务器连接失败
     */
    MONGODB_CONNECTION_FAILD(513, "日志服务连接失败"),
    /**
     * 数据服务器连接失败
     */
    MYSQL_CONNECTION_FAILD(514, "数据服务连接失败"), DECODE_BASE64(515, "数据转换错误，String转byte[]失败"), SEVICE_FAILD(516, "服务端口出错"),
    // endregion 服务端异常以5开头
    // region异常编码暂定6开头，具体编码有待敲定
    /**
     * 连接服务地址错误
     */
    CONNECT_SERVER_ERROR(601, "连接服务地址错误"),
    /**
     * 编码转换错误
     */
    CODE_CONVERT_ERROR(602, "编码转换错误"),
    /**
     * 输入输出错误，或是管道连接平台服务失败
     */
    CONNECT_CHANNEL_ERROR(603, "输入输出错误，或是管道连接平台服务失败"),
    /**
     * Http请求结果为空
     */
    REQUEST_RESULT_ISEMPTY(604, "Http请求结果为空"),
    /**
     * Http请求参数未包含模块编码
     */
    REQUEST_MODEL_CODE_INCORRECT(605, "Http请求参数未包含模块编码"),
    /**
     * 请求参数不完整
     */
    REQUEST_PARAMS_INCOMPLETE(606, "请求参数不完整"),
    /**
     * 请求数据失败
     */
    OTHER_ERROR(699, "请求数据失败");

    // endregion
    BizExceptionEnum(int code, String message) {
        this.friendlyCode = code;
        this.friendlyMsg = message;
    }

    BizExceptionEnum(int code, String message, String urlPath) {
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
