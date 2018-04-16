package com.bjgoodwill.insurance.pacs.dao;

import java.util.List;

import com.bjgoodwill.insurance.pacs.model.PacsDetailInfoModel;

/**
 * @Package: com.bjgoodwill.insurance.pacs.dao
 * @Decription {42a7c0d6-4438-4662-98f4-d166c3d78514} 检查相信信息Dao
 * @author Liuxch 
 * @date 2018年3月27日 下午4:47:56
 */
public interface PacsDetailInfoDao {

	List<PacsDetailInfoModel> getPacsDetailInfoByPatientIdToView(String recordNum);
}
