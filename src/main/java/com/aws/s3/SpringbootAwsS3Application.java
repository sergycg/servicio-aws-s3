package com.aws.s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class SpringbootAwsS3Application {

	@Value("${herokuNotIdle.url}")
	private String herokuNotIdle_url;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsS3Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Scheduled(cron = "${herokuNotIdle.cronExpression}")
	public void herokuNotIdle(RestTemplate restTemplate) {
		System.out.println(" INIT - Heroku not idle execution ");
		ResponseEntity<String> response = restTemplate.exchange(herokuNotIdle_url, HttpMethod.GET, null, String.class);
		System.out.println(response);
		System.out.println(" FINISH - Heroku not idle execution");
	}
}
