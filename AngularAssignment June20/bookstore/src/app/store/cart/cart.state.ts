import { Book } from '../../models/book.model';

export interface CartItem {
  book: Book;
  quantity: number;
  totalPrice: number;
}

export interface CartState {
  items: CartItem[];
  totalAmount: number;
}

export const initialCartState: CartState = {
  items: [],
  totalAmount: 0
};
