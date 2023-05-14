package com.olp.notification_mgmt;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@PropertySources({ @PropertySource("classpath:restmessages.properties"),
	@PropertySource("classpath:queries.properties") })
public class NotificationManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationManagementApplication.class, args);
		
		System.out.println("*******************************************************************");
		System.out.println("Notification Management Application Started @" + Calendar.getInstance().getTime());
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
