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
import { AscBoldElementComponent } from './asc-bold-element/asc-bold-element.component';
import { AscTooltipsComponent } from './asc-tooltips/asc-tooltips.component';
import { VoteComponent } from './vote/vote.component';
import { ClassementComponent } from './classement/classement.component';

@NgModule({
  declarations: [AppComponent, FirstComponent, CouleurComponent, ProduitComponent, DisplayProduitComponent, OutputComponent, Produit2Component, InputProduitComponent, AscBoldElementComponent, AscTooltipsComponent, VoteComponent, ClassementComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
