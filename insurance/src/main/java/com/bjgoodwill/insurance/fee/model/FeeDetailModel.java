
package com.bjgoodwill.insurance.fee.model;

/**
 * @Package com.bjgoodwill.insurance.fee.model
 *
 * @Author yaoyingjie
 *
 * @Descripetion:费用明细Model
 *
 * @Date 2018-03-26 下午4:55:20
 */
public class FeeDetailModel {
	
	//单据号
	private String medicalBillingNo;
	
	//明细序号
	private String feeDetailNo;
	
	//目录类别
	private String listCat;
	
	//小项类别
	private String medicalItemCat;
	
	//项目类别名称
	private String listCatName;
	
	//项目等级:1-甲类；2-乙类；3-丙类
	private String chargeLevel;
	
	//项目序号：医院内部序号
	private String projectNo;
	
	//项目名称：医院内部序号名称
	private String projectName;
	
	//单价:4为小数
	private String price;
	
	//数量:4 位小数，按照目录库中的包装上传入，非招标按照实际情况传入
	private String size;
	
	//金额:4 位小数
	private String amount;
	
	//就诊科室
	private String visitDepartment;
	
	//执行科室名称
	private String departmentName;
	
	//医院收费项目编码
	private String hospitalChargeCode;
	
	//医院收费项目名称
	private String hospitalChargeName;
	
	//自费金额
	private String selfAmount;
	
	//自理金额
	private String selfPayAmount;
	
	//执行科室代码
	private String departmentCode;
	
	//社保项目编码
	private String insurItemCode;
	
	//社保项目名称
	private String insurItemName;
	
	//医保目录行政区划级别:默认为“市医疗目录”
	private String insuranceCatAdminLevel;
	
	//处方号
	private String prescriptionNo;
	
	//处方明细流水号:同一个就诊下，处方流水号在医院端能够唯一标识条处方明细信息
	private String prescriptionSerialNo;
	
	//项目剂型:
	private String projectDosage;
	
	//项目单位
	private String projectUnit;
	
	//规格:药品信息、医用材料时一般不为空，其他为空
	private String projectSpec;
	
	//项目产地名称
	private String projectLocalName;
	
	//包装数量
	private String packageSize;
	
	//包装单位
	private String packageUnit;
	
	//最小剂量单位
	private String minDosageUnit;
	
	//常规用量
	private String normalUsage;
	
	//用量单位
	private String useUnit;
	
	//每天次数
	private String everyDaySize;
	
	//用药天数
	private String useDaySize;
	
	//单复方标志
	private String isSingleRemedy;
	
	//中草药贴数
	private String herbalSize;
	
	//给药方式
	private String drugDeliverType;
	
	//项目单位代码
	private String projectUnitCode;
	
	//药品大规格序号
	private String drugSpecNo;
	
	//药品大规格产地
	private String drugSpecLocal;
	
	//药品大规格数量
	private String drugSpecSize;
	
	//医生工号
	private String doctorId;
	
	//处方医生姓名
	private String doctorName;
	
	//处方医生编码
	private String doctorNo;
	
	//成分
	private String constituent;
	
	//适应症或主治功能
	private String doctorFunction;
	
	//禁忌
	private String taboo;
	
	//是否处方标识
	private String isPrescription;
	
	//限制用药标识
	private String isSeriousDrugs;
	
	//限制用药
	private String seriousDrugs;
	
	//基药标识
	private String drugFlag;
	
	//国药准字号
	private String chineseMedicineNo;
	
	//注册证号
	private String registerNo;
	
	//品牌
	private String brand;
	
	//项目英文名
	private String projectEnglishName;
	
	//保内保外
	private String insurantInnerOut;
	
	//生产厂家
	private String manufacturer;
	
	//医院负担费用
	private String hosBearMoney;
	
	//外带处方标志
	private String extraRecipeFlg;
	
	//检查结果
	private String examinationResult;
	
	//正常参考值
	private String referenceRanges;
	
	//检查提示
	private String examinationHint;
	
	//自付比例:如果医保已经支付，此处填写医保的乙类自付比例：丙类自费时100%，
	//乙类按照实际比例传入；否则默认传入本地城镇职工医保的自付比例。
	private String selfPayRatio;
	
	//医保限价:如果医保已经支付，此处填写医保的最高支付限价。
	private String medlimitedPrice;
	
	//全额自费标志
	private String totalSelfFundFlag;
	
	//用法
	private String directions;
	
	//经办人
	private String updateBy;

	/**
	 * @return the medicalBillingNo
	 */
	public String getMedicalBillingNo() {
		return medicalBillingNo;
	}

	/**
	 * @param medicalBillingNo the medicalBillingNo to set
	 */
	public void setMedicalBillingNo(String medicalBillingNo) {
		this.medicalBillingNo = medicalBillingNo;
	}

	/**
	 * @return the feeDetailNo
	 */
	public String getFeeDetailNo() {
		return feeDetailNo;
	}

	/**
	 * @param feeDetailNo the feeDetailNo to set
	 */
	public void setFeeDetailNo(String feeDetailNo) {
		this.feeDetailNo = feeDetailNo;
	}

	/**
	 * @return the listCat
	 */
	public String getListCat() {
		return listCat;
	}

	/**
	 * @param listCat the listCat to set
	 */
	public void setListCat(String listCat) {
		this.listCat = listCat;
	}

	/**
	 * @return the medicalItemCat
	 */
	public String getMedicalItemCat() {
		return medicalItemCat;
	}

	/**
	 * @param medicalItemCat the medicalItemCat to set
	 */
	public void setMedicalItemCat(String medicalItemCat) {
		this.medicalItemCat = medicalItemCat;
	}

	/**
	 * @return the listCatName
	 */
	public String getListCatName() {
		return listCatName;
	}

	/**
	 * @param listCatName the listCatName to set
	 */
	public void setListCatName(String listCatName) {
		this.listCatName = listCatName;
	}

	/**
	 * @return the chargeLevel
	 */
	public String getChargeLevel() {
		return chargeLevel;
	}

	/**
	 * @param chargeLevel the chargeLevel to set
	 */
	public void setChargeLevel(String chargeLevel) {
		this.chargeLevel = chargeLevel;
	}

	/**
	 * @return the projectNo
	 */
	public String getProjectNo() {
		return projectNo;
	}

	/**
	 * @param projectNo the projectNo to set
	 */
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the visitDepartment
	 */
	public String getVisitDepartment() {
		return visitDepartment;
	}

	/**
	 * @param visitDepartment the visitDepartment to set
	 */
	public void setVisitDepartment(String visitDepartment) {
		this.visitDepartment = visitDepartment;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the hospitalChargeCode
	 */
	public String getHospitalChargeCode() {
		return hospitalChargeCode;
	}

	/**
	 * @param hospitalChargeCode the hospitalChargeCode to set
	 */
	public void setHospitalChargeCode(String hospitalChargeCode) {
		this.hospitalChargeCode = hospitalChargeCode;
	}

	/**
	 * @return the hospitalChargeName
	 */
	public String getHospitalChargeName() {
		return hospitalChargeName;
	}

	/**
	 * @param hospitalChargeName the hospitalChargeName to set
	 */
	public void setHospitalChargeName(String hospitalChargeName) {
		this.hospitalChargeName = hospitalChargeName;
	}

	/**
	 * @return the selfAmount
	 */
	public String getSelfAmount() {
		return selfAmount;
	}

	/**
	 * @param selfAmount the selfAmount to set
	 */
	public void setSelfAmount(String selfAmount) {
		this.selfAmount = selfAmount;
	}

	/**
	 * @return the selfPayAmount
	 */
	public String getSelfPayAmount() {
		return selfPayAmount;
	}

	/**
	 * @param selfPayAmount the selfPayAmount to set
	 */
	public void setSelfPayAmount(String selfPayAmount) {
		this.selfPayAmount = selfPayAmount;
	}

	/**
	 * @return the departmentCode
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * @param departmentCode the departmentCode to set
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/**
	 * @return the insurItemCode
	 */
	public String getInsurItemCode() {
		return insurItemCode;
	}

	/**
	 * @param insurItemCode the insurItemCode to set
	 */
	public void setInsurItemCode(String insurItemCode) {
		this.insurItemCode = insurItemCode;
	}

	/**
	 * @return the insurItemName
	 */
	public String getInsurItemName() {
		return insurItemName;
	}

	/**
	 * @param insurItemName the insurItemName to set
	 */
	public void setInsurItemName(String insurItemName) {
		this.insurItemName = insurItemName;
	}

	/**
	 * @return the insuranceCatAdminLevel
	 */
	public String getInsuranceCatAdminLevel() {
		return insuranceCatAdminLevel;
	}

	/**
	 * @param insuranceCatAdminLevel the insuranceCatAdminLevel to set
	 */
	public void setInsuranceCatAdminLevel(String insuranceCatAdminLevel) {
		this.insuranceCatAdminLevel = insuranceCatAdminLevel;
	}

	/**
	 * @return the prescriptionNo
	 */
	public String getPrescriptionNo() {
		return prescriptionNo;
	}

	/**
	 * @param prescriptionNo the prescriptionNo to set
	 */
	public void setPrescriptionNo(String prescriptionNo) {
		this.prescriptionNo = prescriptionNo;
	}

	/**
	 * @return the prescriptionSerialNo
	 */
	public String getPrescriptionSerialNo() {
		return prescriptionSerialNo;
	}

	/**
	 * @param prescriptionSerialNo the prescriptionSerialNo to set
	 */
	public void setPrescriptionSerialNo(String prescriptionSerialNo) {
		this.prescriptionSerialNo = prescriptionSerialNo;
	}

	/**
	 * @return the projectDosage
	 */
	public String getProjectDosage() {
		return projectDosage;
	}

	/**
	 * @param projectDosage the projectDosage to set
	 */
	public void setProjectDosage(String projectDosage) {
		this.projectDosage = projectDosage;
	}

	/**
	 * @return the projectUnit
	 */
	public String getProjectUnit() {
		return projectUnit;
	}

	/**
	 * @param projectUnit the projectUnit to set
	 */
	public void setProjectUnit(String projectUnit) {
		this.projectUnit = projectUnit;
	}

	/**
	 * @return the projectSpec
	 */
	public String getProjectSpec() {
		return projectSpec;
	}

	/**
	 * @param projectSpec the projectSpec to set
	 */
	public void setProjectSpec(String projectSpec) {
		this.projectSpec = projectSpec;
	}

	/**
	 * @return the projectLocalName
	 */
	public String getProjectLocalName() {
		return projectLocalName;
	}

	/**
	 * @param projectLocalName the projectLocalName to set
	 */
	public void setProjectLocalName(String projectLocalName) {
		this.projectLocalName = projectLocalName;
	}

	/**
	 * @return the packageSize
	 */
	public String getPackageSize() {
		return packageSize;
	}

	/**
	 * @param packageSize the packageSize to set
	 */
	public void setPackageSize(String packageSize) {
		this.packageSize = packageSize;
	}

	/**
	 * @return the packageUnit
	 */
	public String getPackageUnit() {
		return packageUnit;
	}

	/**
	 * @param packageUnit the packageUnit to set
	 */
	public void setPackageUnit(String packageUnit) {
		this.packageUnit = packageUnit;
	}

	/**
	 * @return the minDosageUnit
	 */
	public String getMinDosageUnit() {
		return minDosageUnit;
	}

	/**
	 * @param minDosageUnit the minDosageUnit to set
	 */
	public void setMinDosageUnit(String minDosageUnit) {
		this.minDosageUnit = minDosageUnit;
	}

	/**
	 * @return the normalUsage
	 */
	public String getNormalUsage() {
		return normalUsage;
	}

	/**
	 * @param normalUsage the normalUsage to set
	 */
	public void setNormalUsage(String normalUsage) {
		this.normalUsage = normalUsage;
	}

	/**
	 * @return the useUnit
	 */
	public String getUseUnit() {
		return useUnit;
	}

	/**
	 * @param useUnit the useUnit to set
	 */
	public void setUseUnit(String useUnit) {
		this.useUnit = useUnit;
	}

	/**
	 * @return the everyDaySize
	 */
	public String getEveryDaySize() {
		return everyDaySize;
	}

	/**
	 * @param everyDaySize the everyDaySize to set
	 */
	public void setEveryDaySize(String everyDaySize) {
		this.everyDaySize = everyDaySize;
	}

	/**
	 * @return the useDaySize
	 */
	public String getUseDaySize() {
		return useDaySize;
	}

	/**
	 * @param useDaySize the useDaySize to set
	 */
	public void setUseDaySize(String useDaySize) {
		this.useDaySize = useDaySize;
	}

	/**
	 * @return the isSingleRemedy
	 */
	public String getIsSingleRemedy() {
		return isSingleRemedy;
	}

	/**
	 * @param isSingleRemedy the isSingleRemedy to set
	 */
	public void setIsSingleRemedy(String isSingleRemedy) {
		this.isSingleRemedy = isSingleRemedy;
	}

	/**
	 * @return the herbalSize
	 */
	public String getHerbalSize() {
		return herbalSize;
	}

	/**
	 * @param herbalSize the herbalSize to set
	 */
	public void setHerbalSize(String herbalSize) {
		this.herbalSize = herbalSize;
	}

	/**
	 * @return the drugDeliverType
	 */
	public String getDrugDeliverType() {
		return drugDeliverType;
	}

	/**
	 * @param drugDeliverType the drugDeliverType to set
	 */
	public void setDrugDeliverType(String drugDeliverType) {
		this.drugDeliverType = drugDeliverType;
	}

	/**
	 * @return the projectUnitCode
	 */
	public String getProjectUnitCode() {
		return projectUnitCode;
	}

	/**
	 * @param projectUnitCode the projectUnitCode to set
	 */
	public void setProjectUnitCode(String projectUnitCode) {
		this.projectUnitCode = projectUnitCode;
	}

	/**
	 * @return the drugSpecNo
	 */
	public String getDrugSpecNo() {
		return drugSpecNo;
	}

	/**
	 * @param drugSpecNo the drugSpecNo to set
	 */
	public void setDrugSpecNo(String drugSpecNo) {
		this.drugSpecNo = drugSpecNo;
	}

	/**
	 * @return the drugSpecLocal
	 */
	public String getDrugSpecLocal() {
		return drugSpecLocal;
	}

	/**
	 * @param drugSpecLocal the drugSpecLocal to set
	 */
	public void setDrugSpecLocal(String drugSpecLocal) {
		this.drugSpecLocal = drugSpecLocal;
	}

	/**
	 * @return the drugSpecSize
	 */
	public String getDrugSpecSize() {
		return drugSpecSize;
	}

	/**
	 * @param drugSpecSize the drugSpecSize to set
	 */
	public void setDrugSpecSize(String drugSpecSize) {
		this.drugSpecSize = drugSpecSize;
	}

	/**
	 * @return the doctorId
	 */
	public String getDoctorId() {
		return doctorId;
	}

	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return the doctorNo
	 */
	public String getDoctorNo() {
		return doctorNo;
	}

	/**
	 * @param doctorNo the doctorNo to set
	 */
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}

	/**
	 * @return the constituent
	 */
	public String getConstituent() {
		return constituent;
	}

	/**
	 * @param constituent the constituent to set
	 */
	public void setConstituent(String constituent) {
		this.constituent = constituent;
	}

	/**
	 * @return the doctorFunction
	 */
	public String getDoctorFunction() {
		return doctorFunction;
	}

	/**
	 * @param doctorFunction the doctorFunction to set
	 */
	public void setDoctorFunction(String doctorFunction) {
		this.doctorFunction = doctorFunction;
	}

	/**
	 * @return the taboo
	 */
	public String getTaboo() {
		return taboo;
	}

	/**
	 * @param taboo the taboo to set
	 */
	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}

	/**
	 * @return the isPrescription
	 */
	public String getIsPrescription() {
		return isPrescription;
	}

	/**
	 * @param isPrescription the isPrescription to set
	 */
	public void setIsPrescription(String isPrescription) {
		this.isPrescription = isPrescription;
	}

	/**
	 * @return the isSeriousDrugs
	 */
	public String getIsSeriousDrugs() {
		return isSeriousDrugs;
	}

	/**
	 * @param isSeriousDrugs the isSeriousDrugs to set
	 */
	public void setIsSeriousDrugs(String isSeriousDrugs) {
		this.isSeriousDrugs = isSeriousDrugs;
	}

	/**
	 * @return the seriousDrugs
	 */
	public String getSeriousDrugs() {
		return seriousDrugs;
	}

	/**
	 * @param seriousDrugs the seriousDrugs to set
	 */
	public void setSeriousDrugs(String seriousDrugs) {
		this.seriousDrugs = seriousDrugs;
	}

	/**
	 * @return the drugFlag
	 */
	public String getDrugFlag() {
		return drugFlag;
	}

	/**
	 * @param drugFlag the drugFlag to set
	 */
	public void setDrugFlag(String drugFlag) {
		this.drugFlag = drugFlag;
	}

	/**
	 * @return the chineseMedicineNo
	 */
	public String getChineseMedicineNo() {
		return chineseMedicineNo;
	}

	/**
	 * @param chineseMedicineNo the chineseMedicineNo to set
	 */
	public void setChineseMedicineNo(String chineseMedicineNo) {
		this.chineseMedicineNo = chineseMedicineNo;
	}

	/**
	 * @return the registerNo
	 */
	public String getRegisterNo() {
		return registerNo;
	}

	/**
	 * @param registerNo the registerNo to set
	 */
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the projectEnglishName
	 */
	public String getProjectEnglishName() {
		return projectEnglishName;
	}

	/**
	 * @param projectEnglishName the projectEnglishName to set
	 */
	public void setProjectEnglishName(String projectEnglishName) {
		this.projectEnglishName = projectEnglishName;
	}

	/**
	 * @return the insurantInnerOut
	 */
	public String getInsurantInnerOut() {
		return insurantInnerOut;
	}

	/**
	 * @param insurantInnerOut the insurantInnerOut to set
	 */
	public void setInsurantInnerOut(String insurantInnerOut) {
		this.insurantInnerOut = insurantInnerOut;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the hosBearMoney
	 */
	public String getHosBearMoney() {
		return hosBearMoney;
	}

	/**
	 * @param hosBearMoney the hosBearMoney to set
	 */
	public void setHosBearMoney(String hosBearMoney) {
		this.hosBearMoney = hosBearMoney;
	}

	/**
	 * @return the extraRecipeFlg
	 */
	public String getExtraRecipeFlg() {
		return extraRecipeFlg;
	}

	/**
	 * @param extraRecipeFlg the extraRecipeFlg to set
	 */
	public void setExtraRecipeFlg(String extraRecipeFlg) {
		this.extraRecipeFlg = extraRecipeFlg;
	}

	/**
	 * @return the examinationResult
	 */
	public String getExaminationResult() {
		return examinationResult;
	}

	/**
	 * @param examinationResult the examinationResult to set
	 */
	public void setExaminationResult(String examinationResult) {
		this.examinationResult = examinationResult;
	}

	/**
	 * @return the referenceRanges
	 */
	public String getReferenceRanges() {
		return referenceRanges;
	}

	/**
	 * @param referenceRanges the referenceRanges to set
	 */
	public void setReferenceRanges(String referenceRanges) {
		this.referenceRanges = referenceRanges;
	}

	/**
	 * @return the examinationHint
	 */
	public String getExaminationHint() {
		return examinationHint;
	}

	/**
	 * @param examinationHint the examinationHint to set
	 */
	public void setExaminationHint(String examinationHint) {
		this.examinationHint = examinationHint;
	}

	/**
	 * @return the selfPayRatio
	 */
	public String getSelfPayRatio() {
		return selfPayRatio;
	}

	/**
	 * @param selfPayRatio the selfPayRatio to set
	 */
	public void setSelfPayRatio(String selfPayRatio) {
		this.selfPayRatio = selfPayRatio;
	}

	/**
	 * @return the medlimitedPrice
	 */
	public String getMedlimitedPrice() {
		return medlimitedPrice;
	}

	/**
	 * @param medlimitedPrice the medlimitedPrice to set
	 */
	public void setMedlimitedPrice(String medlimitedPrice) {
		this.medlimitedPrice = medlimitedPrice;
	}

	/**
	 * @return the totalSelfFundFlag
	 */
	public String getTotalSelfFundFlag() {
		return totalSelfFundFlag;
	}

	/**
	 * @param totalSelfFundFlag the totalSelfFundFlag to set
	 */
	public void setTotalSelfFundFlag(String totalSelfFundFlag) {
		this.totalSelfFundFlag = totalSelfFundFlag;
	}

	

	/**
	 * @return the directions
	 */
	public String getDirections() {
		return directions;
	}

	/**
	 * @param directions the directions to set
	 */
	public void setDirections(String directions) {
		this.directions = directions;
	}

	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeeDetailModel [medicalBillingNo=" + medicalBillingNo + ", feeDetailNo=" + feeDetailNo + ", listCat="
				+ listCat + ", medicalItemCat=" + medicalItemCat + ", listCatName=" + listCatName + ", chargeLevel="
				+ chargeLevel + ", projectNo=" + projectNo + ", projectName=" + projectName + ", price=" + price
				+ ", size=" + size + ", amount=" + amount + ", visitDepartment=" + visitDepartment + ", departmentName="
				+ departmentName + ", hospitalChargeCode=" + hospitalChargeCode + ", hospitalChargeName="
				+ hospitalChargeName + ", selfAmount=" + selfAmount + ", selfPayAmount=" + selfPayAmount
				+ ", departmentCode=" + departmentCode + ", insurItemCode=" + insurItemCode + ", insurItemName="
				+ insurItemName + ", insuranceCatAdminLevel=" + insuranceCatAdminLevel + ", prescriptionNo="
				+ prescriptionNo + ", prescriptionSerialNo=" + prescriptionSerialNo + ", projectDosage=" + projectDosage
				+ ", projectUnit=" + projectUnit + ", projectSpec=" + projectSpec + ", projectLocalName="
				+ projectLocalName + ", packageSize=" + packageSize + ", packageUnit=" + packageUnit
				+ ", minDosageUnit=" + minDosageUnit + ", normalUsage=" + normalUsage + ", useUnit=" + useUnit
				+ ", everyDaySize=" + everyDaySize + ", useDaySize=" + useDaySize + ", isSingleRemedy=" + isSingleRemedy
				+ ", herbalSize=" + herbalSize + ", drugDeliverType=" + drugDeliverType + ", projectUnitCode="
				+ projectUnitCode + ", drugSpecNo=" + drugSpecNo + ", drugSpecLocal=" + drugSpecLocal
				+ ", drugSpecSize=" + drugSpecSize + ", doctorId=" + doctorId + ", doctorName=" + doctorName
				+ ", doctorNo=" + doctorNo + ", constituent=" + constituent + ", doctorFunction=" + doctorFunction
				+ ", taboo=" + taboo + ", isPrescription=" + isPrescription + ", isSeriousDrugs=" + isSeriousDrugs
				+ ", seriousDrugs=" + seriousDrugs + ", drugFlag=" + drugFlag + ", chineseMedicineNo="
				+ chineseMedicineNo + ", registerNo=" + registerNo + ", brand=" + brand + ", projectEnglishName="
				+ projectEnglishName + ", insurantInnerOut=" + insurantInnerOut + ", manufacturer=" + manufacturer
				+ ", hosBearMoney=" + hosBearMoney + ", extraRecipeFlg=" + extraRecipeFlg + ", examinationResult="
				+ examinationResult + ", referenceRanges=" + referenceRanges + ", examinationHint=" + examinationHint
				+ ", selfPayRatio=" + selfPayRatio + ", medlimitedPrice=" + medlimitedPrice + ", totalSelfFundFlag="
				+ totalSelfFundFlag + ", directions=" + directions + ", updateBy=" + updateBy + "]";
	}
	
	
	

}
