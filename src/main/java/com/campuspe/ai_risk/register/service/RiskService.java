package com.campuspe.ai_risk.register.service;

import com.campuspe.ai_risk.register.Risk;
import com.campuspe.ai_risk.register.exception.RiskNotFoundException;
import com.campuspe.ai_risk.register.exception.InvalidRiskException;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskService {

    private List<Risk> riskList = new ArrayList<>();
    private long counter = 1;

    // CREATE
    @CacheEvict(value = "risks", allEntries = true)
    public Risk addRisk(Risk risk) {

        if (risk.getRiskName() == null || risk.getRiskName().isEmpty()) {
            throw new InvalidRiskException("Risk name cannot be empty");
        }

        if (risk.getDescription() == null || risk.getDescription().isEmpty()) {
            throw new InvalidRiskException("Description cannot be empty");
        }

        if (risk.getSeverity() == null) {
            throw new InvalidRiskException("Severity is required");
        }

        risk.setId(counter++);
        riskList.add(risk);
        return risk;
    }

    // GET ALL
    @Cacheable(value = "risks", key = "'risks:' + #page + ':' + #size")
    public List<Risk> getAllRisks(int page, int size) {

        int start = page * size;

        if (start >= riskList.size()) {
            return new ArrayList<>();
        }

        int end = Math.min(start + size, riskList.size());

        return new ArrayList<>(riskList.subList(start, end));
    }

    // GET BY ID
    @Cacheable(value = "risk", key = "#id")
    public Risk getRiskById(Long id) {
        return riskList.stream()
                .filter(r -> r.getId() != null && r.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new RiskNotFoundException("Risk not found with id: " + id));
    }

    // UPDATE  ✅ FIXED
    @CacheEvict(value = "risk", allEntries = true)
    public Risk updateRisk(Long id, Risk riskDetails) {

        Risk existingRisk = getRiskById(id);

        if (riskDetails.getRiskName() != null && !riskDetails.getRiskName().isEmpty()) {
            existingRisk.setRiskName(riskDetails.getRiskName());
        }

        if (riskDetails.getDescription() != null && !riskDetails.getDescription().isEmpty()) {
            existingRisk.setDescription(riskDetails.getDescription());
        }

        if (riskDetails.getSeverity() != null) {
            existingRisk.setSeverity(riskDetails.getSeverity());
        }

        return existingRisk;
    }

    // DELETE  ✅ FIXED
    @CacheEvict(value = "risk", allEntries = true)
    public void deleteRisk(Long id) {

        Risk existingRisk = getRiskById(id);
        riskList.remove(existingRisk);
    }
}