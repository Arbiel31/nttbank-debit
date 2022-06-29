package com.nttdata.nttbankdebit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NttbankDebitApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttbankDebitApplication.class, args);
	}

}
