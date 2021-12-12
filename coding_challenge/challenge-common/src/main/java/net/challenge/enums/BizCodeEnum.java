package net.challenge.enums;

import lombok.Getter;

/**
 * Enum type, for status code and error message
 */
public enum BizCodeEnum {
  /**
   * common
   */
  OPS_REPEAT(110001, "duplicate operation"),
  CUSTOMER_NOT_EXIST(110005,"Customer Not Exist"),
  NO_ITEMS_EXIST(110006,"No items exist"),


  CART_FAIL(220001, "No delievery items selected"),

  /**
   * VerifycODE
   */
  CODE_TO_ERROR(240001, "API error"),

  /**
   * Account
   */

  ACCOUNT_UNLOGIN(25004, "账号未登录"),

  /**
   * API
   */
  PAY_ORDER_FAIL(300001, "创建支付订单失败"),

  /**
   * 商品
   */
  PRODUCT_NOT_EXIST(700001, "商品ID不存在");


  @Getter
  private String message;
  @Getter
  private int code;

  private BizCodeEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }


}
