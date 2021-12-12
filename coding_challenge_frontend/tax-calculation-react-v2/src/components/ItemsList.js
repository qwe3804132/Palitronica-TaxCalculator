import React from 'react';
import { useItemsContext } from '../context/items_context';
import ListView from './ListView';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useCartContext } from '../context/cart_context';
import { checkTax_url as url } from '../utils/constants';

const ItemsList = () => {
  const { items } = useItemsContext();
  const {
    callTaxApi,
    customer: customerId,
    cart: cartContent,
  } = useCartContext();
  if (items.length < 1) {
    return (
      <h5 style={{ textTransform: 'none' }}>
        Sorry, no products matched your search...
      </h5>
    );
  }

  return (
    <Wrapper>
      <div className="btn-container">
        <ListView items={items} />

        <button
          className="btn"
          type="button"
          onClick={() => callTaxApi(url, customerId, cartContent)}
        >
          Start Calculate
        </button>
      </div>
    </Wrapper>
  );
};

const Wrapper = styled.section`
  .btn-container {
    margin-top: 2rem;
  }
  .btn {
    margin-top: 1rem;
    margin-bottom: 1rem;
    width: 200px;
    height: 50px;
    vertical-align: middle;
    text-align: center;
  }
`;

export default ItemsList;
