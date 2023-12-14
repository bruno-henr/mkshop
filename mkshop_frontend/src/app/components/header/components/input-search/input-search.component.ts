import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AutoCompleteCompleteEvent } from 'primeng/autocomplete';
import { ProdutsService } from 'src/app/services/products/produts.service';

@Component({
  selector: 'app-input-search',
  templateUrl: './input-search.component.html',
  styleUrls: ['./input-search.component.scss'],
})
export class InputSearchComponent implements OnInit {
  constructor(private productService: ProdutsService, private router: Router) {}
  ngOnInit(): void {
    this.productService.getProducts().subscribe((response: any) => {
      this.products = response.data;
    });
  }
  selectedItem: any;
  filteredProducts: any[] = [];
  products: any[] | undefined;

  search(event: AutoCompleteCompleteEvent) {
    this.productService.getProducts(event.query).subscribe((response: any) => {
      this.filteredProducts = response.data;
    });
  }

  selectProduct(data: any) {
    this.selectedItem = data.value.name;
    this.router.navigate(['produto', data.value.name]);
  }
}
