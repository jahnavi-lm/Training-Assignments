import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { AppState } from '../../store/app.state';
import { selectCartItems, selectCartTotal } from '../../store/cart/cart.selector';
import { checkout, removeFromCart, increaseCartQuantity, decreaseCartQuantity } from '../../store/cart/cart.actions';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cart.html',
  styleUrls: ['./cart.scss']
})
export class CartComponent {
  private store = inject(Store<AppState>);
  items$ = this.store.select(selectCartItems);
  total$ = this.store.select(selectCartTotal);

  removeItem(id: number) {
    this.store.dispatch(removeFromCart({ bookId: id }));
  }

  increase(id: number) {
    this.store.dispatch(increaseCartQuantity({ bookId: id }));
  }

  decrease(id: number) {
    this.store.dispatch(decreaseCartQuantity({ bookId: id }));
  }

  checkoutCart() {
    this.store.dispatch(checkout());
    alert('✅ Checkout successful! Thank you.');
  }
}
