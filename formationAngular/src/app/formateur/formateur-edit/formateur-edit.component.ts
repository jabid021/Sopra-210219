import { FormateurService } from './../../services/formateur.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Formateur } from './../../model/formateur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formateur-edit',
  templateUrl: './formateur-edit.component.html',
  styleUrls: ['./formateur-edit.component.css'],
})
export class FormateurEditComponent implements OnInit {
  formateur: Formateur = new Formateur();
  id: number = -1;
  constructor(
    private activatedRoute: ActivatedRoute,
    private formateurService: FormateurService,
    private router: Router
  ) {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.id = params.id;
        this.formateurService.getFormateur(this.id).subscribe((data) => {
          console.log(data);
          this.formateur = data;
        });
      }
    });
  }

  ngOnInit(): void {}

  save() {
    if (this.id == -1) {
      this.formateurService.insert(this.formateur).subscribe((data) => {
        this.router.navigate(['/formateur']);
      });
    } else {
      this.formateurService.update(this.formateur).subscribe((data) => {
        this.router.navigate(['/formateur']);
      });
    }
  }
}
