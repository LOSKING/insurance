package com.bjgoodwill.insurance;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @author zhangq
 * @date 2018年3月22日 下午10:45:41
 * 用Tomcat做Web服务器的时候入口
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(InsuranceApplication.class);
	}

}
