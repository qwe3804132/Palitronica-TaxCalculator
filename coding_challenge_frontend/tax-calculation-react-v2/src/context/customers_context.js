import axios from 'axios';
import React, { useContext, useEffect, useReducer } from 'react';
import reducer from '../reducers/customers_reducer';
import { customers_url as url } from '../utils/constants';
import {
  GET_CUSTOMERS_SUCCESS,
  GET_CUSTOMERS_BEGIN,
  GET_CUSTOMERS_ERROR,
} from '../actions';

const initialState = {
  customers_loading: false,
  customers_error: false,
  customers: [],
};

const CustomersContext = React.createContext();
export const CustomersProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const fetchItems = async (url) => {
    let customers = [];
    dispatch({ type: GET_CUSTOMERS_BEGIN });
    try {
      await axios.get(url).then((resp) => {
        customers = resp.data.data;
      }); //const response =
      dispatch({ type: GET_CUSTOMERS_SUCCESS, payload: customers });
    } catch (error) {
      dispatch({ type: GET_CUSTOMERS_ERROR });
    }
  };
  useEffect(() => {
    fetchItems(url);
  }, []);
  return (
    <CustomersContext.Provider value={{ ...state }}>
      {children}
    </CustomersContext.Provider>
  );
};
export const useCustomersContext = () => {
  return useContext(CustomersContext);
};
