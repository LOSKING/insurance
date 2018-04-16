package com.bjgoodwill.insurance.main.dic.model;

/**
 * @Package: com.bjgoodwill.insurance.main.dic.model
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liuxiaochuan 
 * @date 2018年4月10日 下午5:26:49
 * @GUID  {121d133e-35c8-43fd-9f6e-7572d4323ece}
 */
public class DicRlatModel {
	//主键
	private String id ;
	//字典编码（保险公司的字典编码）
	private String codeIns ;
	//字典名称（保险公司的字典名称）
	private String nameIns ;
	//字典编码（医院的字典编码）
	private String codeHosp ;
	//字典名称（医院的字典名称）
	private String nameHosp ;
	//保险公司编码
	private String insCode ;
	//保险公司名称
	private String insName ;
	//字典类型编码
	private String dicTypeId ;
	//字典类型名称
	private String dicTypeName ;
	//创建日期
	private String creatTime ;
	//修改人编码
	private String operId ;
	//备注信息
	private String comment ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodeIns() {
		return codeIns;
	}

	public void setCodeIns(String codeIns) {
		this.codeIns = codeIns;
	}

	public String getNameIns() {
		return nameIns;
	}

	public void setNameIns(String nameIns) {
		this.nameIns = nameIns;
	}

	public String getCodeHosp() {
		return codeHosp;
	}

	public void setCodeHosp(String codeHosp) {
		this.codeHosp = codeHosp;
	}

	public String getNameHosp() {
		return nameHosp;
	}

	public void setNameHosp(String nameHosp) {
		this.nameHosp = nameHosp;
	}

	public String getInsCode() {
		return insCode;
	}

	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getDicTypeId() {
		return dicTypeId;
	}

	public void setDicTypeId(String dicTypeId) {
		this.dicTypeId = dicTypeId;
	}

	public String getDicTypeName() {
		return dicTypeName;
	}

	public void setDicTypeName(String dicTypeName) {
		this.dicTypeName = dicTypeName;
	}

	public String getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
