import { FormationService } from './../../services/formation.service';
import { Formation } from './../../model/formation';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formation-list',
  templateUrl: './formation-list.component.html',
  styleUrls: ['./formation-list.component.css'],
})
export class FormationListComponent implements OnInit {
  formations: Observable<Formation[]>;

  constructor(private formationService: FormationService) {}

  ngOnInit(): void {
    this.formations = this.formationService.list();
  }
  delete(id: number) {
    this.formationService.delete(id).subscribe((res) => {
      this.formations = this.formationService.list();
    });
  }
}
