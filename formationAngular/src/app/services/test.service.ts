import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TestService {
  constructor() {}

  public helloDuService(): string {
    return 'hello du service';
  }
}
