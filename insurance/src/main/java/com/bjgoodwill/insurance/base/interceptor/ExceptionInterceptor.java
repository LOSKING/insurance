package com.bjgoodwill.insurance.base.interceptor;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.base.exception.BusinessException;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.enums.BizExceptionEnum;
import com.bjgoodwill.insurance.enums.LocalExceptionEnum;
import com.bjgoodwill.insurance.main.log.model.SystemLogModel;
import com.bjgoodwill.insurance.main.log.service.SysLogService;
import com.bjgoodwill.insurance.util.ReflectHelper;
import com.bjgoodwill.insurance.util.StringCompressUtil;

/**
* @Package com.bjgoodwill.insurance.base.interceptor
* @Description: 异常拦截器，包含异常拦截和异常日志持久化
* @author li_jun
* @date 2018年3月30日 下午3:38:50
* @GUID {10850904-c4ec-4e93-b35a-2992ded61858}
 */
@Aspect
@Component
@Order(0)
public class ExceptionInterceptor {

    @Autowired
    SysLogService<SystemLogModel> systemLogService;

    //拦截Service中的所有公共方法(除了方法：getModelInfo()、)
    @Pointcut("execution(public * com.bjgoodwill.insurance..service.*Service.*(..))&&!execution(* com.bjgoodwill.insurance..service.*Service.getModelInfo(..))&&!execution(* com.bjgoodwill.insurance.main.log.service.SysLogService.insert(..))")
    public void method() {};

    //仅仅拦截getModelInfo()方法
    @Pointcut("execution(public * com.bjgoodwill.insurance..service.*Service.getModelInfo(..))")
    public void getModelInfo() {};

    //仅仅拦截SysLogService.insert()方法
    @Pointcut("execution(* com.bjgoodwill.insurance.main.log.service.SysLogService.insert(..))")
    public void sysLogServiceInsert() {};

    /**
     * @Title: recordLogForBizException
     * @Description: 记录业务执行情况，包含失败和成功这两种状态的处理
     * @param  参数说明
     * @return Object    返回值说明
     * @throws
     */
    @Around("getModelInfo()")
    public Object recordLogForBusiness(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
        try {
            result = pjp.proceed();
        } catch (BusinessException businessException) {
            //异常编码在[600,699]这个区间段的异常被认为是需要反馈给外部请求的异常
            if (businessException.getFriendlyCode() > 599 && businessException.getFriendlyCode() <= 699) {
                if (businessException.getStackTrace().length > 0) {
                    StackTraceElement stackTrace = businessException.getStackTrace()[0];
                    StringBuilder info = new StringBuilder();
                    info.append("Method:");
                    info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                    info.append("ExceptionMessage:");
                    info.append(businessException.getExceptionMsg() + "; ");
                    info.append("FriendlyCode:" + businessException.getFriendlyCode() + ";  " + "FriendlyMessage:" + businessException.getFriendlyMsg());
                    //业务调用的异常信息写入日志存档
                    logger.error(info.toString());
                    //业务异常的处理逻辑在这里写，用于反馈外部请求参数不完整、或者院端返回信息不正确
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("FriendlyCode", businessException.getFriendlyCode());
                    jsonObject.put("FriendlyMessage", businessException.getFriendlyMsg());
                    SystemLogModel systemLogModel = this.initSystemLogModel(pjp);
                    systemLogModel.setType(SystemConstant.TYPE_BUSINESS_LOG);
                    systemLogModel.setStatus(SystemConstant.REQUEST_FAIL);
                    systemLogModel.setFriendlyCode(businessException.getFriendlyCode());
                    systemLogModel.setMethodName(stackTrace.getClassName() + "." + stackTrace.getMethodName());
                    systemLogModel.setFriendlyMessage(businessException.getFriendlyMsg());
                    systemLogModel.setExceptionType("BizExceptionEnum");
                    systemLogService.insert(systemLogModel);
                    return jsonObject.toString();
                }
            } else {
                if (businessException.getStackTrace().length > 0) {
                    StackTraceElement stackTrace = businessException.getStackTrace()[0];
                    StringBuilder info = new StringBuilder();
                    info.append("Method:");
                    info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                    info.append("ExceptionMessage:");
                    info.append(businessException.getExceptionMsg() + "; ");
                    info.append("FriendlyCode:" + businessException.getFriendlyCode() + ";  " + "FriendlyMessage:" + businessException.getFriendlyMsg());
                    //本地方法调用的异常信息写入日志存档
                    logger.error(info.toString());
                    //友好的对外异常提示
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("FriendlyCode", BizExceptionEnum.OTHER_ERROR.getCode());
                    jsonObject.put("FriendlyMessage", BizExceptionEnum.OTHER_ERROR.getMessage());
                    SystemLogModel systemLogModel = this.initSystemLogModel(pjp);
                    systemLogModel.setType(SystemConstant.TYPE_LOCAL_LOG);
                    systemLogModel.setStatus(SystemConstant.REQUEST_FAIL);
                    systemLogModel.setFriendlyCode(businessException.getFriendlyCode());
                    systemLogModel.setMethodName(stackTrace.getClassName() + "." + stackTrace.getMethodName());
                    systemLogModel.setFriendlyMessage(businessException.getFriendlyMsg());
                    systemLogModel.setExceptionType("BizExceptionEnum");
                    systemLogService.insert(systemLogModel);
                    return jsonObject.toString();
                }
            }
        } catch (Exception exception) {
            //其他异常处理逻辑，处理不可预知的异常
            if (exception.getStackTrace().length > 0) {
                StackTraceElement stackTrace = exception.getStackTrace()[0];
                StringBuilder info = new StringBuilder();
                info.append("Method:");
                info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                info.append("ExceptionType: " + exception.toString() + "; ");
                info.append("ExceptionMessage:");
                info.append(exception.getMessage() + "; ");
                //异常信息写入日志存档
                logger.error(info.toString());
                //友好的对外异常提示
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("FriendlyCode", BizExceptionEnum.OTHER_ERROR.getCode());
                jsonObject.put("FriendlyMessage", BizExceptionEnum.OTHER_ERROR.getMessage());
                SystemLogModel systemLogModel = this.initSystemLogModel(pjp);
                systemLogModel.setType(SystemConstant.TYPE_LOCAL_LOG);
                systemLogModel.setStatus(SystemConstant.REQUEST_FAIL);
                systemLogModel.setFriendlyCode(BizExceptionEnum.OTHER_ERROR.getCode());
                systemLogModel.setMethodName(stackTrace.getClassName() + "." + stackTrace.getMethodName());
                systemLogModel.setFriendlyMessage(BizExceptionEnum.OTHER_ERROR.getMessage());
                systemLogModel.setExceptionType(exception.getClass().getName());
                systemLogModel.setExceptionMessage(exception.getMessage());
                systemLogService.insert(systemLogModel);
                return jsonObject.toString();
            }
        }
        //代码能执行到这里，表示获取数据成功，将成功时的日志信息进行持久化
        SystemLogModel systemLogModel = this.initSystemLogModel(pjp);
        systemLogModel.setType(SystemConstant.TYPE_BUSINESS_LOG);
        systemLogModel.setStatus(SystemConstant.REQUEST_SUCCESS);
        //对返回信息进行压缩
        systemLogModel.setResponseMessage(StringCompressUtil.compress(result.toString()));
        systemLogService.insert(systemLogModel);
        return result;
    }

    /**
     * @Title: recordLogForLocalException
     * @Description: 记录本地方法执行时的异常信息
     * @param  参数说明
     * @return Object    返回值说明
     * @throws
     */
    @Around("method()")
    public Object recordLogForLocalException(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
        try {
            result = pjp.proceed();
        } catch (BusinessException businessException) {
            //异常编码在[600,699]这个区间段的异常被认为是需要反馈给外部请求的异常
            if (businessException.getFriendlyCode() > 599 && businessException.getFriendlyCode() <= 699) {
                if (businessException.getStackTrace().length > 0) {
                    StackTraceElement stackTrace = businessException.getStackTrace()[0];
                    StringBuilder info = new StringBuilder();
                    info.append("Method:");
                    info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                    info.append("ExceptionMessage:");
                    info.append(businessException.getExceptionMsg() + "; ");
                    info.append("FriendlyCode:" + businessException.getFriendlyCode() + ";  " + "FriendlyMessage:" + businessException.getFriendlyMsg());
                    //业务调用的异常信息写入日志存档
                    logger.error(info.toString());
                    //业务异常的处理逻辑在这里写，用于反馈外部请求参数不完整、或者院端返回信息不正确
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("FriendlyCode", businessException.getFriendlyCode());
                    jsonObject.put("FriendlyMessage", businessException.getFriendlyMsg());
                    SystemLogModel systemLogModel = this.initSystemLogModel(pjp);
                    systemLogModel.setType(SystemConstant.TYPE_BUSINESS_LOG);
                    systemLogModel.setStatus(SystemConstant.REQUEST_FAIL);
                    systemLogModel.setFriendlyCode(businessException.getFriendlyCode());
                    systemLogModel.setMethodName(stackTrace.getClassName() + "." + stackTrace.getMethodName());
                    systemLogModel.setFriendlyMessage(businessException.getFriendlyMsg());
                    systemLogModel.setExceptionType("BizExceptionEnum");
                    systemLogService.insert(systemLogModel);
                    return jsonObject.toString();
                }
            } else {
                if (businessException.getStackTrace().length > 0) {
                    StackTraceElement stackTrace = businessException.getStackTrace()[0];
                    StringBuilder info = new StringBuilder();
                    info.append("Method:");
                    info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                    info.append("ExceptionMessage:");
                    info.append(businessException.getExceptionMsg() + "; ");
                    info.append("FriendlyCode:" + businessException.getFriendlyCode() + ";  " + "FriendlyMessage:" + businessException.getFriendlyMsg());
                    //本地方法调用的异常信息写入日志存档
                    logger.error(info.toString());
                    //友好的对外异常提示
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("FriendlyCode", BizExceptionEnum.OTHER_ERROR.getCode());
                    jsonObject.put("FriendlyMessage", BizExceptionEnum.OTHER_ERROR.getMessage());
                    SystemLogModel systemLogModel = this.initSystemLogModel(pjp);
                    systemLogModel.setType(SystemConstant.TYPE_LOCAL_LOG);
                    systemLogModel.setStatus(SystemConstant.REQUEST_FAIL);
                    systemLogModel.setFriendlyCode(businessException.getFriendlyCode());
                    systemLogModel.setMethodName(stackTrace.getClassName() + "." + stackTrace.getMethodName());
                    systemLogModel.setFriendlyMessage(businessException.getFriendlyMsg());
                    systemLogModel.setExceptionType("BizExceptionEnum");
                    systemLogService.insert(systemLogModel);
                    return jsonObject.toString();
                }
            }
        } catch (Exception exception) {
            //其他异常处理逻辑，处理不可预知的异常
            if (exception.getStackTrace().length > 0) {
                StackTraceElement stackTrace = exception.getStackTrace()[0];
                StringBuilder info = new StringBuilder();
                info.append("Method:");
                info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                info.append("ExceptionType: " + exception.toString() + "; ");
                info.append("ExceptionMessage:");
                info.append(exception.getMessage() + "; ");
                //异常信息写入日志存档
                logger.error(info.toString());
                //友好的对外异常提示
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("FriendlyCode", BizExceptionEnum.OTHER_ERROR.getCode());
                jsonObject.put("FriendlyMessage", BizExceptionEnum.OTHER_ERROR.getMessage());
                SystemLogModel systemLogModel = this.initSystemLogModel(pjp);
                systemLogModel.setType(SystemConstant.TYPE_LOCAL_LOG);
                systemLogModel.setStatus(SystemConstant.REQUEST_FAIL);
                //                systemLogModel.setFriendlyCode(BizExceptionEnum.OTHER_ERROR.getCode());
                //                systemLogModel.setFriendlyMessage(BizExceptionEnum.OTHER_ERROR.getMessage());
                systemLogModel.setMethodName(stackTrace.getClassName() + "." + stackTrace.getMethodName());
                systemLogModel.setExceptionType(exception.getClass().getName());
                systemLogModel.setExceptionMessage(exception.getMessage());
                systemLogService.insert(systemLogModel);
                return jsonObject.toString();
            }
        }
        return result;
    }

    @Around("sysLogServiceInsert()")
    public Object recordLogForSysLogServiceInsert(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        Logger logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
        try {
            result = pjp.proceed();
        } catch (Exception exception) {
            //其他异常处理逻辑，处理不可预知的异常
            if (exception.getStackTrace().length > 0) {
                StackTraceElement stackTrace = exception.getStackTrace()[0];
                StringBuilder info = new StringBuilder();
                info.append("Method:");
                info.append(stackTrace.getClassName() + "." + stackTrace.getMethodName() + "; ");
                info.append("ExceptionType: " + exception.toString() + "; ");
                info.append("ExceptionMessage:");
                info.append(exception.getMessage() + "; ");
                info.append("FriendlyCode" + LocalExceptionEnum.LOG_INSERT_FAILED.getCode() + "; ");
                info.append("FriendlyMessage" + LocalExceptionEnum.LOG_INSERT_FAILED.getMessage() + "; ");
                //异常信息写入日志存档
                logger.error(info.toString());
                //友好的对外异常提示
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("FriendlyCode", BizExceptionEnum.OTHER_ERROR.getCode());
                jsonObject.put("FriendlyMessage", BizExceptionEnum.OTHER_ERROR.getMessage());
                return jsonObject.toString();
            }
        }
        return result;
    }

    private SystemLogModel initSystemLogModel(ProceedingJoinPoint pjp) {
        SystemLogModel systemLogModel = new SystemLogModel();
        // 模块ID
        systemLogModel.setModelId(ReflectHelper.getSuperClassGenericType(pjp.getTarget().getClass()).getName());
        // 当前系统时间
        systemLogModel.setCreateTime(new Date());
        //设置时间戳
        systemLogModel.setRequestTimeStamp(this.getRequestTimeStamp(pjp));
        return systemLogModel;
    }

    private String getRequestTimeStamp(ProceedingJoinPoint pjp) {
        try {
            //设置时间戳
            Object[] methodArgs = pjp.getArgs();
            JSONObject requestJson = (JSONObject) methodArgs[1];
            String timeStamp = (String) requestJson.get("timeStamp");
            return timeStamp;
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("FriendlyCode", LocalExceptionEnum.GET_TIMESTAMP_FAILED.getCode());
            jsonObject.put("FriendlyMessage", LocalExceptionEnum.GET_TIMESTAMP_FAILED.getMessage());
            return jsonObject.toString();
        }
    }
}
