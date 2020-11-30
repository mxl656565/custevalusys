/**
 * 公司:
 * 文件名:SwaggerConfig
 * 作者：asus
 * 时间：2020/8/13 13:56
 * 描述：
 */
package com.waymap.custevalusys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : tiger
 * @description :
 * @email : tiger.liu@waymap.cn
 * @date : 2020/8/13
 */
@Component
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.waymap.custevalusys.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    protected ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("客户评价系统接口")
                .description("custevalusys")
                .version("1.0")
                .build();
    }
}
