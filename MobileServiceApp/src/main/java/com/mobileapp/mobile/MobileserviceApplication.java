package com.mobileapp.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.mobileapp.mobile.filter.JwtFilter;

@SpringBootApplication
public class MobileserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileserviceApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/app");
		return filter;
	}
	
	

}
