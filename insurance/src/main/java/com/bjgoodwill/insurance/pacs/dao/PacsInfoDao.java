package com.bjgoodwill.insurance.pacs.dao;

import java.util.List;

import com.bjgoodwill.insurance.pacs.model.PacsInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.pacs.dao
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查信息Dao
 * @author liuxch 
 * @date 2018年3月27日 上午11:30:42
 */
public interface PacsInfoDao {
	
	List<PacsInfoModel> getPacsInfoByPatientIdToView(String recordNum);
	// add by liuxch @2018-03-29 17:28:50  start
	// 描述：{b1b627c6-6364-40db-b9b8-49e0a6921bf0}
	List<PacsInfoModel> getPacsInfoByPatientId (String patientId);
	// add by liuxch @2018-03-29 17:28:50  end
}
