package com.lizh.studyHub.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * 自定义Swagger 接口文档配置
 * @author Lizh
 */
@Configuration
@EnableSwagger2WebMvc
@Profile({"dev","test"})
public class SwaggerConfig {
/**
     * 创建API
     */
    @Bean(value = "defaultApi2")
    public Docket createRestApi() {
        // 指定扫描包路径
        return new Docket(DocumentationType.SWAGGER_2) // 指定生成的文档的类型是Swagger2
                .apiInfo(apiInfo())
//                .pathMapping("/swagger")
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）,配置文档页面的基本信息内容
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.lizh.studyHub.controller"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }
 
    /**
     * api信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("用户管理中心")
                // 描述
                .description("用户管理中心接口文档")
                .termsOfServiceUrl("https://github.com/Anstars")
                //作者信息、联系方式：Contact(String name, String url, String email)
                .contact(new Contact("lizh","https://github.com/Anstars","xxx@qq.com"))
                // 版本
                .version("版本号: 1.0.1")
                .build();
    }
 
}