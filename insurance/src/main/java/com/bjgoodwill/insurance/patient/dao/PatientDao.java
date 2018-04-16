package com.bjgoodwill.insurance.patient.dao;

import org.apache.ibatis.annotations.Param;

import com.bjgoodwill.insurance.patient.model.PatientModel;

/**
 * @Package: com.bjgoodwill.insurance.record.dao
 * @author zhangq 
 * @date 2018年3月22日 下午1:41:59
 * 
 */
public interface PatientDao {

    PatientModel getByPrimaryKey(String patientId);

    PatientModel getHisDataByView(@Param("patientId")String patientId,@Param("insCode") String insCode);
}
