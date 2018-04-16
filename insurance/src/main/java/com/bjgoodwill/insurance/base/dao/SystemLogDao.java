package com.bjgoodwill.insurance.base.dao;

import com.bjgoodwill.insurance.main.log.model.SystemLogModel;

/**
 * @Package: com.bjgoodwill.insurance.base.dao
 * @Description: 系统日志
 * @author li_jun 
 * @date 2018年4月10日 下午4:03:13
 * @GUID {2d671973-7a44-4b9c-b411-e0d63564dcee}
 */
public interface SystemLogDao {

    int insert(SystemLogModel entity);
}
