import { Observable } from 'rxjs';
import { InscriptionService } from './../../services/inscription.service';
import { Router } from '@angular/router';
import {
  FormControl,
  FormGroup,
  FormBuilder,
  Validators,
  AsyncValidatorFn,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { debounceTime, map } from 'rxjs/operators';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  loginCtrl: FormControl;
  passwordCtrl: FormControl;
  confirmationCtrl: FormControl;
  passwordGroup: FormGroup;
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private inscriptionServie: InscriptionService
  ) {
    this.loginCtrl = this.fb.control(
      '',
      [Validators.required, Validators.minLength(3)],
      this.controlLogin()
    );
    this.passwordCtrl = this.fb.control('', [
      Validators.required,
      Validators.pattern(/^(?=.*\d)(?=.*[a-zA-Z])([a-zA-Z0-9]{3,})$/),
    ]);
    this.confirmationCtrl = this.fb.control('', Validators.required);
    this.passwordGroup = this.fb.group(
      {
        password: this.passwordCtrl,
        confirmation: this.confirmationCtrl,
      },
      {
        validators: this.checkPassword,
      }
    );
    this.form = this.fb.group({
      login: this.loginCtrl,
      passwordGroup: this.passwordGroup,
    });
  }

  ngOnInit(): void {}

  controlLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionServie.checkLogin(control.value).pipe(
        debounceTime(500),
        map((result: boolean) => {
          return result ? { loginExist: true } : null;
        })
      );
    };
  }

  checkPassword(group: FormGroup) {
    const password = group.controls['password'];
    const confirmation = group.controls.confirmation;
    if (password.errors) {
      return null;
    }
    return password.value != confirmation.value ? { notEquals: true } : null;
  }

  send() {
    this.inscriptionServie
      .inscription(this.loginCtrl.value, this.passwordCtrl.value)
      .subscribe((res) => {
        this.router.navigate(['/login']);
      });
  }

  loginIsInvalid(): boolean {
    return this.loginCtrl.dirty && this.loginCtrl.invalid;
  }

  passwordIsInvalid(): boolean {
    return this.passwordCtrl.dirty && this.passwordCtrl.invalid;
  }

  passwordGroupIsInvalid() {
    return this.passwordGroup.dirty && this.passwordGroup.invalid;
  }
}
