import { Formateur } from './../model/formateur';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { format } from 'node:path';

@Injectable({
  providedIn: 'root',
})
export class FormateurService {
  private static URL = 'http://127.0.0.1:8080/projet/api/formateur';

  constructor(private http: HttpClient) {}

  public getFormateurs(): Observable<Formateur[]> {
    return this.http.get<Formateur[]>(FormateurService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(FormateurService.URL + '/' + id);
  }

  public getFormateur(id: number): Observable<Formateur> {
    return this.http.get<Formateur>(FormateurService.URL + '/' + id);
  }

  public update(formateur: Formateur): Observable<Formateur> {
    return this.http.put<Formateur>(
      FormateurService.URL + '/' + formateur.id,
      formateur
    );
  }

  public insert(formateur: Formateur): Observable<Formateur> {
    const formateurFormate = {
      prenom: formateur.prenom,
      nom: formateur.nom,
    };
    return this.http.post<Formateur>(FormateurService.URL, formateurFormate);
  }
}
