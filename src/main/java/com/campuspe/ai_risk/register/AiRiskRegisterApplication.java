package com.campuspe.ai_risk.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(
		exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class}
)
public class AiRiskRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiRiskRegisterApplication.class, args);
	}
}