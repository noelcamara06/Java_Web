import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrl: './produits.component.css'
})
export class ProduitsComponent implements OnInit {

  produits?: Produit[] ; //un tableau de Produit

  ngOnInit(): void {

    /*this.produitService.listeProduit().subscribe(prods => {
    console.log(prods);
    this.produits = prods;
    });*/
    this.chargerProduits();
    }

  constructor(private produitService: ProduitService, public authService: AuthService) { }


  chargerProduits() {
    this.produitService.listeProduit().subscribe(prods => {
      console.log(prods);
      this.produits = prods;
    });
  }

  supprimerProduit(p: Produit) {
    let conf = confirm("Etes-vous sûr ?");
    if (conf && p.idProduit !== undefined) {
      this.produitService.supprimerProduit(p.idProduit).subscribe(() => {
        console.log("produit supprimé");
        this.chargerProduits();
      });
    }
  }
}
