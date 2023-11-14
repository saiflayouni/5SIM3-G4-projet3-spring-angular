package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith; // Added import
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.esprit.examen.TpAchatProjectApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension; // Added import

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TpAchatProjectApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class) // Added annotation
class ReglementServiceImplTestJUnit {

    @Autowired
    private ReglementRepository reglementRepository;

    @Autowired
    private ReglementServiceImpl reglementService;

    @Test
    @Order(1)
    void retrieveAllReglements() {
        // Assuming you have some test data in your database
        // Fetch all Reglements
        List<Reglement> result = reglementService.retrieveAllReglements();

        assertNotNull(result);
        assertEquals(0, result.size()); // Assuming no test data, adjust accordingly

        System.out.println("RetrieveAllReglementsTest : Ok");
    }

    @Test
    @Order(2)
    void addReglement() {
        // Create a new Reglement
        Reglement reglement = new Reglement();
        reglementRepository.save(reglement);

        // Fetch the Reglement by ID
        Reglement result = reglementService.retrieveReglement(reglement.getIdReglement());

        assertNotNull(result);
        assertEquals(reglement.getIdReglement(), result.getIdReglement());

        System.out.println("AddReglementTest : Ok");
    }

    @Test
    @Order(3)
    void retrieveReglement() {
        Long reglementId = 1L;

        // Fetch the Reglement by ID
        Reglement result = reglementService.retrieveReglement(reglementId);

        assertNotNull(result);
        assertEquals(reglementId, result.getIdReglement());

        System.out.println("RetrieveReglementTest : Ok");
    }
