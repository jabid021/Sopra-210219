import { FormationListComponent } from './formation/formation-list/formation-list.component';
import { FormateurEditComponent } from './formateur/formateur-edit/formateur-edit.component';
import { FormateurListComponent } from './formateur/formateur-list/formateur-list.component';
import { BonjourComponent } from './bonjour/bonjour.component';
import { Produit2Component } from './produit2/produit2.component';
import { ClassementComponent } from './classement/classement.component';
import { Routes } from '@angular/router';
import { FormationEditComponent } from './formation/formation-edit/formation-edit.component';

export const routes: Routes = [
  { path: 'classement', component: ClassementComponent },
  { path: 'produit', component: Produit2Component },
  { path: 'bonjour/:prenom', component: BonjourComponent },
  { path: 'formateur', component: FormateurListComponent },
  { path: 'formateur/edit', component: FormateurEditComponent },
  { path: 'formateur/edit/:id', component: FormateurEditComponent },
  { path: 'formation', component: FormationListComponent },
  { path: 'formation/edit', component: FormationEditComponent },
  { path: 'formation/edit/:id', component: FormationEditComponent },
];
