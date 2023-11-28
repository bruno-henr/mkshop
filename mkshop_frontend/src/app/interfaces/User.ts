import { Address } from 'src/app/interfaces/Address';

export interface User {
  id: string;
  created_at: number;
  updated_at: number;
  full_name: string;
  username: string;
  phone_number: string;
  cpf: string;
  address: Address | null;
  order: any;
  role: string;
}
