package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceImplTest {
    @InjectMocks
    private ProduitServiceImpl produitService;

    @Mock
    private ProduitRepository produitRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllProduits() {
        List<Produit> produits = new ArrayList<>();
        produits.add(new Produit());
        when(produitRepository.findAll()).thenReturn(produits);

        List<Produit> result = produitService.retrieveAllProduits();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddProduit() {
        Produit produit = new Produit();
        when(produitRepository.save(produit)).thenReturn(produit);

        Produit savedProduit = produitService.addProduit(produit);

        assertNotNull(savedProduit);
        assertEquals(produit, savedProduit);
    }

    @Test
    public void testDeleteProduit() {
        long produitId = 1L;
        produitService.deleteProduit(produitId);

        verify(produitRepository, times(1)).deleteById(produitId);
    }

    @Test
    public void testUpdateProduit() {
        Produit produit = new Produit();
        when(produitRepository.save(produit)).thenReturn(produit);

        Produit updatedProduit = produitService.updateProduit(produit);

        assertNotNull(updatedProduit);
        assertEquals(produit, updatedProduit);
    }

    @Test
    public void testRetrieveProduit() {
        long produitId = 1L;
        Produit produit = new Produit();
        when(produitRepository.findById(produitId)).thenReturn(java.util.Optional.of(produit));

        Produit retrievedProduit = produitService.retrieveProduit(produitId);

        assertNotNull(retrievedProduit);
        assertEquals(produit, retrievedProduit);
    }
}
