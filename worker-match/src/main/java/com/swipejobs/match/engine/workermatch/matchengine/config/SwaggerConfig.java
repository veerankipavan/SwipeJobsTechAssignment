package com.swipejobs.match.engine.workermatch.matchengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket matchEngineAPI(){
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.
                basePackage("com.swipejobs.match.engine.workermatch")).
                    paths(regex("/matches.*")).build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {

        return new ApiInfo("Job Matching Engine for Worker API","Job Matching Engine for worker  API reference for developers","1.0","Terms of Service",
                new Contact("Job Matcher","https://www.google.com.au/","pavanveeranki@gmail.com"),"Apache Licence Version 2.0","http://www.apache.org/licenses/LICENSE-2.0",new ArrayList<VendorExtension>());
        }
}
