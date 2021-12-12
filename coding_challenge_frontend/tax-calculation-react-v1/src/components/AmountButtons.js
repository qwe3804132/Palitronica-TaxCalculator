import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { FaPlus, FaMinus } from 'react-icons/fa';
import { useCartContext } from '../context/cart_context';

const AmountButtons = ({ item }) => {
  const { addToCart } = useCartContext();
  const [number, setNumber] = useState(0);

  useEffect(() => {
    setNumber(0);
  }, []);
  const increase = () => {
    setNumber((oldNumber) => {
      let tempNumber = oldNumber + 1;

      return tempNumber;
    });
    addToCart(item.id, number + 1, item);
  };
  const decrease = () => {
    setNumber((oldNumber) => {
      let tempNumber = oldNumber - 1;
      if (tempNumber < 1) {
        tempNumber = 0;
      }
      return tempNumber;
    });
    addToCart(item.id, number > 0 ? number - 1 : number, item);
  };

  return (
    <Wrapper className="amount-btns">
      <button type="button" className="amount-btn" onClick={decrease}>
        <FaMinus />
      </button>
      <h2 className="amount">{number}</h2>
      <button type="button" className="amount-btn" onClick={increase}>
        <FaPlus />
      </button>
    </Wrapper>
  );
};

const Wrapper = styled.div`
  display: grid;
  width: 140px;
  justify-items: center;
  grid-template-columns: repeat(3, 1fr);
  align-items: center;
  h2 {
    margin-bottom: 0;
    font-size: 25px;
  }
  button {
    background: transparent;
    border-color: transparent;
    cursor: pointer;
    padding: 1rem 0;
    width: 2rem;
    height: 1rem;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  h2 {
    margin-bottom: 0;
  }
`;

export default AmountButtons;
