import { TestService } from './../services/test.service';
import { Produit } from './../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit2',
  templateUrl: './produit2.component.html',
  styleUrls: ['./produit2.component.css'],
})
export class Produit2Component implements OnInit {
  produit: Produit = new Produit();
  message = '';
  constructor(private hello: TestService) {
    this.message = hello.helloDuService();
  }

  ngOnInit(): void {}

  public getProduit(param: Produit) {
    this.produit = new Produit(param.nom, param.prix);
  }
}
