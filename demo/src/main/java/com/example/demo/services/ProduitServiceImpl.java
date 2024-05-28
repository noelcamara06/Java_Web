package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService
{
	@Autowired
	ProduitRepository produitRepository;
	
	
	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		return convertEntityToDto( produitRepository.save(convertDtoToEntity(p)));
	}
	
	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return convertEntityToDto( produitRepository.save(convertDtoToEntity(p)));
	}
	
	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
	}
	
	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
	}
	
	@Override
	public ProduitDTO getProduit(Long id) {
		return convertEntityToDto(produitRepository.getById(id));

				//OU BIEN
				/*List<Produit> prods = produitRepository.findAll();
				List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
				for (Produit p : prods)
				listprodDto.add(convertEntityToDto(p));
				return listprodDto;*/
	}
	
	@Override
	public List<ProduitDTO> getAllProduits() {
		return produitRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProduitDTO> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProduitDTO> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProduitDTO> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProduitDTO> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProduitDTO> findByCategorieIdCat(Long id) {
		return produitRepository.findByCategorieIdCat(id).stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProduitDTO> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ProduitDTO> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	
	@Autowired
	ModelMapper modelMapper;
	@Override
	public ProduitDTO convertEntityToDto(Produit produit) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
		return produitDTO;
	}

	@Override
	public Produit convertDtoToEntity(ProduitDTO produitDto) {
		Produit produit = new Produit();
		produit = modelMapper.map(produitDto, Produit.class);
		return produit;
	}

	
}
