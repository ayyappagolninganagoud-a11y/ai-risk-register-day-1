package com.campuspe.ai_risk.register.service;

import com.campuspe.ai_risk.register.Risk;
import com.campuspe.ai_risk.register.exception.RiskNotFoundException;
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
        risk.setId(counter++);
        riskList.add(risk);
        return risk;
    }

    // GET ALL (PAGINATED)
    @Cacheable(value = "risks", key = "'risks:' + #page + ':' + #size")
    public List<Risk> getAllRisks(int page, int size) {

        System.out.println("👉 getAllRisks() method called");
        System.out.println("SERVICE EXECUTED (NOT FROM CACHE)");

        if (riskList.isEmpty()) {
            return new ArrayList<>();
        }

        int start = page * size;

        if (start >= riskList.size()) {
            return new ArrayList<>();
        }

        int end = Math.min(start + size, riskList.size());

        List<Risk> result = new ArrayList<>();

        for (int i = start; i < end; i++) {
            result.add(riskList.get(i));
        }

        return result;
    }

    // GET BY ID
    @CacheEvict(value = "risk", allEntries = true)
    @Cacheable(value = "risk", key = "#id")
    public Risk getRiskById(Long id) {
        return riskList.stream()
                .filter(r -> r.getId() != null && r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RiskNotFoundException("Risk not found with id: " + id));
    }
}