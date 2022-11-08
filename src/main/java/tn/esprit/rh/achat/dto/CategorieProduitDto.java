package tn.esprit.rh.achat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.exceptions.InvalidEntityException;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Slf4j
public class CategorieProduitDto {
    private Long idCategorieProduit;
    private String codeCategorie;
    private String libelleCategorie;
    public static CategorieProduit toEntity(CategorieProduitDto categorieProduitDto){
        if(categorieProduitDto==null){
            throw new InvalidEntityException("CategorieProduit entrees est invalide");
        }
        else{
            return CategorieProduit.builder()
                    .idCategorieProduit(categorieProduitDto.idCategorieProduit)
                    .codeCategorie(categorieProduitDto.codeCategorie)
                    .libelleCategorie(categorieProduitDto.libelleCategorie)
                    .build();
        }

    }
    public static CategorieProduitDto toDto(CategorieProduit categorieProduit){
        if(categorieProduit==null){
            throw new InvalidEntityException("CategorieProduit entrees est invalide");
        }
        return CategorieProduitDto.builder()
                .idCategorieProduit(categorieProduit.getIdCategorieProduit())
                .codeCategorie(categorieProduit.getCodeCategorie())
                .libelleCategorie(categorieProduit.getLibelleCategorie())

                .build();
    }
    public static List<CategorieProduitDto> toListOfDto(List<CategorieProduit> categorieProduitList){
        List<CategorieProduitDto> categorieProduitDtoList=new ArrayList<>();
        categorieProduitList.forEach(categorieProduit->categorieProduitDtoList.add(CategorieProduitDto.toDto(categorieProduit)));
        return categorieProduitDtoList;
    }
    public static List<CategorieProduit> toListOfEntity(List<CategorieProduitDto> categorieProduitDtoList){
        List<CategorieProduit> categorieProduitList=new ArrayList<>();
        categorieProduitDtoList.forEach(categorieProduitdto->categorieProduitList.add(CategorieProduitDto.toEntity(categorieProduitdto)));
        return categorieProduitList;
    }
}
