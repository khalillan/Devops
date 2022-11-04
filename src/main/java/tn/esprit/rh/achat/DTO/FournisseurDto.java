package tn.esprit.rh.achat.DTO;

import lombok.Data;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.SecteurActivite;

import java.util.List;
import java.util.Set;

@Data
public class FournisseurDto {

    private long idFournisseurDto;
    private String codeDto;
    private String libelleDto;
    private List<Facture> factureDto;
    private Set<SecteurActivite> secteurActivites;
    private DetailFournisseur detailFournisseur;
}

