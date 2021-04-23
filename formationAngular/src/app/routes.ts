import { BonjourComponent } from './bonjour/bonjour.component';
import { Produit2Component } from './produit2/produit2.component';
import { ClassementComponent } from './classement/classement.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'classement', component: ClassementComponent },
  { path: 'produit', component: Produit2Component },
  { path: 'bonjour/:prenom', component: BonjourComponent },
];
