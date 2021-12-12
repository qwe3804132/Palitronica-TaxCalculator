import axios from 'axios';
import {
  ADD_TO_CART,
  ADD_CUSTOMER_TO_CART,
  CALL_TAX_API,
  CLEAN,
} from '../actions';
import { checkTax_url } from '../utils/constants';
import React, { useState } from 'react';

const cart_reducer = (state, action) => {
  if (action.type === ADD_TO_CART) {
    const { id: product_id, amount: buy_num, item } = action.payload;
    const tempItem = state.cart.find((i) => i.product_id === product_id);
    if (tempItem) {
      const tempCart = state.cart.map((cartItem) => {
        if (cartItem.product_id === product_id) {
          let newAmount = buy_num;

          return { ...cartItem, buy_num: newAmount };
        } else {
          return cartItem;
        }
      });
      return { ...state, cart: tempCart };
    } else {
      const newItem = {
        product_id,
        name: item.name,

        buy_num,
        price: item.price,
      };
      return { ...state, cart: [...state.cart, newItem] };
    }
  }

  if (action.type === CLEAN) {
    return { ...state, customer: '', cart: [], apiResult: null };
  }

  if (action.type === ADD_CUSTOMER_TO_CART) {
    const { customerId } = action.payload;

    return { ...state, customer: customerId };
  }

  if (action.type === CALL_TAX_API) {
    return { ...state, apiResult: action.payload };
  }

  throw new Error(`No Matching "${action.type}" - action type`);
};

export default cart_reducer;
