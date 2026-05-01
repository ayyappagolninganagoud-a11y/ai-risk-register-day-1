package com.campuspe.ai_risk.register.repository;

import com.campuspe.ai_risk.register.Risk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskRepository extends JpaRepository<Risk, Long> {
}