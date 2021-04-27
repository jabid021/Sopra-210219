import { Router } from '@angular/router';
import { Login } from './../../model/login';
import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: Login = new Login();
  message: string;

  constructor(
    private authentificationService: AuthentificationService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  send() {
    this.authentificationService.getAuthApi(this.login).subscribe(
      (res) => {
        this.message = null;
        localStorage.setItem(
          'auth',
          btoa(this.login.login + ':' + this.login.password)
        );
        localStorage.setItem('login', this.login.login);
        this.router.navigate(['/home']);
      },
      (error) => {
        this.message = "erreur d'authentification";
      }
    );
  }
}
