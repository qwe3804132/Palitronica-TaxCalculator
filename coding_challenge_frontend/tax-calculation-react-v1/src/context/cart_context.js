import React, { useEffect, useContext, useReducer } from 'react';
import reducer from '../reducers/cart_reducer';
import { checkTax_url as url } from '../utils/constants';

import {
  ADD_TO_CART,
  ADD_CUSTOMER_TO_CART,
  CALL_TAX_API,
  CLEAN,
} from '../actions';
import axios from 'axios';
const initialState = {
  cart: [],
  total_items: [],
  customer: '',
  apiResult: null,
};

const CartContext = React.createContext();

export const CartProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const addToCart = (id, amount, item) => {
    dispatch({ type: ADD_TO_CART, payload: { id, amount, item } });
  };

  const clean = () => {
    dispatch({ type: CLEAN });
  };

  const addCustomerToCart = (e) => {
    let customerId = e.target.value;

    dispatch({ type: ADD_CUSTOMER_TO_CART, payload: { customerId } });
  };

  const callTaxApi = async (url, customer, cart) => {
    let res;

    try {
      const cart1 = cart;
      const customer1 = customer;
      const article = { user_id: customer1, items: cart1 };
      await axios.post(url, article).then((resp) => {
        res = resp.data;
      });
    } catch (error) {}

    dispatch({ type: CALL_TAX_API, payload: res });
  };

  return (
    <CartContext.Provider
      value={{ ...state, addToCart, addCustomerToCart, callTaxApi, clean }}
    >
      {children}
    </CartContext.Provider>
  );
};

export const useCartContext = () => {
  return useContext(CartContext);
};
