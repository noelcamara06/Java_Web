package com.example.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProduitDTO;
import com.example.demo.entities.Produit;
import com.example.demo.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin("http://localhost:4200")
public class ProduitRESTController {
	@Autowired
	ProduitService produitService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProduitDTO> getAllProduits() {
		return produitService.getAllProduits();
	}

	/* TP3 */
	/* Question 3 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ProduitDTO getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}
	
	/* Question 5 */
	@RequestMapping(method = RequestMethod.POST)
	public ProduitDTO createProduit(@RequestBody ProduitDTO produit)
	{ 
		return produitService.saveProduit(produit);
	}
	
	/* Question 7 */
	@RequestMapping(method = RequestMethod.PUT)
	public ProduitDTO updateProduit(@RequestBody ProduitDTO produit)
	{ 
		return produitService.updateProduit(produit);
	}
	
	/* Question 9 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		produitService.deleteProduitById(id);
	}
	
	/* Question 11 */
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<ProduitDTO> getProduitsByCatId(@PathVariable("idCat") Long idCat)
	{ 
		return produitService.findByCategorieIdCat(idCat);
	}
}
