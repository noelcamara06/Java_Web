package com.example.demo.dto;
import java.util.List;

import com.example.demo.entities.Produit;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieDTO {

	private Long idCat;
	private String nomCat;
	private String descriptionCat;
	
	
	//private List<Produit> produits;
}
