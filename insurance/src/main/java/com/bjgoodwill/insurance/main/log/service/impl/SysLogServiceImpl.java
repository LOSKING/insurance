package com.bjgoodwill.insurance.main.log.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.main.log.dao.SysLogDao;
import com.bjgoodwill.insurance.main.log.model.SystemLogModel;
import com.bjgoodwill.insurance.main.log.service.SysLogService;
import com.bjgoodwill.insurance.util.StringCompressUtil;

/**
 * @Package com.bjgoodwill.insurance.log.service.impl
 *
 * @Author yaoyingjie
 *
 * @Descripetion:日志表的查询实现类
 *
 * @Date 2018-04-11 上午11:35:47
 */
@Service
public class SysLogServiceImpl implements SysLogService<SystemLogModel> {

    @Autowired
    private SysLogDao sysLogDao = null;

    @Override
    public int insert(SystemLogModel entity) {
        return sysLogDao.insert(entity);
    }

    @Override
    public List<SystemLogModel> getByConditionQuery(JSONObject jsonObject) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("status", jsonObject.get("status"));
        map.put("methodName", jsonObject.get("methodName"));
        map.put("friendlyMessage", jsonObject.get("friendlyMessage"));
        map.put("createTime", jsonObject.get("createTime"));
        map.put("responseMessage", jsonObject.get("responseMessage"));
        List<SystemLogModel> list = sysLogDao.selectAll(map);
        for (SystemLogModel systemLogModel : list) {
            byte[] blob = (byte[]) systemLogModel.getResponseMessage();//得到Blob对象
            String ddd = StringCompressUtil.decompress(blob);
            //String blobString = blob.toString();
            //String blobString = new String(blob.getBytes(1, (int) blob.length()),"GBK");
            systemLogModel.setResponseMessageStr(ddd);
            String methodName = systemLogModel.getMethodName();
            systemLogModel.setMethodName(methodName.substring(methodName.lastIndexOf(".") + 1));
        }
        return list;
    }
}
