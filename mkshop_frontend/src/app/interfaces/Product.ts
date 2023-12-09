export interface Product {
  //
  StockQuantity: number;
  category?: {
    id: string;
    name: string;
  };
  categoryId: string;
  composition: string;
  fabricator: string;
  id: string;
  imageProducts: any[];
  img_url: string;
  main: boolean;
  name: string;
  price: number;
  productOrders: any[];
}
