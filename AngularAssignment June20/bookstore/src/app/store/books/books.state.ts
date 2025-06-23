import { Book } from '../../models/book.model';
import { initialBooks } from './book.data';

export interface BooksState {
  books: Book[];
}

export const initialBooksState: BooksState = {
  books: initialBooks
};
