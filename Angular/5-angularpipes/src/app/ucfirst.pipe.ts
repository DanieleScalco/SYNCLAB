import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ucfirst'
})
export class UcfirstPipe implements PipeTransform {

  transform(value: string): string {
    // Es value: "the value of life"
    // Con la split diventa [the, value, of, life]
    return value.split(' ').map((word: string) => word.charAt(0).toLocaleUpperCase() + word.substr(1)).join(' ');
  }
  

}
