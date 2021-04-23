import { Produit } from './../model/produit';
import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produit: Produit = new Produit();
  texte: string = '';

  constructor() {}

  ngOnInit(): void {}

  isVisible(): boolean {
    return this.produit.nom !== '' && this.produit.prix != 0 ? true : false;
  }

  public click(): void {
    console.log('click');
  }

  @HostListener('click')
  public clickOnComponent(): void {
    console.log('click sur le component');
  }

  public recuperationEventOutput(param): void {
    this.texte = param;
  }
}
