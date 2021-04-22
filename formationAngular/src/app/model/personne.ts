export class Personne {
  public constructor(private _prenom: string = '', private _nom: string = '') {}

  /**
   * Getter prenom
   * @return {string }
   */
  public get prenom(): string {
    return this._prenom;
  }

  /**
   * Setter prenom
   * @param {string } value
   */
  public set prenom(value: string) {
    this._prenom = value;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  public info(): string {
    return this.prenom + ' ' + this._nom;
  }
}
