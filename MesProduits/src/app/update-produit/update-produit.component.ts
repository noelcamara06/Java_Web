/* import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitService } from '../services/produit.service';
import { Produit } from '../model/produit.model';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html', 
  styles: []
})

export class UpdateProduitComponent implements OnInit {
  currentProduit = new Produit();
  constructor(private activatedRoute: ActivatedRoute, private router: Router, private produitService: ProduitService) { }

  ngOnInit() {
    // console.log(this.route.snapshot.params.id);
    this.currentProduit = this.produitService.consulterProduit(this.activatedRoute.snapshot.params['id']);
    console.log(this.currentProduit);
  }

  updateProduit() { 
    //console.log(this.currentProduit);
    this.produitService.updateProduit(this.currentProduit);
    this.router.navigate(['produits']);
  }
}*/

import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit.model';
import { Categorie } from '../model/categorie.model';
import { ProduitService } from '../services/produit.service';
import { CategorieService } from '../services/categorie.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styleUrl: './update-produit.component.css'
  //styles: []
})
export class UpdateProduitComponent implements OnInit {
  currentProduit = new Produit();
  categorie = new Categorie();
  categories!: Categorie[]
  updatedCatId!: number;

  constructor(private produitService: ProduitService, private categorieService: CategorieService, private router: Router, private activatedRoute: ActivatedRoute /*injection */) { }
  ngOnInit() {
    // this.produitService.consulterProduit(this.activatedRoute.snapshot.params['id']).
    //   subscribe(prod => { this.currentProduit = prod; });

    this.categorieService.listeCategories().subscribe(cats => {
      this.categories = cats;
        console.log(cats);

      });
    this.produitService.consulterProduit(this.activatedRoute.snapshot.params['id']).subscribe(prod => {
        this.currentProduit = prod;
        if (this.currentProduit.categorie) {
          this.updatedCatId = this.currentProduit.categorie.idCat;
        }  
      });
      
  }

  updateProduit() {
    // this.produitService.updateProduit(this.currentProduit).subscribe(prod => {
    //   this.router.navigate(['produits']);
    // }
    // );
    this.currentProduit.categorie = this.categories.

      find(cat => cat.idCat == this.updatedCatId)!;

    this.produitService.updateProduit(this.currentProduit).subscribe(prod => {
      this.router.navigate(['produits']);
    }
    );
  }
}
