package com.campuspe.ai_risk.register.service;

import com.campuspe.ai_risk.register.Risk;
import com.campuspe.ai_risk.register.exception.RiskNotFoundException;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RiskServiceTest {

    private RiskService riskService = new RiskService();

    // 1. Happy path - addRisk
    @Test
    void testAddRisk_Success() {
        Risk risk = new Risk();

        Risk result = riskService.addRisk(risk);

        assertNotNull(result.getId());
    }

    // 2. Happy path - getAllRisks
    @Test
    void testGetAllRisks_Success() {
        riskService.addRisk(new Risk());
        riskService.addRisk(new Risk());

        List<Risk> risks = riskService.getAllRisks(0, 10);

        assertEquals(2, risks.size());
    }

    // 3. Edge case - empty list
    @Test
    void testGetAllRisks_Empty() {
        List<Risk> risks = riskService.getAllRisks(0, 10);

        assertTrue(risks.isEmpty());
    }

    // 4. Happy path - getRiskById
    @Test
    void testGetRiskById_Success() {
        Risk risk = new Risk();
        Risk saved = riskService.addRisk(risk);

        Risk result = riskService.getRiskById(saved.getId());

        assertNotNull(result);
    }

    // 5. Error case - getRiskById
    @Test
    void testGetRiskById_NotFound() {
        assertThrows(RiskNotFoundException.class, () ->
                riskService.getRiskById(999L)
        );
    }

    // 6. Pagination test
    @Test
    void testPagination() {
        for (int i = 0; i < 5; i++) {
            riskService.addRisk(new Risk());
        }

        List<Risk> page1 = riskService.getAllRisks(0, 2);
        List<Risk> page2 = riskService.getAllRisks(1, 2);

        assertEquals(2, page1.size());
        assertEquals(2, page2.size());
    }

    // 7. Pagination overflow
    @Test
    void testPagination_Overflow() {
        riskService.addRisk(new Risk());

        List<Risk> risks = riskService.getAllRisks(5, 10);

        assertTrue(risks.isEmpty());
    }

    // 8. Multiple adds
    @Test
    void testMultipleAdds() {
        riskService.addRisk(new Risk());
        riskService.addRisk(new Risk());

        List<Risk> risks = riskService.getAllRisks(0, 10);

        assertEquals(2, risks.size());
    }

    // 9. ID increment check
    @Test
    void testIdIncrement() {
        Risk r1 = riskService.addRisk(new Risk());
        Risk r2 = riskService.addRisk(new Risk());

        assertTrue(r2.getId() > r1.getId());
    }

    // 10. Null ID handling
    @Test
    void testNullIdHandling() {
        Risk risk = new Risk();
        Risk saved = riskService.addRisk(risk);

        assertNotNull(saved.getId());
    }
}