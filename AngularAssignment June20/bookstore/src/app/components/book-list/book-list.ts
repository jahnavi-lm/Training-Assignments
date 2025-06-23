import { Component, computed, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { AppState } from '../../store/app.state';
import { selectAllBooks } from '../../store/books/books.selectors';
import { decreaseQuantity, increaseQuantity, updateQuantity } from '../../store/books/books.actions';
import { Book } from '../../models/book.model';
import { addToCart as addToCartAction } from '../../store/cart/cart.actions';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './book-list.html',
  styleUrls: ['./book-list.scss']
})
export class BookListComponent {
  private store = inject(Store<AppState>);
  books$ = this.store.select(selectAllBooks);

  increaseQuantity(book: Book) {
    if (book.quantity < book.available) {
      this.store.dispatch(updateQuantity({ bookId: book.id, change: 1 }));
    }
  }

  decreaseQuantity(book: Book) {
    if (book.quantity > 1) {
      this.store.dispatch(updateQuantity({ bookId: book.id, change: -1 }));
    }
  }

  addToCart(book: Book) {
    if (book.available > 0) {
      this.store.dispatch(addToCartAction({ book }));
    }
  }


  increaseQty(id: number) {
    this.store.dispatch(increaseQuantity({ bookId: id }));
  }

  decreaseQty(id: number) {
    this.store.dispatch(decreaseQuantity({ bookId: id }));
  }

  updateQty(book: Book, change: number) {
    this.store.dispatch(updateQuantity({ bookId: book.id, change }));
  }

}
