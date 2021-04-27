import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formulaire-template',
  templateUrl: './formulaire-template.component.html',
  styleUrls: ['./formulaire-template.component.css'],
})
export class FormulaireTemplateComponent implements OnInit {
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  submit() {

  }
}
