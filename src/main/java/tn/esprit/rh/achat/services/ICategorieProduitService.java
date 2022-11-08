package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.dto.CategorieProduitDto;

import java.util.List;


public interface ICategorieProduitService {

	List<CategorieProduitDto> retrieveAllCategorieProduits();

	CategorieProduitDto addCategorieProduit(CategorieProduitDto cp);

	void deleteCategorieProduit(Long id);

	CategorieProduitDto updateCategorieProduit(CategorieProduitDto cp);

	CategorieProduitDto retrieveCategorieProduit(Long id);

}
