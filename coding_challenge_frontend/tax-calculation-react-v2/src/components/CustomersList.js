import React from 'react';
import { useCustomersContext } from '../context/customers_context';
import styled from 'styled-components';

const CustomersList = () => {
  const { customers } = useCustomersContext();

  if (customers.length < 1) {
    return (
      <h5 style={{ textTransform: 'none' }}>
        Sorry, no customers matched your search...
      </h5>
    );
  }

  return (
    <Wrapper>
      <table>
        <tbody>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Sex</th>
            <th>Country</th>
            <th>zip</th>
            <th>state</th>
            <th>city</th>
            <th>street</th>
          </tr>
          {customers.map((value, index) => {
            return (
              <tr key={index}>
                <td>{value.id}</td>
                <td>{value.name}</td>
                <td>{value.sex === 1 ? 'Male' : 'Female'}</td>
                <td>{value.country}</td>
                <td>{value.zip}</td>
                <td>{value.state}</td>
                <td>{value.city}</td>
                <td>{value.street}</td>
              </tr>
            );
          })}
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

export default CustomersList;
