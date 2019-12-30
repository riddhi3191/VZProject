package com.riddhi.cloud.salesorder;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients("com.riddhi.cloud.salesorder")
@SpringBootApplication
@EnableDiscoveryClient
public class SalesOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
