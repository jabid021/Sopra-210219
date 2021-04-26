import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'test',
})
export class TestPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    return value > 1000 ? "c'est cher" : 'pas cher';
  }
}
