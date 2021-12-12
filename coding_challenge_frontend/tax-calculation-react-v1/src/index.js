import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { ItemsProvider } from './context/items_context';
import { CustomersProvider } from './context/customers_context';
import { CartProvider } from './context/cart_context';

ReactDOM.render(
  <ItemsProvider>
    <CustomersProvider>
      <CartProvider>
        <App />
      </CartProvider>
    </CustomersProvider>
  </ItemsProvider>,
  document.getElementById('root')
);
