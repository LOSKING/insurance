package com.bjgoodwill.insurance.lis.dao;

import java.util.List;

import com.bjgoodwill.insurance.lis.model.LisInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.dao
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检验信息Dao
 * @author liuxch 
 * @date 2018年3月27日 下午4:21:30
 */
public interface LisInfoDao {
	
	List<LisInfoModel> getLisInfoByPatientIdToView(String labNum);
	// add by liuxch @2018-03-29 17:28:50  start
	// 描述：{b1b627c6-6364-40db-b9b8-49e0a6921bf0}
	List<LisInfoModel> getLisInfoByPatientId(String patienId);
	// add by liuxch @2018-03-29 17:28:50  end
}
