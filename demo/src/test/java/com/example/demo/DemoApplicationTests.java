package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private CategorieRepository categorieRepository;
/*
	@Test
	void testCreateProduit() {
		
		Categorie cat =  new  Categorie();
		cat.setDescriptionCat("test");
		cat.setNomCat("cat1");
		categorieRepository.save(cat);
		
		Categorie cat2 =  new  Categorie();
		cat.setDescriptionCat("test1");
		cat.setNomCat("cat11");
		categorieRepository.save(cat2);
		
		Categorie cat3  =  new  Categorie();
		cat.setDescriptionCat("test2");
		cat.setNomCat("cat12");
		categorieRepository.save(cat3);
		
		Produit prod = new Produit("PC Dell",2200.500,new Date(), cat);
		Produit prod2 = new Produit("iphone X",2222.500,new Date(), cat2);
		Produit prod3 = new Produit("iphone XS",2222.500,new Date(), cat3 );
		produitRepository.save(prod);
		produitRepository.save(prod2);
		produitRepository.save(prod3);
	}
*/

	/*Question 9 */
	@Test
	public void testFindByNomProduit()
	{
	List<Produit> prods = produitRepository.findByNomProduit("iphone X");

		for (Produit p : prods)
		{
			System.out.println(p);
		}

	}

	@Test
	public void testFindByNomProduitContains ()
	{
	List<Produit> prods=produitRepository.findByNomProduitContains("iphone");

		for (Produit p : prods)
		{
			System.out.println(p);
		} 
	}
	

	/*Question 11 */
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
	

	/*Question 13 */
	@Test
	
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(5L);
	List<Produit> prods = produitRepository.findByCategorie(cat);
	for (Produit p : prods)
	{
	System.out.println(p);
	}

	}
	

	/*Question 15 */
	@Test
	public void findByCategorieIdCat()
	{
		List<Produit> prods = ((ProduitRepository) produitRepository).findByCategorieIdCat(6L);
			for (Produit p : prods)
			{
			System.out.println(p);
			}
	}

	/*Question 17 */
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
			for (Produit p : prods)
			{
			System.out.println(p);
			}
	}
	
	/*Question 19 */
	@Test
	 void testTrierProduitsNomsPrix()
	{
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
			for (Produit p : prods)
			{
			System.out.println(p);
			}
	}
}
