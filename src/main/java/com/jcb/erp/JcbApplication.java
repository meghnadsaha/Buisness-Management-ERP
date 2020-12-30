package com.jcb.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Profile("!test")
@EnableScheduling
@PropertySources({ @PropertySource("classpath:application.properties"),
		@PropertySource("classpath:application-${spring.profiles.active}.properties") })
public class JcbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JcbApplication.class, args);
	}

}
