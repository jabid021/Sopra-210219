import { Observable } from 'rxjs';
import { Formation } from './../../model/formation';
import { ActivatedRoute, Router } from '@angular/router';
import { FormateurService } from './../../services/formateur.service';
import { FormationService } from './../../services/formation.service';
import { Component, OnInit } from '@angular/core';
import { Formateur } from 'src/app/model/formateur';

@Component({
  selector: 'app-formation-edit',
  templateUrl: './formation-edit.component.html',
  styleUrls: ['./formation-edit.component.css'],
})
export class FormationEditComponent implements OnInit {
  formation: Formation = new Formation();
  formateurs: Observable<Formateur[]>;

  constructor(
    private formationService: FormationService,
    private formateurService: FormateurService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.formationService.get(params.id).subscribe((data) => {
          this.formation = data;
        });
      }
    });
    this.formateurs = this.formateurService.getFormateurs();
  }

  ngOnInit(): void {}

  save() {
    if (!!this.formation.id) {
      this.formationService.update(this.formation).subscribe((res) => {
        this.goList();
      });
    } else {
      this.formationService.insert(this.formation).subscribe((res) => {
        this.goList();
      });
    }
  }

  private goList() {
    this.router.navigate(['/formation']);
  }
}
