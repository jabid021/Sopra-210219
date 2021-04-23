import { Produit } from './../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'display-produit',
  templateUrl: './display-produit.component.html',
  styleUrls: ['./display-produit.component.css'],
})
export class DisplayProduitComponent implements OnInit {
  @Input('produit')
  produit: Produit = new Produit();

  constructor() {
    console.log(this.produit);
  }

  ngOnInit(): void {
    console.log(this.produit);
  }
}
