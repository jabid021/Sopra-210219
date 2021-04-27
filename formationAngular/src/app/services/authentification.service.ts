import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  constructor(private http: HttpClient) {}

  public authentification(login: Login) {}

  public getAuthApi(login: Login): Observable<void> {
    const texte: string = `${login.login}:${login.password}`;
    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      authorization: `Basic ${btoa(texte)}`,
    });
    return this.http.get<void>('http://127.0.0.1:8080/projet/api/auth/login', {
      headers: headers,
    });
  }
}
