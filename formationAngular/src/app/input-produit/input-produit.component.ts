import { Produit } from './../model/produit';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'input-produit',
  templateUrl: './input-produit.component.html',
  styleUrls: ['./input-produit.component.css'],
})
export class InputProduitComponent implements OnInit {
  produit: Produit = new Produit();
  @Output()
  sendProduit: EventEmitter<Produit> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  public click(): void {
    this.sendProduit.emit(this.produit);
  }
}
