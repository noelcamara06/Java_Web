package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	

	/*Question 10 */
	@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > %?2")
	List<Produit> findByNomPrix (String nom, Double prix);
	/*
	 * On peut nommer les paramètres avec l’annotation @Param :
	 * 
	@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);*/
	

	/*Question 12 */
	@Query("select p from Produit p where p.categorie = ?1")
	List<Produit> findByCategorie (Categorie categorie);

	/*Question 14 */
	List<Produit> findByCategorieIdCat(Long id);

	/*Question 16 */
	List<Produit> findByOrderByNomProduitAsc();

	/*Question 18 */
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();
}
