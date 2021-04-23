import { Personne } from './../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-classement',
  templateUrl: './classement.component.html',
  styleUrls: ['./classement.component.css'],
})
export class ClassementComponent implements OnInit {
  best: Personne = new Personne();
  personnes: Personne[] = [
    new Personne('toto', 'toto'),
    new Personne('tutu', 'tutu'),
    new Personne('titi', 'titi'),
    new Personne('tyty', 'tyty'),
  ];
  nbreVote: number = 0;

  constructor() {}

  ngOnInit(): void {}

  traitementVote(param) {
    if (param.nbreVote > this.nbreVote) {
      this.best = param.personne;
      this.nbreVote = param.nbreVote;
    } else if (
      param.personne.prenom == this.best.prenom &&
      param.personne.nom == this.best.nom
    ) {
      this.nbreVote = param.nbreVote;
    }
  }
}
