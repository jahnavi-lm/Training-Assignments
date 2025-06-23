import { createAction, props } from '@ngrx/store';
import { Book } from '../../models/book.model';

export const addToCart = createAction(
  '[Cart] Add Book',
  props<{ book: Book }>()
);

export const removeFromCart = createAction(
  '[Cart] Remove Book',
  props<{ bookId: number }>()
);

export const checkout = createAction('[Cart] Checkout');

// ✅ NEW ACTIONS
export const increaseCartQuantity = createAction(
  '[Cart] Increase Quantity',
  props<{ bookId: number }>()
);

export const decreaseCartQuantity = createAction(
  '[Cart] Decrease Quantity',
  props<{ bookId: number }>()
);
