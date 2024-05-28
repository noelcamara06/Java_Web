package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;



public interface ProduitService {
	
	ProduitDTO saveProduit(ProduitDTO p);
	ProduitDTO updateProduit(ProduitDTO p);
	void deleteProduit(Produit  p);
	void deleteProduitById(Long id);
	ProduitDTO getProduit(Long id);
	List<ProduitDTO> getAllProduits();
	List<ProduitDTO> findByNomProduit(String nom);
	List<ProduitDTO> findByNomProduitContains(String nom);
	List<ProduitDTO> findByNomPrix (String nom, Double prix);
	List<ProduitDTO> findByCategorie (Categorie categorie);
	List<ProduitDTO> findByCategorieIdCat(Long id);
	List<ProduitDTO> findByOrderByNomProduitAsc();
	List<ProduitDTO> trierProduitsNomsPrix();
	
	ProduitDTO convertEntityToDto (Produit produit);
	
	Produit convertDtoToEntity(ProduitDTO produit);
	
}
