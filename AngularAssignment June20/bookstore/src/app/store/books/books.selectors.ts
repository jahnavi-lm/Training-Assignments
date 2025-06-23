import { createFeatureSelector, createSelector } from '@ngrx/store';
import { BooksState } from './books.state';

export const selectBooksState = createFeatureSelector<BooksState>('books');

export const selectAllBooks = createSelector(
  selectBooksState,
  state => state.books
);
