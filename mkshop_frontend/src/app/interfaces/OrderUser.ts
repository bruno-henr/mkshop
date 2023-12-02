import { Address } from './Address';

export interface OrderUser {
  id: string;
  created_at: number;
  updated_at: number;
  method_payment: string;
  user: string;
  address: Address;
  productOrders: any;
}
