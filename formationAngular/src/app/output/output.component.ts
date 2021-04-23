import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css'],
})
export class OutputComponent implements OnInit {
  @Output()
  eventSortiePrete: EventEmitter<string> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  declenchementEventSortiePrete() {
    this.eventSortiePrete.emit('info de outputComponent');
  }
}
