import { Personne } from './../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'first-component',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent implements OnInit {
  message = 'mon message';
  couleur = 'pink';

  olivier: Personne = new Personne('olivier', 'gozlan');

  constructor() {}

  ngOnInit(): void {}

  methode(): string {
    return 'texte de la methode';
  }

  raz(): void {
    this.olivier.prenom = '';
    this.olivier.nom = '';
  }
}
