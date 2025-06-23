import { BooksState } from './books/books.state';
import { CartState } from './cart/cart.state';

export interface AppState {
  books: BooksState;
  cart: CartState;
}
