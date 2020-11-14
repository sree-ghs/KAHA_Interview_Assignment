import { Pipe, PipeTransform } from '@angular/core';
import { stateList } from '../data-model/state.constant';

@Pipe({
  name: 'stateName'
})
export class StateNamePipe implements PipeTransform {

  transform(value: string): string {
    let staneName = '';
    stateList.forEach(item => {
      if (item.aabbreviation === value) {
        staneName = item.statename;
      }
    });
    return staneName;
  }

}
