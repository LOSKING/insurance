package com.bjgoodwill.insurance.lis.dao;

import java.util.List;

import com.bjgoodwill.insurance.lis.model.LisPacsCenterModel;

/**
 * @Package: com.bjgoodwill.insurance.lis.dao
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查检验中心表Dao
 * @author liuxch 
 * @date 2018年3月27日 下午6:12:26
 */
public interface LisPacsCenterDao {
	// add by liuxch @2018-03-29 17:28:50  start
	// 描述：{b1b627c6-6364-40db-b9b8-49e0a6921bf0}
	List<LisPacsCenterModel> getLisPacsCenterByPatientIdToView(String patientId);
	// add by liuxch @2018-03-29 17:28:50  end
	// add by liuxch @2018-03-30 15:29:25 {8dec6d74-f028-48a9-9a62-87e45caa0829} start
	// 描述：添加通过就诊流水号、就诊类型查询检查检验中心表信息
	List<LisPacsCenterModel> getLisPacsCenterByMedicalNumMedicalType(String medicalNum ,String medicalType);
	// add by liuxch @2018-03-30 15:29:25  end
	
}
