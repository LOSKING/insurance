package com.bjgoodwill.insurance.main.log.dao;

import java.util.List;
import java.util.Map;

import com.bjgoodwill.insurance.main.log.model.SystemLogModel;

/**
 * @Package com.bjgoodwill.insurance.log.dao
 *
 * @Author yaoyingjie
 *
 * @Descripetion:日志Dao
 *
 * @Date 2018-04-11 上午11:23:37
 */
public interface SysLogDao {

	 /**
     * 根据条件查询日志表
     * @param status
     * @param methodName
     * @param createTime
     * @param responseMessage
     * @return
     */
    SystemLogModel getByConditionQuery(String status, String methodName, String createTime, String responseMessage);
    /**
     * 查詢表里所有数据
     * @param map
     * @return
     */
    List<SystemLogModel> selectAll(Map<String, Object> map);

    /**
     * @Title: insert
     * @Description: 单条新增
     * @param  参数说明
     * @return int    返回值说明
     * @throws
     */
    int insert(SystemLogModel entity);
    
}
