import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { FormsModule } from '@angular/forms';
import { CouleurComponent } from './couleur/couleur.component';
import { ProduitComponent } from './produit/produit.component';

@NgModule({
  declarations: [AppComponent, FirstComponent, CouleurComponent, ProduitComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
