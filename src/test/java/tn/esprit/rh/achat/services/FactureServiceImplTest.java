package tn.esprit.rh.achat;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Operateur;

import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
    @Autowired
    IFactureService factureService;
    @Autowired

    IOperateurService operateurService;
    @Autowired
    IFournisseurService fournisseurService;



    @Test
    public void testAddFacture () throws  ParseException  {
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFactrure= factureService.addFacture(f);

        assertNotNull(savedFactrure);
        Assertions.assertEquals(200f, savedFactrure.getMontantFacture());
        Assertions.assertEquals(20f,savedFactrure.getMontantRemise());
        assertEquals(new Date(10 / 10 / 2022),savedFactrure.getDateCreationFacture());
        factureService.cancelFacture(savedFactrure.getIdFacture());
        log.info("facture ajoutée ===>" + savedFactrure.toString());

    }

    @Test
    public void testCancelFacture() throws  ParseException  {
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFacture= factureService.addFacture(f);
        factureService.cancelFacture(savedFacture.getIdFacture());
        assertEquals(true,savedFacture.getArchivee());

    }
    @Test
    public void testRetrieveAllFactures() throws ParseException {
        List<Facture> factures =  factureService.retrieveAllFactures();
        int expected =factures.size();
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFactrure= factureService.addFacture(f);
        assertEquals(expected + 1,factureService.retrieveAllFactures().size());
        factureService.cancelFacture(savedFactrure.getIdFacture());
    }
    @Test
    public void testRetrieveFacturesById() throws ParseException {

        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFactrure= factureService.addFacture(f);
        Assertions.assertEquals(200f, savedFactrure.getMontantFacture());
        Assertions.assertEquals(20f,savedFactrure.getMontantRemise());
        assertEquals(new Date(10 / 10 / 2022),savedFactrure.getDateCreationFacture());
        log.info("get ===>" + factureService.toString());




    }
    @Test
    public void testUpdateFournisseur() throws ParseException{
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture operateurUpdated = factureService. updatefacture(f);
        Assertions.assertEquals(f.getMontantFacture(),operateurUpdated.getMontantFacture());
    }

/*	 @Test
	public void testgetFacturesByFournisseur() throws ParseException  {
		Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
		Facture savedFactrure= factureService.addFacture(f);
		List<Facture> f1  = new ArrayList<>();
		f1.add(savedFactrure);
		 Fournisseur fournisseur = new Fournisseur(1L,"112","aaa", f1);
		Fournisseur savedFournisseur= fournisseurService.addFournisseur(fournisseur);
		List<Facture> factures = factureService.getFacturesByFournisseur(1L);
		List<Facture>l1= new ArrayList<>( factures) ;
		 assertNotNull(l1);
		 for (Facture facture : factures) {
		log.info(" facture: " + facture.getMontantFacture()+ " né le "+facture.getMontantRemise());
		}
	}
	/*
	@Test
	public void testassignOperateurToFacture() throws ParseException{
		Facture f = new Facture(1L,20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
		Operateur o = new Operateur(1L,"chaima","yahyaoui","123");
		Facture savedFactrure= factureService.addFacture(f);
		Operateur operateurSaved =  operateurService.addOperateur(o);
		factureService.assignOperateurToFacture(1L,1L);
		List <Facture> factures = (List<Facture>) operateurSaved.getFactures();
		assertNotNull(factures);
	}
	/*
	 @Test
		public void  pourcentageRecouvrement() throws ParseException{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = dateFormat.parse("30/09/2000");
			Date endDate = dateFormat.parse("30/09/2000");
			factureService.pourcentageRecouvrement(startDate, endDate);
		}
*/
}