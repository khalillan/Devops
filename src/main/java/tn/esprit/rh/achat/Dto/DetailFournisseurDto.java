package tn.esprit.rh.achat.Dto;

import lombok.Builder;
import lombok.Data;
import tn.esprit.rh.achat.Exception.FournisseurException;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.SecteurActivite;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Data
public class DetailFournisseurDto {
    private Long idDetailFournisseur;
    private String email;
    private Date dateDebutCollaboration;
    private String adresse;
    private String matricule;
    public static DetailFournisseurDto fromEntity(DetailFournisseur detailFournisseur){
        if(detailFournisseur == null) throw  new FournisseurException("Empty");
        return DetailFournisseurDto.builder()
                .idDetailFournisseur(detailFournisseur.getIdDetailFournisseur())
                .email(detailFournisseur.getEmail())
                .dateDebutCollaboration(detailFournisseur.getDateDebutCollaboration())
                .adresse(detailFournisseur.getAdresse())
                .matricule(detailFournisseur.getMatricule())
                .build();
    }
    public static DetailFournisseur toEntity(DetailFournisseurDto detailFournisseurDto){
        if(detailFournisseurDto == null) throw new FournisseurException(" is empty");
        return DetailFournisseur.builder()
                .idDetailFournisseur(detailFournisseurDto.getIdDetailFournisseur())
                .email(detailFournisseurDto.getEmail())
                .dateDebutCollaboration(detailFournisseurDto.getDateDebutCollaboration())
                .adresse(detailFournisseurDto.getAdresse())
                .matricule(detailFournisseurDto.getMatricule())
                .build();
    }
}
