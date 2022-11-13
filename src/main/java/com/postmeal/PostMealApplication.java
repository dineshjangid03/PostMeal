package com.postmeal;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PostMealApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostMealApplication.class, args);
	}
	
	@Bean
    Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .apiInfo(apiDetails());
    }
	
	public ApiInfo apiDetails() {
		return new ApiInfo(
				"PostMeal API",
				"Sample API For Online food Delivery App",
				"pm",
				"Free to use",
				new springfox.documentation.service.Contact("PostMeal Team", "Pstmeal.io", "postMeal@gmail.com"),
				"API license",
				"http://postmeal.io",
				Collections.emptyList()
				);
		
	}

	
}
