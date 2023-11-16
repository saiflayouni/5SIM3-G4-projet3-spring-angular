package com.esprit.examen.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

@SpringBootTest
public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @InjectMocks // auto injects fournisseurRepository into FournisseurServiceImpl
    private FournisseurServiceImpl fournisseurService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(fournisseurRepository, times(1)).findAll();
    }

    @Test
    public void testAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(fournisseur);

        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        assertNotNull(result);
        verify(fournisseurRepository, times(1)).save(any(Fournisseur.class));
    }

    @Test
    public void testDeleteFournisseur() {
        doNothing().when(fournisseurRepository).deleteById(anyLong());

        fournisseurService.deleteFournisseur(1L);

        verify(fournisseurRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void testRetrieveFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.findById(anyLong())).thenReturn(Optional.of(fournisseur));

        Fournisseur result = fournisseurService.retrieveFournisseur(1L);

        assertNotNull(result);
        verify(fournisseurRepository, times(1)).findById(anyLong());
    }



}
