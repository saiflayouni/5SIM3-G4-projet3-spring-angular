package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReglementServiceImplTestJUnit {
    @Autowired
    private final ReglementRepository reglementRepository;
    @Autowired
    private final ReglementServiceImpl reglementService;

    

    @Test
    @Order(1)
    void retrieveAllReglements() {
        List<Reglement> reglements = new ArrayList<>();
        reglementRepository.findAll();
        List<Reglement> result = reglementService.retrieveAllReglements();

        assertNotNull(result);
        assertTrue(result.isEmpty());

        System.out.println("RetrieveAllReglementsTest : Ok");
    }

    @Test
    @Order(2)
    void addReglement() {
        Reglement reglement = new Reglement();
        reglementRepository.save(reglement);
        Reglement result = reglementService.addReglement(reglement);

        assertNotNull(result);

        System.out.println("AddReglementTest : Ok");
    }

    @Test
    @Order(3)
    void retrieveReglement() {
        Long reglementId = 1L;
        Reglement reglement = new Reglement();
        reglementRepository.findById(reglementId);
        Reglement result = reglementService.retrieveReglement(reglementId);

        assertNotNull(result);

        System.out.println("RetrieveReglementTest : Ok");
    }

    // Similar adjustments for other tests
}
