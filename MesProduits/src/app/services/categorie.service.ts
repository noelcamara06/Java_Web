import { Injectable } from '@angular/core';
import { Categorie } from '../model/categorie.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
    providedIn: 'root'
})

export class CategorieService {

    apiURL: string = 'http://localhost:8080/produits/api';
    constructor(private http: HttpClient) {
    }

    listeCategories(): Observable<Categorie[]> {

        return this.http.get<Categorie[]>(this.apiURL + "/categorie");
    }

    // listeCategorie(): Observable<Categorie[]> {
    //     return this.http.get<Categorie[]>(this.apiURL);
    // }

    // getCategorie(id: number): Observable<Categorie> {
    //     const url = `${this.apiURL}/${id}`;
    //     console.log(this.http.get<Categorie>(url));
    //     return this.http.get<Categorie>(url);
    // }
}
