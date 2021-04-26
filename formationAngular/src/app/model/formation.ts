import { Formateur } from './formateur';
export class Formation {
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _dateFormation?: Date,
    private _referent?: Formateur
  ) {}

  public get id(): number {
    return this._id;
  }

  public set id(value: number) {
    this._id = value;
  }

  public get nom(): string {
    return this._nom;
  }

  public set nom(value: string) {
    this._nom = value;
  }

  public get dateFormation(): Date {
    return this._dateFormation;
  }

  public set dateFormation(value: Date) {
    this._dateFormation = value;
  }
  public get referent(): Formateur {
    return this._referent;
  }

  public set referent(value: Formateur) {
    this._referent = value;
  }
}
