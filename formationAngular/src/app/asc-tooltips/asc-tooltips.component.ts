import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'asc-tooltips,[asc-tooltips]',
  templateUrl: './asc-tooltips.component.html',
  styleUrls: ['./asc-tooltips.component.css'],
})
export class AscTooltipsComponent implements OnInit {
  @Input('asc-tooltip-titre')
  titre: string = '';
  visible = false;

  constructor() {}

  ngOnInit(): void {}

  @HostListener('mouseover')
  show() {
    this.visible = true;
  }

  @HostListener('mouseleave')
  hide() {
    this.visible = false;
  }
}
