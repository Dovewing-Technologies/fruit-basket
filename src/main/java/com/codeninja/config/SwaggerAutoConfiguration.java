package com.codeninja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author niranjansathindran.
 */

@Configuration
@EnableSwagger2
@Import({ BeanValidatorPluginsConfiguration.class })
public class SwaggerAutoConfiguration {

	@Bean
	public Docket categoryApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build()
				.ignoredParameterTypes(ApiIgnore.class)
				.enableUrlTemplating(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Fruit Basket Application")
				.version("v1")
				.build();
	}
}
