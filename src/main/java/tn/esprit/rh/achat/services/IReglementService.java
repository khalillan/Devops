package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.Dto.ReglementDto;
import tn.esprit.rh.achat.entities.Reglement;

import java.util.Date;
import java.util.List;

public interface IReglementService {

	List<ReglementDto> retrieveAllReglements();
	ReglementDto addReglement(ReglementDto r);
	ReglementDto retrieveReglement(Long id);
	ReglementDto updateReglement(ReglementDto r );
	void deleteReglement(ReglementDto r);
	List<ReglementDto> retrieveReglementByFacture(Long idFacture);
	float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

}
