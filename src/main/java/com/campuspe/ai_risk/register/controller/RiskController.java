package com.campuspe.ai_risk.register.controller;

import com.campuspe.ai_risk.register.Risk;
import com.campuspe.ai_risk.register.service.RiskService;
import com.campuspe.ai_risk.register.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/risks")
public class RiskController {

    @Autowired
    private RiskService riskService;

    @Autowired
    private EmailService emailService;

    // CREATE
    @PostMapping
    public Risk addRisk(@Valid @RequestBody Risk risk) {
        return riskService.addRisk(risk);
    }

    // GET ALL (PAGINATION)
    @GetMapping("/all")
    public List<Risk> getAllRisks(@RequestParam int page, @RequestParam int size) {
        return riskService.getAllRisks(page, size);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Risk> getRiskById(@PathVariable Long id) {
        Risk risk = riskService.getRiskById(id);
        return ResponseEntity.ok(risk);
    }

    // UPDATE (PUT)  ✅ FIX FOR YOUR ERROR
    @PutMapping("/{id}")
    public Risk updateRisk(@PathVariable Long id,
                           @Valid @RequestBody Risk risk) {
        return riskService.updateRisk(id, risk);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteRisk(@PathVariable Long id) {
        riskService.deleteRisk(id);
        return "Risk deleted successfully with id: " + id;
    }
}
