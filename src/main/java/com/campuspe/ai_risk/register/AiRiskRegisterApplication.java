package com.campuspo.ai_risk_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class}
)
public class AiRiskRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiRiskRegisterApplication.class, args);
	}
}