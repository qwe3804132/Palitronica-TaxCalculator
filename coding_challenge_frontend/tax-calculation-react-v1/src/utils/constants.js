import React from 'react';
export const links = [
  {
    id: 1,
    text: 'home',
    url: '/',
  },
  {
    id: 2,
    text: 'Tax Calculator',
    url: '/tax-calculator',
  },
];
export const API_BASE_URL =
  process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080/api';
export const items_url = API_BASE_URL + '/items/v1/checkAllItems';
export const customers_url = API_BASE_URL + '/customer/v1/checkAll';
export const checkTax_url = API_BASE_URL + '/payment/v1/checkTax';
