package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.dto.ProduitDto;

import java.util.Date;
import java.util.List;

public interface IProduitService {

	List<ProduitDto> retrieveAllProduits();

	ProduitDto addProduit(ProduitDto p);

	void deleteProduit(Long id);

	ProduitDto updateProduit(ProduitDto p);

	ProduitDto retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);
	float getRevenuBrutProduit(Long idProduit, Date startDate,Date endDate);

}
