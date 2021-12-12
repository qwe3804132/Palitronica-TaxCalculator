import {
  GET_ITEMS_BEGIN,
  GET_ITEMS_SUCCESS,
  GET_ITEMS_ERROR,
} from '../actions';

const items_reducer = (state, action) => {
  if (action.type === GET_ITEMS_BEGIN) {
    return { ...state, items_loading: true };
  }

  if (action.type === GET_ITEMS_SUCCESS) {
    //need filter? no for now
    const items = action.payload;
    return {
      ...state,
      items_loading: false,
      items: action.payload,
    };
  }

  if (action.type === GET_ITEMS_ERROR) {
    return { ...state, items_loading: false, items_error: true };
  }

  throw new Error(`No Matching "${action.type}" - action type`);
};

export default items_reducer;
