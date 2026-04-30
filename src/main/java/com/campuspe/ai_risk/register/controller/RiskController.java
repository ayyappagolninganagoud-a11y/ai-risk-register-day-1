package com.campuspe.ai_risk.register.controller;

import com.campuspe.ai_risk.register.Risk;
import com.campuspe.ai_risk.register.service.RiskService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risks")
public class RiskController {

    @Autowired
    private RiskService riskService;

    @PostMapping
    public Risk addRisk(@RequestBody Risk risk) {
        return riskService.addRisk(risk);
    }

    @GetMapping("/all")
    public List<Risk> getAllRisks(@RequestParam int page, @RequestParam int size) {
        System.out.println("Controller /risks/all called");
        return riskService.getAllRisks(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Risk> getRiskById(@PathVariable Long id) {
        Risk risk = riskService.getRiskById(id);
        return ResponseEntity.ok(risk);
    }
}