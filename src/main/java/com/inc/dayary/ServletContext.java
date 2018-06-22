package com.inc.dayary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.inc.dayary.interceptor.SigninInterceptor;

@Configuration
public class ServletContext implements WebMvcConfigurer{

	@Autowired
	private SigninInterceptor signinInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(signinInterceptor).addPathPatterns("/")
		.addPathPatterns("/member/mypage").addPathPatterns("/diary/**");
		
		
	}
	
	
}
