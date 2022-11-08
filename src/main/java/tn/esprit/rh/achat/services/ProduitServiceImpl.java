package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.dto.ProduitDto;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	private static final String MEHTODETIME="Method execution time: ";
	private static final String UNITETIME=" milliseconds. ";

	@Override
	public List<ProduitDto> retrieveAllProduits() {
		List<Produit> produits = produitRepository.findAll();
		for (Produit produit : produits) {
			log.info(" Produit : " + produit);
		}
		return ProduitDto.toListOfDto(produits);
	}

	@Transactional
	public ProduitDto addProduit(ProduitDto p) {
		long start = System.currentTimeMillis();
		log.info("In method addProduit of ProduitService");
		ProduitDto result = ProduitDto.toDto(produitRepository.save(ProduitDto.toEntity(p)));
		log.info("out of method addProduit ProduitService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info(MEHTODETIME + elapsedTime + UNITETIME);
		return result;

	}

	

	@Override
	public void deleteProduit(Long produitId) {
		long start = System.currentTimeMillis();
		log.info("In method deleteProduit of ProduitService");
		produitRepository.deleteById(produitId);
		log.info("out of method deleteProduit ProduitService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info(MEHTODETIME + elapsedTime + UNITETIME);
	}

	@Override
	public ProduitDto updateProduit(ProduitDto p) {
		long start = System.currentTimeMillis();
		log.info("In method updateProduit of ProduitService");
		ProduitDto result = ProduitDto.toDto(produitRepository.save(ProduitDto.toEntity(p)));
		log.info("out of method updateProduit ProduitService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info(MEHTODETIME + elapsedTime + UNITETIME);
		return result;
	}

	@Override
	public ProduitDto retrieveProduit(Long produitId) {
		long start = System.currentTimeMillis();
		log.info("In method retrieveProduit of ProduitService");
		ProduitDto result =  produitRepository
				.findById(produitId)
				.map(ProduitDto::toDto)
				.orElse(null);
		log.info("out of method retrieveProduit ProduitService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info(MEHTODETIME + elapsedTime + UNITETIME);
		return result;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		if(produit!=null && stock!=null){
			produit.setStock(stock);
			produitRepository.save(produit);

		}

	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		Produit produit=produitRepository.findById(idProduit).orElse(null);
		return produitRepository.getRevenuBrutProduit(produit,startDate,endDate);

	}


}