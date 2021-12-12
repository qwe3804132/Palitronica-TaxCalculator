package net.challenge.enums;

import lombok.Getter;

/**
 * Enum type, for status code and error message
 */
public enum BizCodeEnum {
  /**
   * common
   */
  CUSTOMER_NOT_EXIST(110005,"Customer Not Exist"),
  NO_ITEMS_EXIST(110006,"No items exist"),
  CART_FAIL(220001, "No delievery items selected"),
  /**
   * VerifycODE
   */
  CODE_TO_ERROR(240001, "API error");




  /**
   * API
   */

  /**
   * 商品
   */



  @Getter
  private String message;
  @Getter
  private int code;

  private BizCodeEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }


}
