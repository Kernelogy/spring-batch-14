package com.edex.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;


// @Configuration
// public class MultipartResolverConfig {

// 	@Bean(name = "multipartResolver")
// 	public MultipartResolver multipartResolver() {
// 		final CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
// //	    multipartResolver.setMaxUploadSize(1000000000);
// 		multipartResolver.setMaxUploadSize(1999999999);
// //		multipartResolver.setMaxUploadSize(-1);
// 	    return multipartResolver;
// 	}
	
// }