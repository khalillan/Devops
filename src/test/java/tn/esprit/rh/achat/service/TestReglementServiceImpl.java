package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestReglementServiceImpl {
    @Mock
     ReglementRepository reglementRepository;
    @InjectMocks

     ReglementServiceImpl reglementService;
    @Test
    void testRetrieveAllReglements() {
        Reglement reglement1 = new Reglement();
        Reglement reglement2 = new Reglement();
        doReturn(reglement1).when(reglementRepository.save(Mockito.any(Reglement.class)));
        doReturn(reglement2).when(reglementRepository.save(Mockito.any(Reglement.class)));
        reglementRepository.save(reglement1);
        reglementRepository.save(reglement2);
        Assertions.assertEquals(2, reglementService.retrieveAllReglements().size());
    }
}
