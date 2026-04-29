package com.campuspe.ai_risk.register.service;

import com.campuspe.ai_risk.register.exception.RiskNotFoundException;
import com.campuspe.ai_risk.register.Risk;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskService {

    private List<Risk> riskList = new ArrayList<>();
    private long counter = 1;

    // CREATE
    public Risk addRisk(Risk risk) {
        risk.setId(counter++);
        riskList.add(risk);
        return risk;
    }

    // GET ALL (PAGINATED)
    public List<Risk> getAllRisks(int page, int size) {

        int start = page * size;
        int end = Math.min(start + size, riskList.size());

        if (start > riskList.size()) {
            return new ArrayList<>();
        }

        return riskList.subList(start, end);
    }

    // GET BY ID
    public Risk getRiskById(Long id) {
        return riskList.stream()
                .filter(r -> r.getId() != null && r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RiskNotFoundException("Risk not found with id: " + id));
    }
}