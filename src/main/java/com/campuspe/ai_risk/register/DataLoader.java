package com.campuspe.ai_risk.register;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.campuspe.ai_risk.register.service.RiskService;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(RiskService riskService) {
        return args -> {

            List<Risk> risks = Arrays.asList(

                    new Risk(null, "Data Leak", "Sensitive data exposed", "HIGH"),
                    new Risk(null, "Model Bias", "AI shows bias", "MEDIUM"),
                    new Risk(null, "System Crash", "App crashes randomly", "HIGH"),
                    new Risk(null, "Slow Response", "API delay issue", "LOW"),
                    new Risk(null, "Security Risk", "Unauthorized access", "HIGH"),
                    new Risk(null, "Data Loss", "Records missing", "HIGH"),
                    new Risk(null, "Integration Issue", "3rd party failure", "MEDIUM"),
                    new Risk(null, "Memory Leak", "High RAM usage", "HIGH"),
                    new Risk(null, "UI Bug", "Frontend issue", "LOW"),
                    new Risk(null, "Incorrect Output", "Wrong AI prediction", "MEDIUM"),

                    new Risk(null, "Network Failure", "Connectivity issue", "HIGH"),
                    new Risk(null, "Timeout Error", "Request timeout", "MEDIUM"),
                    new Risk(null, "Duplicate Data", "Repeated records", "LOW"),
                    new Risk(null, "Permission Issue", "Access denied", "HIGH"),
                    new Risk(null, "Logging Failure", "Logs not generated", "LOW"),
                    new Risk(null, "Cache Issue", "Old data returned", "MEDIUM"),
                    new Risk(null, "Database Error", "DB connection fail", "HIGH"),
                    new Risk(null, "API Failure", "External API down", "HIGH"),
                    new Risk(null, "Validation Error", "Wrong input accepted", "MEDIUM"),
                    new Risk(null, "Deployment Issue", "App not deployed", "HIGH"),

                    new Risk(null, "Scaling Problem", "Cannot handle load", "HIGH"),
                    new Risk(null, "Thread Block", "Concurrency issue", "MEDIUM"),
                    new Risk(null, "Crash Loop", "Restart again & again", "HIGH"),
                    new Risk(null, "Config Error", "Wrong config", "LOW"),
                    new Risk(null, "Latency Issue", "Slow processing", "MEDIUM"),
                    new Risk(null, "Disk Full", "No storage left", "HIGH"),
                    new Risk(null, "Backup Failure", "Backup not working", "HIGH"),
                    new Risk(null, "Service Down", "Service unavailable", "HIGH"),
                    new Risk(null, "Auth Failure", "Login not working", "MEDIUM"),
                    new Risk(null, "Unknown Bug", "Unexpected issue", "LOW")

            );

            risks.forEach(riskService::addRisk);

            System.out.println("✅ 30 Demo Risks Loaded Successfully!");
        };
    }
}
