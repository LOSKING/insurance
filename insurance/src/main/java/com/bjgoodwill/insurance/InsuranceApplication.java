package com.bjgoodwill.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "com.bjgoodwill.insurance.*.dao")
public class InsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceApplication.class, args);
	}
}
