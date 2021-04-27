import { InscriptionComponent } from './formulaire/inscription/inscription.component';
import { FormulaireTemplateComponent } from './formulaire/formulaire-template/formulaire-template.component';
import { PageIntrouvableComponent } from './page-introuvable/page-introuvable.component';
import { CanActivateService } from './services/can-activate.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { FormationListComponent } from './formation/formation-list/formation-list.component';
import { FormateurEditComponent } from './formateur/formateur-edit/formateur-edit.component';
import { FormateurListComponent } from './formateur/formateur-list/formateur-list.component';
import { BonjourComponent } from './bonjour/bonjour.component';
import { Produit2Component } from './produit2/produit2.component';
import { ClassementComponent } from './classement/classement.component';
import { Routes } from '@angular/router';
import { FormationEditComponent } from './formation/formation-edit/formation-edit.component';
import { FormulaireCodeComponent } from './formulaire/formulaire-code/formulaire-code.component';

export const routes: Routes = [
  { path: 'classement', component: ClassementComponent },
  { path: 'produit', component: Produit2Component },
  { path: 'bonjour/:prenom', component: BonjourComponent },
  {
    path: 'formateur',
    component: FormateurListComponent,
    canActivate: [CanActivateService],
  },
  {
    path: 'formateur/edit',
    component: FormateurEditComponent,
    canActivate: [CanActivateService],
  },
  {
    path: 'formateur/edit/:id',
    component: FormateurEditComponent,
    canActivate: [CanActivateService],
  },
  {
    path: 'formation',
    component: FormationListComponent,
    canActivate: [CanActivateService],
  },
  {
    path: 'formation/edit',
    component: FormationEditComponent,
    canActivate: [CanActivateService],
  },
  {
    path: 'formation/edit/:id',
    component: FormationEditComponent,
    canActivate: [CanActivateService],
  },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'formulaire', component: FormulaireCodeComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: '**', component: PageIntrouvableComponent },
];
