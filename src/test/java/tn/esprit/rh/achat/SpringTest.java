package tn.esprit.rh.achat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.dto.ProduitDto;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.Date;
import static org.junit.Assert.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
class SpringTest {
@Autowired
    IProduitService iProduitService;

@Test
 void testAddProduit(){
    ProduitDto produitDto=ProduitDto.builder()
            .codeProduit("test")
            .libelleProduit("test")
            .dateCreation(new Date())
            .prix(240F)
            .dateDerniereModification(new Date())
            .build();
    ProduitDto saveProduit=iProduitService.addProduit(produitDto);
    assertNotNull(saveProduit.getIdProduit());
    iProduitService.deleteProduit(saveProduit.getIdProduit());

}
}
