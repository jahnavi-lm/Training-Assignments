import { createAction, props } from '@ngrx/store';
import { Book } from '../../models/book.model';

export const loadBooks = createAction('[Books] Load Books');
export const addToCart = createAction('[Books] Add to Cart', props<{ book: Book }>());
export const increaseQuantity = createAction(
    '[Books] Increase Quantity',
    props<{ bookId: number }>()
  );
  
  export const decreaseQuantity = createAction(
    '[Books] Decrease Quantity',
    props<{ bookId: number }>()
  );
  
  export const updateQuantity = createAction(
    '[Books] Update Quantity',
    props<{ bookId: number; change: number }>()
  );
  
  
