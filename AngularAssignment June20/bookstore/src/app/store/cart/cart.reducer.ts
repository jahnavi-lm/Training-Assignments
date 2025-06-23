import { createReducer, on } from '@ngrx/store';
import {
  addToCart,
  removeFromCart,
  checkout,
  increaseCartQuantity,
  decreaseCartQuantity
} from './cart.actions';
import { CartItem, CartState, initialCartState } from './cart.state';

export const cartReducer = createReducer(
  initialCartState,

  on(addToCart, (state, { book }) => {
    const existingItem = state.items.find((item: CartItem) => item.book.id === book.id);
    let updatedItems: CartItem[];

    if (existingItem) {
      updatedItems = state.items.map((item: CartItem) =>
        item.book.id === book.id
          ? {
              ...item,
              quantity: item.quantity + book.quantity,
              totalPrice: (item.quantity + book.quantity) * book.price,
              book: { ...item.book, available: item.book.available - book.quantity }
            }
          : item
      );
    } else {
      updatedItems = [
        ...state.items,
        {
          book: { ...book, available: book.available - book.quantity },
          quantity: book.quantity,
          totalPrice: book.price * book.quantity
        }
      ];
    }

    const newTotal = updatedItems.reduce((acc: number, item: CartItem) => acc + item.totalPrice, 0);

    return {
      ...state,
      items: updatedItems,
      totalAmount: newTotal
    };
  }),

  on(removeFromCart, (state, { bookId }) => {
    const removedItem = state.items.find(i => i.book.id === bookId);
    const updatedItems = state.items.filter(item => item.book.id !== bookId);
    const newTotal = updatedItems.reduce((acc, item) => acc + item.totalPrice, 0);

    return {
      ...state,
      items: updatedItems,
      totalAmount: newTotal
    };
  }),

  on(checkout, () => ({
    items: [],
    totalAmount: 0
  })),

  // ✅ Increase Quantity
  on(increaseCartQuantity, (state, { bookId }) => {
    const updatedItems = state.items.map(item => {
      if (item.book.id === bookId && item.book.available > 0) {
        return {
          ...item,
          quantity: item.quantity + 1,
          totalPrice: (item.quantity + 1) * item.book.price,
          book: { ...item.book, available: item.book.available - 1 }
        };
      }
      return item;
    });

    const totalAmount = updatedItems.reduce((acc, item) => acc + item.totalPrice, 0);

    return {
      ...state,
      items: updatedItems,
      totalAmount
    };
  }),

  // ✅ Decrease Quantity
  on(decreaseCartQuantity, (state, { bookId }) => {
    const updatedItems = state.items
      .map(item => {
        if (item.book.id === bookId && item.quantity > 1) {
          return {
            ...item,
            quantity: item.quantity - 1,
            totalPrice: (item.quantity - 1) * item.book.price,
            book: { ...item.book, available: item.book.available + 1 }
          };
        }
        return item;
      });

    const totalAmount = updatedItems.reduce((acc, item) => acc + item.totalPrice, 0);

    return {
      ...state,
      items: updatedItems,
      totalAmount
    };
  })
);
