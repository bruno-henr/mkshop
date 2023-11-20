import { Component } from '@angular/core';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.scss'],
})
export class GalleryComponent {
  images: any[] | undefined = [
    {
      itemImageSrc: 'assets/banner-mkshop.png',
      thumbnailImageSrc: 'assets/banner-mkshop.png',
      alt: 'Description for Image 1',
      title: 'Title 1',
    },
    {
      itemImageSrc: 'assets/banner-mkshop.png',
      thumbnailImageSrc: 'assets/banner-mkshop.png',
      alt: 'Description for Image 1',
      title: 'Title 1',
    },
  ];

  responsiveOptions: any[] = [
    {
      breakpoint: '1024px',
      numVisible: 5,
    },
    {
      breakpoint: '768px',
      numVisible: 3,
    },
    {
      breakpoint: '560px',
      numVisible: 1,
    },
  ];
}
