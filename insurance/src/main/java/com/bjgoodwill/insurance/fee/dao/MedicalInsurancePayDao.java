
package com.bjgoodwill.insurance.fee.dao;
import com.bjgoodwill.insurance.fee.model.MedicalInsurancePayModel;

/**
 * @Package com.bjgoodwill.insurance.fee.dao
 *
 * @Author yaoyingjie
 *
 * @Descripetion:
 *
 * @Date 2018-03-27 下午1:33:42
 */
public interface MedicalInsurancePayDao {

	/**
	 * @param healthNum
	 * @return
	 */
	MedicalInsurancePayModel getByHealthNum(String healthNum);

	/**
	 * @param healthNum
	 * @return
	 */
	MedicalInsurancePayModel getByHealthNumToView(String invoiceNo);

}
