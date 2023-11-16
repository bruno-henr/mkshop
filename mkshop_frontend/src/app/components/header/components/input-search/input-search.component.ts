import { Component } from '@angular/core';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';

@Component({
  selector: 'app-input-search',
  templateUrl: './input-search.component.html',
  styleUrls: ['./input-search.component.scss'],
})
export class InputSearchComponent {
  search($event: AutoCompleteCompleteEvent) {
    throw new Error('Method not implemented.');
  }
  selectedItem: any;
  suggestions: any[] = [];
}
