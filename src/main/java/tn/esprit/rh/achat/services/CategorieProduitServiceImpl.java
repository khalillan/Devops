package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.dto.CategorieProduitDto;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.List;

@Service
@Slf4j
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	private static final String MEHTODETIME="Method execution time: ";
	private static final String UNITETIME=" milliseconds. ";
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduitDto> retrieveAllCategorieProduits() {

		List<CategorieProduit> categorieProduits = categorieProduitRepository.findAll();
		for (CategorieProduit categorieProduit : categorieProduits) {
			log.info(" Categorie Produit : " + categorieProduit);
		}
		return CategorieProduitDto.toListOfDto(categorieProduits);
	}

	@Override
	public CategorieProduitDto addCategorieProduit(CategorieProduitDto cp) {
		long start = System.currentTimeMillis();
		log.info("In method addCategorieProduit of CategorieProduitService");
		CategorieProduitDto result = CategorieProduitDto.toDto(categorieProduitRepository.save(CategorieProduitDto.toEntity(cp)));
		log.info("out of method addCategorieProduit CategorieProduitService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info(MEHTODETIME + elapsedTime + UNITETIME);
		return result;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	@Override
	public CategorieProduitDto updateCategorieProduit(CategorieProduitDto cp) {
		long start = System.currentTimeMillis();
		log.info("In method updateCategorieProduit of CategorieProduitService");
		CategorieProduitDto result = CategorieProduitDto.toDto(categorieProduitRepository.save(CategorieProduitDto.toEntity(cp)));
		log.info("out of method updateCategorieProduit CategorieProduitService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info(MEHTODETIME + elapsedTime + UNITETIME);
		return result;
	}

	@Override
	public CategorieProduitDto retrieveCategorieProduit(Long id) {
		long start = System.currentTimeMillis();
		log.info("In method retrieveCategorieProduit of CategorieProduitService");
		CategorieProduitDto result =  categorieProduitRepository
				.findById(id)
				.map(CategorieProduitDto::toDto)
				.orElse(null);
		log.info("out of method retrieveCategorieProduit CategorieProduitService");
		long elapsedTime = System.currentTimeMillis() - start;
		log.info(MEHTODETIME + elapsedTime + UNITETIME);
		return result;

	}

}
