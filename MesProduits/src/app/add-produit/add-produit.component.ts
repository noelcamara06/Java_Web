import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';
import { Router } from '@angular/router';
import { Categorie } from '../model/categorie.model';
import { CategorieService } from '../services/categorie.service'; 

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html',
  styleUrl: './add-produit.component.css'
})
export class AddProduitComponent implements OnInit {

  newProduit = new Produit();
  newIdCat!: number;
  //newCategorie = new Categorie();
  newCategorie = new Categorie();
  categories!: Categorie[]; //un tableau de Produit


  constructor(private produitService: ProduitService, private categorieService: CategorieService, private router : Router) 
    
  { }


  // chargerCategorie() {
  //   this.categorieService.listeCategorie().subscribe(categories => {
  //     console.log(categories);
  //     this.categories = categories;
  //   });
  // }
  
/*  addProduit(){*
  // this.produitService.ajouterProduit(this.newProduit).subscribe(prod => {
  // console.log(prod);
  // this.router.navigate(['produits']);
  // });
  // }

    console.log(this.newIdCat);
    this.newCategorie = this.categorieService.listeCategorie(this.newIdCat);
    this.newProduit.categorie = this.newCategorie;
    this.produitService.ajouterProduit(this.newProduit);
    this.router.navigate(['produits']);
  }*/

  addProduit() {
    this.newProduit.categorie = this.categories.find(cat => cat.idCat == this.newIdCat)!;
    this.produitService.ajouterProduit(this.newProduit)

      .subscribe(prod => {
        console.log(prod);
        this.router.navigate(['produits']);
      });
  }

  ngOnInit(): void {

    this.categorieService.listeCategories().
    subscribe(cats => {
      this.categories = cats;
      console.log(cats);

    });

  }

}

