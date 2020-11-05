package cn.shop.mall.app.config;

import cn.shop.mall.common.model.UserHeader;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * swagger配置：dev本地、test测试环境开启
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        //构造请求头
        ParameterBuilder accessTokenBar = new ParameterBuilder();
        List<Parameter> pars = Lists.newArrayList();
        accessTokenBar.name(UserHeader.AuthToken).description("头部Token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(accessTokenBar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.shop.mall.admin.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商城管理")
                .description("商城管理接口文档说明")
                .version("1.0")
                .build();
    }

}
