package tn.esprit.rh.achat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.dto.ProduitDto;

import tn.esprit.rh.achat.services.ProduitServiceImpl;
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplMockTest {


    ProduitServiceImpl produitServiceImp=mock(ProduitServiceImpl.class);
    ProduitDto produitDto1=ProduitDto
            .builder()
            .codeProduit("00001")
            .idProduit(1L)
            .libelleProduit("produit1")
            .dateCreation(new Date())
            .dateDerniereModification(new Date())
            .build();
    ProduitDto produitDto2=ProduitDto
            .builder()
            .codeProduit("00002")
            .idProduit(2L)
            .libelleProduit("produit2")
            .dateCreation(new Date())
            .dateDerniereModification(new Date())
            .build();
    ProduitDto produitDto3=ProduitDto
            .builder()
            .codeProduit("00003")
            .idProduit(3L)
            .libelleProduit("produit3")
            .dateCreation(new Date())
            .dateDerniereModification(new Date())
            .build();
    List<ProduitDto> list =new ArrayList<ProduitDto>(){
        {
            add(produitDto2);
            add(produitDto3);
        }
    };
    @Test
    @Order(1)
    void testAddProduit(){
        when(produitServiceImp.addProduit(produitDto1)).thenReturn(produitDto1);
        Assert.assertNotNull(produitServiceImp.addProduit(produitDto1).getIdProduit());
        verify(produitServiceImp).addProduit(produitDto1);
    }
    @Test
    @Order(2)
    void testRetreiveAllProduits(){
        when(produitServiceImp.retrieveAllProduits()).thenReturn(list);
        assertNotEquals(list.size(),0);
    }
    @Test
    @Order(3)
    void testretrieveProduit(){
        when(produitServiceImp.retrieveProduit(produitDto1.getIdProduit())).thenReturn(produitDto1);
        assertEquals(produitDto1,produitServiceImp.retrieveProduit(produitDto1.getIdProduit()));
        verify(produitServiceImp).retrieveProduit(produitDto1.getIdProduit());
    }
}
