import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-category-gallery',
  templateUrl: './category-gallery.component.html',
  styleUrls: ['./category-gallery.component.scss'],
})
export class CategoryGalleryComponent implements OnInit {
  categories!: any[] ;

  responsiveOptions: any[] | undefined;

  constructor(private categoryService: CategoryService) {}



  ngOnInit() {
    this.categoryService.getAllCategories().subscribe((response: any) => {
      this.categories = response.data
    })

    this.responsiveOptions = [
      {
        breakpoint: '1199px',
        numVisible: 1,
        numScroll: 1,
      },
      {
        breakpoint: '991px',
        numVisible: 2,
        numScroll: 1,
      },
      {
        breakpoint: '767px',
        numVisible: 1,
        numScroll: 1,
      },
    ];
  }
}
