import React from 'react';
import styled from 'styled-components';
import { formatPrice } from '../utils/helpers';
import { Link } from 'react-router-dom';
import { AmountButtons } from '.';
import { useState } from 'react';

const ListView = ({ items }) => {
  return (
    <Wrapper>
      {items.map((item) => {
        const { id, title, details, amount } = item;

        return (
          <article key={id}>
            <div>
              <h5>{title}</h5>
              <h6 className="price">{formatPrice(amount)}</h6>
              <p>{details.substring(0, 150)}...</p>
              <AmountButtons item={item}></AmountButtons>
            </div>
          </article>
        );
      })}
    </Wrapper>
  );
};

const Wrapper = styled.section`
  display: grid;
  row-gap: 3rem;

  h5 {
    margin-bottom: 0.2rem;
    font-size: 25px;
  }
  .price {
    color: var(--clr-primary-6);
    margin-bottom: 0.3rem;
    font-size: 15px;
  }
  p {
    max-width: 45em;
    margin-bottom: 1rem;
  }
  .btn {
    font-size: 0.5rem;
    padding: 0.25rem 0.5rem;
  }
  @media (min-width: 992px) {
    article {
      display: grid;
      grid-template-columns: auto 1fr;
      column-gap: 2rem;
      align-items: center;
    }
  }
`;

export default ListView;
