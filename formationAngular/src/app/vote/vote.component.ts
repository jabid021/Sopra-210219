import { Personne } from './../model/personne';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css'],
})
export class VoteComponent implements OnInit {
  @Input()
  personne: Personne = new Personne();
  @Output()
  voterEmit: EventEmitter<Object> = new EventEmitter();
  nbreVote: number = 0;

  constructor() {}

  ngOnInit(): void {}

  public voter() {
    this.nbreVote++;
    this.voterEmit.emit({ personne: this.personne, nbreVote: this.nbreVote });
  }
}
