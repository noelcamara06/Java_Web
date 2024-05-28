package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "Produits")

public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idProduit;

	@Column(nullable = false, length = 60)
	
	private String nomProduit;

	@Column(nullable = false, length = 60)

	private Double prixProduit;
	
	@Column(nullable = false)
	
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public  Produit() {}


	public Produit( String nomProduit, Double prixProduit, Date dateCreation, Categorie categorie) {
		super();
	
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.dateCreation = dateCreation;
		this.categorie = categorie;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	

	
	@Override
	public String toString() {
	return "Produit [idProduit=" + idProduit + ", nomProduit=" +

	nomProduit + ", prixProduit=" + prixProduit

	+ ", dateCreation=" + dateCreation + "]";

	}
}
