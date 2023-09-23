package com.example.SpeakingClock.SpeakingClock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.SpeakingClock.SpeakingClock.controller"))
                .build()
                .apiInfo(new ApiInfoBuilder().title("Speaking Clock API").version("3.0").build());
    }
    }

   // @Bean
   // public UiConfiguration uiConfiguration() {
      //  return UiConfigurationBuilder.builder()
           //     .displayRequestDuration(true)
    //.build();

  //  }


