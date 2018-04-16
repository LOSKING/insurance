package com.bjgoodwill.insurance.base.exception;

import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;

/**
* @Package com.bjgoodwill.insurance.base.exception
* @Description: 业务类异常
* @author li_jun
* @date 2018年4月2日 上午11:23:03
* @GUID {10850904-c4ec-4e93-b35a-2992ded61858}
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /**
     * 友好提示的code码
     */
    protected int             friendlyCode;
    /**
     * 友好提示
     */
    protected String          friendlyMsg;
    /**
     * 异常消息
     */
    protected String          exceptionMsg;
    /**
     * 业务异常跳转的页面
     */
    protected String          urlPath;

    protected BusinessException(int friendlyCode, String friendlyMsg, String exceptionMsg, String urlPath) {
        this.setValues(friendlyCode, friendlyMsg, exceptionMsg, urlPath);
    }

    public BusinessException(BizExceptionEnum bizExceptionEnum) {
        this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), "", bizExceptionEnum.getUrlPath());
    }

    public BusinessException(BizExceptionEnum bizExceptionEnum, String exceptionMsg) {
        this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), exceptionMsg, bizExceptionEnum.getUrlPath());
    }
    public BusinessException(LocalExceptionEnum localExceptionEnum) {
        this.setValues(localExceptionEnum.getCode(), localExceptionEnum.getMessage(), "", localExceptionEnum.getUrlPath());
    }
    
    public BusinessException(LocalExceptionEnum localExceptionEnum, String exceptionMsg) {
        this.setValues(localExceptionEnum.getCode(), localExceptionEnum.getMessage(), exceptionMsg, localExceptionEnum.getUrlPath());
    }

    private void setValues(int friendlyCode, String friendlyMsg, String exceptionMsg, String urlPath) {
        this.friendlyCode = friendlyCode;
        this.friendlyMsg = friendlyMsg;
        this.exceptionMsg = exceptionMsg;
        this.urlPath = urlPath;
    }

    public int getFriendlyCode() {
        return friendlyCode;
    }

    public void setFriendlyCode(int friendlyCode) {
        this.friendlyCode = friendlyCode;
    }

    public String getFriendlyMsg() {
        return friendlyMsg;
    }

    public void setFriendlyMsg(String friendlyMsg) {
        this.friendlyMsg = friendlyMsg;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
