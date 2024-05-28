import { Categorie } from './categorie.model'; 

export class Produit {
    sort(arg0: (n1: any, n2: any) => 1 | -1 | 0): Produit {
      throw new Error('Method not implemented.');
    }
    find(arg0: (p: any) => boolean): Produit {
      throw new Error('Method not implemented.');
    }
    idProduit? : number;
    nomProduit? : string;
    prixProduit? : number;
    dateCreation?: Date;
    categorie?: Categorie;
    }