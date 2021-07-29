package com.example.wechat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger3配置
 *
 * @author fu.yuanming
 * @date 2021-07-27
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("微信小程序接口文档").description("微信小程序后端接口")
                .version("1.0.0").build();
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo).useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.basePackage("com.example.wechat.controller")).build();
    }

}
