
package com.bjgoodwill.insurance.fee.dao;

import com.bjgoodwill.insurance.fee.model.FeeDetailModel;

/**
 * @Package com.bjgoodwill.insurance.fee.dao
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用明细Dao
 *
 * @Date 2018-03-27 上午10:58:33
 */
public interface FeeDetailDao {

	/**
	 * @param medicalBillingNo
	 * @return
	 */
	FeeDetailModel getByMedicalBillingNo(String medicalBillingNo);

	/**
	 * 
	 * @param invoiceNo
	 * @return
	 */
	FeeDetailModel getByMedicalBillingNoToView(String invoiceNo);

	

}
