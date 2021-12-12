import React, { useState } from 'react';
import styled from 'styled-components';
import { FaPlus, FaMinus } from 'react-icons/fa';
import { useCartContext } from '../context/cart_context';

const ResultList = () => {
  const { apiResult } = useCartContext();
  console.log(apiResult.data.name);

  return (
    <Wrapper>
      <div>
        <h4>{apiResult.data.name}</h4>
      </div>
      <table>
        <tbody>
          <tr>
            <th>Product Name</th>
            <th>Product ID</th>
            <th>Product Quantity</th>
            <th>Product Total Price</th>
          </tr>

          {apiResult.data.singleItemVOList.map((value, index) => {
            return (
              <tr key={index}>
                <td>{value.title}</td>
                <td>{value.itemId}</td>
                <td>{value.quantity}</td>
                <td>{value.totalPrice} CAD$</td>
              </tr>
            );
          })}
        </tbody>
      </table>
      <table>
        <tbody>
          <tr>
            <th>Total Taxes </th>
            <th>Total Price</th>
          </tr>
          <tr>
            <td>{apiResult.data.totalTaxes} CAD$</td>
            <td>{apiResult.data.totalPrice} CAD$</td>
          </tr>
        </tbody>
      </table>
    </Wrapper>
  );
};
const Wrapper = styled.article`
  .table,
  th,
  td {
    border: 1px solid black;
    width: 10%;
    text-align: center;
  }
`;
export default ResultList;
