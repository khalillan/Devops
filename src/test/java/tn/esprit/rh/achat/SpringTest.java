package tn.esprit.rh.achat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class SpringTest {

    @Mock
    FournisseurRepository fournisseurRepository;

    @InjectMocks
    FournisseurServiceImpl fournisseurService;

    Fournisseur fournisseur = new Fournisseur(10,"ff","ff", CategorieFournisseur.CONVENTIONNE,null,null,null);

    List<Fournisseur> listFournisseur = new ArrayList<Fournisseur>(){
        {
            add ( new Fournisseur (1,"ff","ff", null,null,null,null));
            add ( new Fournisseur (2,"ff","ff", null,null,null,null));
        }
    };

   // @Test
   // public void retriveFournissur(){
    //    Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
    //    Fournisseur f = fournisseurService.retrieveFournisseur(10);
    //    assertNotNull(f);
    //    log.info("get ==> " + f.toString());
   // }

}
