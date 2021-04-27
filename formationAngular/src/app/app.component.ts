import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  public constructor(private router: Router) {}

  public get login(): string {
    return localStorage.getItem('login');
  }

  public logout() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }
}
