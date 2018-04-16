
package com.bjgoodwill.insurance.fee.dao;

import com.bjgoodwill.insurance.fee.model.FeeCenterModel;

/**
 * @Package com.bjgoodwill.insurance.fee.dao
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用中心的Dao
 *
 * @Date 2018-03-27 上午10:56:42
 */
public interface FeeCenterDao {

	/**
	 * 通过发票号进行条件查询
	 * @param invoiceNo
	 * @param patientId 
	 * @return
	 */
	FeeCenterModel getByInvoiceNo(String invoiceNo, String patientId);

	/**
	 * @param invoiceNo
	 * @param patientId
	 * @return
	 */
	FeeCenterModel getByInvoiceNoToView(String invoiceNo, String patientId);

}
