package com.biu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userServiceApi() {
        return GroupedOpenApi.builder()
                .group("用户服务")  // 分组名称
                .pathsToMatch("/**")  // 设置API路径匹配规则
                .packagesToScan("com.biu.controller")  // 扫描指定包路径
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Knife4j RESTful APIs")
                        .version("1.0")
                        .description("# Knife4j RESTful APIs")
                        .termsOfService("https://doc.xiaominfo.com/")
                        .contact(new Contact().name("my")
                                .url("http://127.0.0.1:8101/api/")
                                .email("2325995108@qq.com"))
                );
    }
}
