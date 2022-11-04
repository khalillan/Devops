package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Produit;

import java.util.Date;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	
	@Query("SELECT sum(df.prixTotalDetail) FROM DetailFacture df where df.produit=:produit and df.facture.dateCreationFacture between :startDate"
			+ " and :endDate and df.facture.archivee=true")
	public float getRevenuBrutProduit(@Param("produit") Produit produit, @Param("startDate") Date startDate,
                                      @Param("endDate") Date endDate);
}
