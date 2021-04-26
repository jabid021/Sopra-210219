import { Formation } from './../model/formation';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FormationService {
  private static URL = 'http://127.0.0.1:8080/projet/api/formation';

  constructor(private http: HttpClient) {}

  public list(): Observable<Formation[]> {
    return this.http.get<Formation[]>(FormationService.URL);
  }

  public get(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${FormationService.URL}/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(`${FormationService.URL}/${id}`);
  }

  public update(formation: Formation): Observable<Formation> {
    console.log(formation.referent.id);
    return this.http.put<Formation>(
      `${FormationService.URL}/${formation.id}`,
      formation
    );
  }

  public insert(formation: Formation): Observable<Formation> {
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
    return this.http.post<Formation>(FormationService.URL, f);
  }
}
