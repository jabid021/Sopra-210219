groupimport { FormControl } from '@angular/forms';
export class ProduitValidator {
  public static modulo10(control: FormControl): any {
    if (control.value % 10 == 0) {
      return 
    } else {
      return { modulo10: true };
    }
  }
}
