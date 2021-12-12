import React, { useEffect } from 'react';
import styled from 'styled-components';
import { PageHero } from '../components';
import { ItemsList } from '../components';
import { CustomersList } from '../components';
import { useCartContext } from '../context/cart_context';
import { ResultList } from '../components';
import { Error } from '../components';
const CalculatorPage = () => {
  const { customer, addCustomerToCart, apiResult } = useCartContext();

  return (
    <main>
      <Wrapper className="page">
        <PageHero title="Tax Calculator"></PageHero>

        <Link href="#">
          <Icon viewBox="0 0 20 20">
            <path d="M10 15h8c1 0 2-1 2-2V3c0-1-1-2-2-2H2C1 1 0 2 0 3v10c0 1 1 2 2 2h4v4l4-4zM5 7h2v2H5V7zm4 0h2v2H9V7zm4 0h2v2h-2V7z" />
          </Icon>
          <Label>
            Palitronica Warehouse Address: 151 Charles St W Suite #199
            Kitchener, ON, N2G 1H6
          </Label>
        </Link>

        <div className="section-center page">
          <div>
            <CustomersList></CustomersList>
          </div>

          <div className="form-control">
            <input
              type="text"
              name="customer id"
              placeholder="Input customer ID"
              className="customer-input"
              value={customer}
              onChange={addCustomerToCart}
            />
          </div>
          <section className="indent-1">
            <section className="content ">
              <div>
                <ItemsList />
              </div>
            </section>
            <section className="content ">
              {apiResult != null && apiResult.code === 0 && (
                <ResultList></ResultList>
              )}
              {apiResult != null && apiResult.code === 110005 && (
                <Error></Error>
              )}
            </section>
          </section>
        </div>
      </Wrapper>
    </main>
  );
};

const Wrapper = styled.div`
  .indent-1 {
    float: left;
  }
  .indent-1 section {
    width: 50%;
    float: left;
  }

  .products {
    display: grid;
    gap: 3rem 1.5rem;
    margin: 4rem auto;
  }
  @media (min-width: 768px) {
    .products {
      grid-template-columns: 200px 1fr;
    }
  }
  .customer-input {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }
`;

const Link = styled.a`
  display: flex;
  align-items: center;
  padding: 5px 10px;
  background: papayawhip;
  color: palevioletred;
`;

const Icon = styled.svg`
  flex: none;
  transition: fill 0.25s;
  width: 48px;
  height: 48px;

  ${Link}:hover & {
    fill: rebeccapurple;
  }
`;

const Label = styled.span`
  display: flex;
  align-items: center;
  line-height: 1.2;

  &::before {
    content: '◀';
    margin: 0 10px;
  }
`;

export default CalculatorPage;
