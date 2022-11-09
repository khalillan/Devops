package tn.esprit.rh.achat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.dto.CategorieProduitDto;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CategorieProduitServiceImplTest {
    @Autowired
    ICategorieProduitService categorieProduitService;
    @Test
    void testAddCategorieProduit(){
        CategorieProduitDto categorieProduitDto=CategorieProduitDto
                .builder()
                .codeCategorie("0001")
                .libelleCategorie("cat1")
                .build();
        log.info("add new categorie produit");
        CategorieProduitDto savedCategorie=categorieProduitService.addCategorieProduit(categorieProduitDto);
        log.info("assert that categorie produit id is not null");
        assertNotNull(savedCategorie.getIdCategorieProduit());
        log.info("assert that categorie produit code is the same");
        assertEquals(Optional.ofNullable(savedCategorie.getCodeCategorie()),Optional.of("0001"));
        log.info("delete categorie produit test");
        categorieProduitService.deleteCategorieProduit(savedCategorie.getIdCategorieProduit());
    }
    @Test
    void testDeleteCategorieProduit(){
        CategorieProduitDto categorieProduitDto=CategorieProduitDto
                .builder()
                .codeCategorie("0001")
                .libelleCategorie("cat1")
                .build();
        log.info("add new categorie produit");
        CategorieProduitDto savedCategorie=categorieProduitService.addCategorieProduit(categorieProduitDto);
        log.info("delete categorie produit");
        categorieProduitService.deleteCategorieProduit(savedCategorie.getIdCategorieProduit());
        log.info("assert that categorie produit id null");
        assertNull(categorieProduitService.retrieveCategorieProduit(savedCategorie.getIdCategorieProduit()));
    }
    @Test
    void testRetrieveAllCategorieProduit(){
        CategorieProduitDto categorieProduitDto=CategorieProduitDto
                .builder()
                .codeCategorie("0001")
                .libelleCategorie("cat1")
                .build();
        log.info("add new categorie produit");
        CategorieProduitDto savedCategorie=categorieProduitService.addCategorieProduit(categorieProduitDto);
        log.info("retrieve all produits");
        List<CategorieProduitDto> categorieProduitDtoList=categorieProduitService.retrieveAllCategorieProduits();
        log.info("assert that categorie produit list is not empty");
        assertNotEquals(categorieProduitDtoList.size(),0);
        log.info("delete categorie produit test");
        categorieProduitService.deleteCategorieProduit(savedCategorie.getIdCategorieProduit());

    }

}
