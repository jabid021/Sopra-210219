import { Formateur } from './../model/formateur';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FormateurService {
  private static URL = 'http://127.0.0.1:8080/projet/api/formateur';
  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.initHeader();
  }

  private initHeader() {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${btoa('toto:toto')}`,
    });
  }

  public getFormateurs(): Observable<Formateur[]> {
    this.initHeader();
    return this.http.get<Formateur[]>(FormateurService.URL, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(FormateurService.URL + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public getFormateur(id: number): Observable<Formateur> {
    return this.http.get<Formateur>(FormateurService.URL + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public update(formateur: Formateur): Observable<Formateur> {
    return this.http.put<Formateur>(
      FormateurService.URL + '/' + formateur.id,
      formateur,
      {
        headers: this.httpHeaders,
      }
    );
  }

  public insert(formateur: Formateur): Observable<Formateur> {
    const formateurFormate = {
      prenom: formateur.prenom,
      nom: formateur.nom,
    };
    return this.http.post<Formateur>(FormateurService.URL, formateurFormate, {
      headers: this.httpHeaders,
    });
  }
}
