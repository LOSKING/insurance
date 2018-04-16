package com.bjgoodwill.insurance.patient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bjgoodwill.insurance.patient.service.PatientService;

/**
 * 患者controller
 * @Package: com.bjgoodwill.insurance.patient.controller
 * @author zhangq
 * @date 2018年3月22日 下午7:01:52
 */
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    //异常消息已经由异常拦截器统一写入日志文件
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    private PatientService      patientService;

    @PostMapping(value = "/getByPrimaryKey")
    public String getByPrimaryKey(@RequestParam("patientId") String patientId, @RequestParam("patientName") String patientName) {
        
        return "";
    }
}
