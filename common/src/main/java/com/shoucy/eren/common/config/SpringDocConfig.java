package com.shoucy.eren.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc API文档相关配置
 *
 * @author shoucy
 */
// @Configuration
public class SpringDocConfig {

	// @Bean
	// public OpenAPI springDocOpenApi() {
	// return new OpenAPI().info(new Info().title("freedom
	// Api").version("v0.0.1-SNAPSHOT"));
	// // 配置Authorizations
	// // .components(new Components().addSecuritySchemes("bearer-key",
	// // new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")));
	// }
	//
	// @Bean
	// public GroupedOpenApi systemApi() {
	// return GroupedOpenApi.builder().group("system").pathsToMatch("/system/**").build();
	// }

}