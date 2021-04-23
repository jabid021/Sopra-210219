import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { FormsModule } from '@angular/forms';
import { CouleurComponent } from './couleur/couleur.component';
import { ProduitComponent } from './produit/produit.component';
import { DisplayProduitComponent } from './display-produit/display-produit.component';
import { OutputComponent } from './output/output.component';
import { Produit2Component } from './produit2/produit2.component';
import { InputProduitComponent } from './input-produit/input-produit.component';

@NgModule({
  declarations: [AppComponent, FirstComponent, CouleurComponent, ProduitComponent, DisplayProduitComponent, OutputComponent, Produit2Component, InputProduitComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
