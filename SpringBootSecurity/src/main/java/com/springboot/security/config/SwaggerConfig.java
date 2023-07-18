package com.springboot.security.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {

		return new ApiInfo("Spring Security API ", "Spring Boot Security Demo Project", "1.0", "Term of condition",
				new Contact("Pritam Rajput", "https://pritamrajput.wordpress.com/", "pritamrajput1906@gmail.com"),
				"License of APIS", "API license URL", Collections.emptyList());
	}

}
