package tn.esprit.rh.achat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.exceptions.InvalidEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Slf4j
public class ProduitDto {
    private Long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prix;
    private Date dateCreation;
    private Date dateDerniereModification;
    public static Produit toEntity(ProduitDto produitDto){
        if(produitDto==null){
            throw new InvalidEntityException("produit entrees est invalide");
        }
        else{
            return Produit.builder()
                    .idProduit(produitDto.idProduit)
                    .codeProduit(produitDto.codeProduit)
                    .libelleProduit(produitDto.libelleProduit)
                    .prix(produitDto.prix)
                    .dateCreation(produitDto.dateCreation)
                    .dateDerniereModification(produitDto.dateDerniereModification)
                    .build();
        }

    }
    public static ProduitDto toDto(Produit produit){
        if(produit==null){
            throw new InvalidEntityException("produit entrees est invalide");
        }
        return ProduitDto.builder()
                .idProduit(produit.getIdProduit())
                .codeProduit(produit.getCodeProduit())
                .libelleProduit(produit.getLibelleProduit())
                .prix(produit.getPrix())
                .dateCreation(produit.getDateCreation())
                .dateDerniereModification(produit.getDateDerniereModification())
                .build();
    }
    public static List<ProduitDto> toListOfDto(List<Produit> produitList){
        List<ProduitDto> produitDtoList=new ArrayList<>();
        produitList.forEach(produit->produitDtoList.add(ProduitDto.toDto(produit)));
        return produitDtoList;
    }
    public static List<Produit> toListOfEntity(List<ProduitDto> produitDtoList){
        List<Produit> produitList=new ArrayList<>();
        produitDtoList.forEach(produitdto->produitList.add(ProduitDto.toEntity(produitdto)));
        return produitList;
    }
}
