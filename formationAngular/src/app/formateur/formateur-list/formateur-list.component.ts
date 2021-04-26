import { Formateur } from './../../model/formateur';
import { FormateurService } from './../../services/formateur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formateur-list',
  templateUrl: './formateur-list.component.html',
  styleUrls: ['./formateur-list.component.css'],
})
export class FormateurListComponent implements OnInit {
  formateurs: Formateur[];
  constructor(private formateurService: FormateurService) {}

  ngOnInit(): void {
    this.list();
  }

  delete(id: number) {
    this.formateurService.delete(id).subscribe((res) => {
      this.list();
    });
  }

  private list() {
    this.formateurService.getFormateurs().subscribe((data) => {
      this.formateurs = data;
    });
  }
}
