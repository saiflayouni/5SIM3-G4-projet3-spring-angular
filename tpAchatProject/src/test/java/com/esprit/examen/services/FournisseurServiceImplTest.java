package com.esprit.examen.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FournisseurServiceImplTest {
    @Mock
    private FournisseurRepository fournisseurRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void shouldRetrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(fournisseurRepository, times(1)).findAll();
    }

    @Test
    public void shouldAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(fournisseur);

        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        assertNotNull(result);
        verify(fournisseurRepository, times(1)).save(any(Fournisseur.class));
    }

    @Test
    public void shouldDeleteFournisseur() {
        doNothing().when(fournisseurRepository).deleteById(anyLong());

        fournisseurService.deleteFournisseur(1L);

        verify(fournisseurRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void shouldRetrieveFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        when(fournisseurRepository.findById(anyLong())).thenReturn(Optional.of(fournisseur));

        Fournisseur result = fournisseurService.retrieveFournisseur(1L);

        assertNotNull(result);
        verify(fournisseurRepository, times(1)).findById(anyLong());
    }

}