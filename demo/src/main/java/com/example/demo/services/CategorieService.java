package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.CategorieDTO;
import com.example.demo.entities.Categorie;

public interface CategorieService {

	Categorie saveCategorie(Categorie p);
	Categorie updateCategorie(Categorie p);
	void deleteCategorie(Categorie  p);
	void deleteCategorieById(Long id);
	CategorieDTO getCategorie(Long id);
	List<CategorieDTO> getAllCategories();

	
	CategorieDTO convertEntityToDto (Categorie categorie);
	
	Categorie convertDtoToEntity(CategorieDTO categorie);
}
