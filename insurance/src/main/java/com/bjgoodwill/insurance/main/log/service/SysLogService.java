/**
 * 
 */
package com.bjgoodwill.insurance.main.log.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.main.log.model.SystemLogModel;

/**
 * @Package com.bjgoodwill.insurance.log.service
 *
 * @Author yaoyingjie
 *
 * @Descripetion:
 *
 * @Date 2018-04-11 上午11:37:28
 */
public interface SysLogService<T> {

	/**
	 * @param status
	 * @param methodName
	 * @param createTime
	 * @param responseMessage
	 * @return
	 */
	List<SystemLogModel> getByConditionQuery(JSONObject jsonObject) throws Exception ;


    /**
     * @Title: insert
     * @Description: 插入日志
     * @param  参数说明
     * @return int    返回值说明
     * @throws
     */
    int insert(T entity);
}
