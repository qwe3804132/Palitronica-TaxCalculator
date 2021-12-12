import {
  GET_CUSTOMERS_BEGIN,
  GET_CUSTOMERS_ERROR,
  GET_CUSTOMERS_SUCCESS,
} from '../actions';

const customers_reducer = (state, action) => {
  if (action.type === GET_CUSTOMERS_BEGIN) {
    return { ...state, customers_loading: true };
  }

  if (action.type === GET_CUSTOMERS_SUCCESS) {
    //need filter? no for now
    const customers = action.payload;
    return {
      ...state,
      customers_loading: false,
      customers: action.payload,
    };
  }

  if (action.type === GET_CUSTOMERS_ERROR) {
    return { ...state, customers_loading: false, customers_error: true };
  }

  throw new Error(`No Matching "${action.type}" - action type`);
};

export default customers_reducer;
