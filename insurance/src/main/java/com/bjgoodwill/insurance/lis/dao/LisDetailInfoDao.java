package com.bjgoodwill.insurance.lis.dao;

import java.util.List;

import com.bjgoodwill.insurance.lis.model.LisDetailInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.dao
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检验详细信息Dao
 * @author liuxch 
 * @date 2018年3月27日 下午5:09:05
 */
public interface LisDetailInfoDao {

	List<LisDetailInfoModel> getLisDetailInfoByPatientIdToView(String patientId);
}
