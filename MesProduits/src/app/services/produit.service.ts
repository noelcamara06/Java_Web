import { Injectable } from '@angular/core';
import { Produit } from '../model/produit.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
  providedIn: 'root'
})



export class ProduitService {
   //produits : Produit[]; //un tableau de Produit
    /*constructor() {
      this.produits = [
        { idProduit : 1, nomProduit : "PC Asus", prixProduit : 3000.600, dateCreation: new Date("01/14/2011")},
        { idProduit : 2, nomProduit : "Imprimante Epson", prixProduit : 450, dateCreation : new Date("12/17/2010")},
        { idProduit : 3, nomProduit :"Tablette Samsung", prixProduit : 900.123, dateCreation : new Date("02/20/2020")}
      ];
  } */
  
    apiURL: string = 'http://localhost:8080/produits/api/produit';
      constructor(private http : HttpClient) {
    }

    listeProduit(): Observable<Produit[]>{
      return this.http.get<Produit[]>(this.apiURL);
      }

    ajouterProduit( prod: Produit):Observable<Produit>{
      //console.log(prod);
      return this.http.post<Produit>(this.apiURL, prod, httpOptions);
      }

    supprimerProduit(id: number) {
      const url = `${this.apiURL}/${id}`;
      return this.http.delete(url, httpOptions);
    }

  produit!: Produit;

    /*consulterProduit(id: number): Observable<Produit> {
      const url = `${this.apiURL}/${id}`;
      return this.http.get<Produit>(url);
    }*/
    /*consulterProduit(id: number): Produit {
    this.produit = this.produit.find(p => p.idProduit == id)!;
    return this.produit;
  }*/

   /* updateProduit(prod: Produit): Observable<Produit> {
      return this.http.put<Produit>(this.apiURL, prod, httpOptions);
    }*/

  trierProduits() {
    this.produit = this.produit.sort((n1, n2) => {
      if (n1.idProduit! > n2.idProduit!) {
        return 1;
      }
      if (n1.idProduit! < n2.idProduit!) {
        return -1;
      }
      return 0;
    });
  }
  /*updateProduit(p: Produit) {
    if (p.idProduit !== undefined) { // Vérifier si idProduit est défini
      // Supprimer le produit en utilisant son identifiant
      this.supprimerProduit(p.idProduit);

      // Ajouter le nouveau produit
      this.ajouterProduit(p);

      // Trier les produits
      this.trierProduits();
    } else {
      console.error("L'identifiant du produit est indéfini.");
    }
  }*/
  consulterProduit(id: number): Observable<Produit> {
    const url = `${this.apiURL}/${id}`;
    return this.http.get<Produit>(url);
  }
  updateProduit(prod: Produit): Observable<Produit> {
    return this.http.put<Produit>(this.apiURL, prod, httpOptions);
  }

}

