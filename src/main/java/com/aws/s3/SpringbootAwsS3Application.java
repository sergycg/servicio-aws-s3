package com.aws.s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootAwsS3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsS3Application.class, args);
	}

}
