
package com.bjgoodwill.insurance.fee.dao;

import com.bjgoodwill.insurance.fee.model.FeeItemModel;

/**
 * @Package com.bjgoodwill.insurance.fee.dao
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用大项Dao
 *
 * @Date 2018-03-27 上午10:59:47
 */
public interface FeeItemDao {

	/**
	 * @param medicalItemCatID
	 * @return
	 */
	FeeItemModel getByMedicalItemCatID(String medicalItemCatID);

	/**
	 * @param medicalItemCatID
	 * @return
	 */
	FeeItemModel getByMedicalItemCatIDToView(String invoiceNo);

}
