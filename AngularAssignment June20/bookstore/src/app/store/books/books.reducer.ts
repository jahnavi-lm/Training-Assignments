import { createReducer, on } from '@ngrx/store';
import { initialBooksState } from './books.state';
import {
  addToCart,
  updateQuantity,
  increaseQuantity,
  decreaseQuantity
} from './books.actions';

export const booksReducer = createReducer(
  initialBooksState,

  // ✅ When added to cart, decrease available by quantity
  on(addToCart, (state, { book }) => {
    const updatedBooks = state.books.map(b =>
      b.id === book.id
        ? { ...b, available: b.available - book.quantity }
        : b
    );
    return { ...state, books: updatedBooks };
  }),

  // ✅ When quantity is updated in book list
  on(updateQuantity, (state, { bookId, change }) => {
    const updatedBooks = state.books.map(b => {
      if (b.id === bookId) {
        const newQuantity = b.quantity + change;

        // Prevent quantity < 1 or available < 0
        if (change > 0 && b.available > 0) {
          return {
            ...b,
            quantity: newQuantity,
            available: b.available - 1
          };
        } else if (change < 0 && b.quantity > 1) {
          return {
            ...b,
            quantity: newQuantity,
            available: b.available + 1
          };
        }
      }
      return b;
    });
    return { ...state, books: updatedBooks };
  })
);
