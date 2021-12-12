import axios from 'axios';
import React, { useContext, useEffect, useReducer } from 'react';
import reducer from '../reducers/items_reducer';
import { items_url as url } from '../utils/constants';
import {
  GET_ITEMS_SUCCESS,
  GET_ITEMS_BEGIN,
  GET_ITEMS_ERROR,
} from '../actions';

const initialState = {
  items_loading: false,
  items_error: false,
  items: [],
};

const ItemsContext = React.createContext();
export const ItemsProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const fetchItems = async (url) => {
    let items = [];
    dispatch({ type: GET_ITEMS_BEGIN });
    try {
      await axios.get(url).then((resp) => {
        items = resp.data.data;
      }); //const response =
      dispatch({ type: GET_ITEMS_SUCCESS, payload: items });
    } catch (error) {
      dispatch({ type: GET_ITEMS_ERROR });
    }
  };
  useEffect(() => {
    fetchItems(url);
  }, []);
  return (
    <ItemsContext.Provider value={{ ...state }}>
      {children}
    </ItemsContext.Provider>
  );
};
export const useItemsContext = () => {
  return useContext(ItemsContext);
};
