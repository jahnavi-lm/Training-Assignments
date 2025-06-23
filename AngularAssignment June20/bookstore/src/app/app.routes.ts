import { Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart';
import { BookListComponent } from './components/book-list/book-list';

export const routes: Routes = [
  { path: '', redirectTo: 'books', pathMatch: 'full' },
  { path: 'books', component: BookListComponent },
  { path: 'cart', component: CartComponent }
];
