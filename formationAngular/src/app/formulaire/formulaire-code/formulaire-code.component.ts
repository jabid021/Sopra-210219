import { Produit } from './../../model/produit';
import { ProduitValidator } from './../../validator/produit-validator';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-formulaire-code',
  templateUrl: './formulaire-code.component.html',
  styleUrls: ['./formulaire-code.component.css'],
})
export class FormulaireCodeComponent implements OnInit {
  form: FormGroup;
  nomCtrl: FormControl;
  prixCtrl: FormControl;

  constructor(private formBuilder: FormBuilder) {
    this.nomCtrl = this.formBuilder.control('', [
      Validators.required,
      Validators.minLength(3),
    ]);
    this.prixCtrl = this.formBuilder.control(0, [
      Validators.required,
      ProduitValidator.modulo10,
    ]);
    this.form = this.formBuilder.group({
      nom: this.nomCtrl,
      prix: this.prixCtrl,
    });
  }

  ngOnInit(): void {}

  submit() {
    console.log(new Produit(this.nomCtrl.value, this.prixCtrl.value));
  }
}
