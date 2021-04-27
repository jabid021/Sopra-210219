import { Formation } from './../model/formation';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FormationService {
  private static URL = 'http://127.0.0.1:8080/projet/api/formation';
  private httpHeaders: HttpHeaders;
  constructor(private http: HttpClient) {
    this.initHeader();
  }

  private initHeader() {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${localStorage.getItem('auth')}`,
    });
  }

  public list(): Observable<Formation[]> {
    this.initHeader();
    return this.http.get<Formation[]>(FormationService.URL, {
      headers: this.httpHeaders,
    });
  }

  public get(id: number): Observable<Formation> {
    this.initHeader();
    return this.http.get<Formation>(`${FormationService.URL}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(`${FormationService.URL}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public update(formation: Formation): Observable<Formation> {
    this.initHeader();
    console.log(formation.referent.id);
    return this.http.put<Formation>(
      `${FormationService.URL}/${formation.id}`,
      formation,
      { headers: this.httpHeaders }
    );
  }

  public insert(formation: Formation): Observable<Formation> {
    this.initHeader();
    const f = {
      id: formation.id,
      nom: formation.nom,
      dateFormation: formation.dateFormation,
      referent: {
        id: formation.referent.id,
        prenom: formation.referent.prenom,
        nom: formation.referent.nom,
      },
    };
    return this.http.post<Formation>(FormationService.URL, f, {
      headers: this.httpHeaders,
    });
  }
}
