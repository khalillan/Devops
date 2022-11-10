package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.Dto.FournisseurDto;
import tn.esprit.rh.achat.entities.Fournisseur;

import java.util.List;

public interface IFournisseurService {


	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur f);

	Fournisseur retrieveFournisseur(long id);

	void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);


}
