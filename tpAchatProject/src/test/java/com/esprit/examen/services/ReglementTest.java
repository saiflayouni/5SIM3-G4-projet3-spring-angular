import com.esprit.examen.services.ReglementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.ReglementRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.esprit.examen.TpAchatProjectApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TpAchatProjectApplication.class)
@ExtendWith(MockitoExtension.class)
public class ReglementTest {
    @Autowired
    private ReglementServiceImpl reglementService;

    @MockBean
    private FactureRepository factureRepository;

    @MockBean
    private ReglementRepository reglementRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllReglements() {
        List<Reglement> reglements = new ArrayList<>();
        when(reglementRepository.findAll()).thenReturn(reglements);

        List<Reglement> result = reglementService.retrieveAllReglements();

        assertEquals(0, result.size());
    }

    @Test
    public void testAddReglement() {
        Reglement reglement = new Reglement();
        when(reglementRepository.save(reglement)).thenReturn(reglement);

        Reglement result = reglementService.addReglement(reglement);

        assertNotNull(result);
    }

    @Test
    public void testRetrieveReglement() {
        Long reglementId = 1L;
        Reglement reglement = new Reglement();
        when(reglementRepository.findById(reglementId)).thenReturn(Optional.of(reglement));

        Reglement result = reglementService.retrieveReglement(reglementId);

        assertNotNull(result);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        Long factureId = 1L;
        List<Reglement> reglements = new ArrayList<>();
        when(reglementRepository.retrieveReglementByFacture(factureId)).thenReturn(reglements);

        List<Reglement> result = reglementService.retrieveReglementByFacture(factureId);

        assertEquals(0, result.size());
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        Date startDate = new Date();
        Date endDate = new Date();
        float chiffreAffaire = 1000.0f;
        when(reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(chiffreAffaire);

        float result = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        assertEquals(chiffreAffaire, result, 0.001);
    }
}
