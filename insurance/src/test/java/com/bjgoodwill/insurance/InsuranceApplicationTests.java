package com.bjgoodwill.insurance;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.bjgoodwill.insurance.consts.SystemConstant;
import com.bjgoodwill.insurance.pub.service.PublishModelService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
/**
 * @Package com.bjgoodwill.insurance
 * @Description: 单元测试类
 * @author li_jun 
 * @date 2018年4月9日 下午5:58:30
 * @GUID {c77447d1-353f-4315-8ae3-df311af04555}
 */
public class InsuranceApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(InsuranceApplicationTests.class);
    @Autowired
    PublishModelService         publishModelService;

    /**
     * @Title: getPatientInfo
     * @Description: 患者基本信息
     * @return String    整合信息，由JsonObject转为String
     */
    @Test
    public void getPatientInfoTest() {
        // 模拟数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("modelCode", SystemConstant.PATIENT_MODEL_CODE);
        jsonObject.put("patientId", "0000001");
        jsonObject.put("patientName", "zhangsan");
        jsonObject.put("ins_code", "000001");
        String result = publishModelService.getPatientInfo(jsonObject);
        JSONObject jsonResult = JSONObject.parseObject(result);
        Assert.assertNotNull(jsonResult);
        logger.error(jsonResult.toString());
        System.out.println(jsonResult);
    }

    /**
     * @Title: getOutPatientInfo
     * @Description: 门诊就诊信息
     * @return String    整合信息，由JsonObject转为String
     */
    @Test
    public void getOutPatientInfoTest() {
        // 模拟数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("modelCode", SystemConstant.OUTPATIENT_MODEL_CODE);
        jsonObject.put("patientId", "1111");
        jsonObject.put("medicalNum", "1111");
        String result = publishModelService.getOutPatientInfo(jsonObject);
        JSONObject jsonResult = JSONObject.parseObject(result);
        Assert.assertNotNull(jsonResult);
        logger.error(jsonResult.toString());
        System.out.println(jsonResult);
    }

    /**
     * @Title: getHospitalizedInfo
     * @Description: 住院入院信息
     * @return String    整合信息，由JsonObject转为String
     */
    @Test
    public void getHospitalizedInfoTest() {
        // 模拟数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("modelCode", SystemConstant.HOSPITALIZED_MODEL_CODE);
        jsonObject.put("patientId", "1111");
        jsonObject.put("medicalNum", "1111");
        String result = publishModelService.getHospitalizedInfo(jsonObject);
        JSONObject jsonResult = JSONObject.parseObject(result);
        Assert.assertNotNull(jsonResult);
        logger.error(jsonResult.toString());
        System.out.println(jsonResult);
    }

    /**
     * @Title: getFeeInfo
     * @Description: 费用信息
     * @return String    整合信息，由JsonObject转为String
     */
    @Test
    public void getFeeInfoTest() {
        // 模拟数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("modelCode", SystemConstant.FEE_MODEL_CODE);
        jsonObject.put("patientId", "000001");
        jsonObject.put("invoiceNo", "0008");
        jsonObject.put("medicalBillingNo", "000023");
        jsonObject.put("medicalItemCatID", "1234");
        jsonObject.put("healthNum", "13739740528");
        String result = publishModelService.getFeeInfo(jsonObject);
        JSONObject jsonResult = JSONObject.parseObject(result);
        Assert.assertNotNull(jsonResult);
        logger.error(jsonResult.toString());
        System.out.println(jsonResult);
    }

    /**
     * @Title: getRecordInfo
     * @Description: 病历信息
     * @return String    整合信息，由JsonObject转为String
     */
    @Test
    public void getRecordInfoTest() {
        // 模拟数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("medicalNum", "000002");
        jsonObject.put("patientId", "123456");
        jsonObject.put("hospitalRecordId", "00002");
        jsonObject.put("modelCode", SystemConstant.RECORD_MODEL_CODE);
        String result = publishModelService.getRecordInfo(jsonObject);
        JSONObject jsonResult = JSONObject.parseObject(result);
        Assert.assertNotNull(jsonResult);
        logger.error(jsonResult.toString());
        System.out.println(jsonResult);
    }

    /**
     * @Title: getOtherInfo
     * @Description: 其他模块信息（检验、检查）
     * @return String    整合信息，由JsonObject转为String
     */
    @Test
    public void getOtherInfoTest() {
        // 模拟数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("modelCode", SystemConstant.OTHER_MODEL_CODE);
        jsonObject.put("patientId", "0000001");
        jsonObject.put("labNum", "020001");
        jsonObject.put("recordNum", "010001");
        String result = publishModelService.getOtherInfo(jsonObject);
        JSONObject jsonResult = JSONObject.parseObject(result);
        Assert.assertNotNull(jsonResult);
        logger.error(jsonResult.toString());
        System.out.println(jsonResult);
    }

    /**
     * @Title: getAllInfoTest
     * @Description: 各个模块整体调用
     */
    @Test
    public void getAllInfoTest() {
        getPatientInfoTest();
        getOutPatientInfoTest();
        getHospitalizedInfoTest();
        getFeeInfoTest();
        getRecordInfoTest();
        getOtherInfoTest();
    }
}
