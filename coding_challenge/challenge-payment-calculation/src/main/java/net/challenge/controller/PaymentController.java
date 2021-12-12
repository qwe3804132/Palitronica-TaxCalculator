package net.challenge.controller;

import com.taxjar.model.taxes.Tax;
import com.taxjar.model.taxes.TaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletResponse;
import net.challenge.enums.BizCodeEnum;
import net.challenge.request.PaymentCalculation;
import net.challenge.service.CustomerService;
import net.challenge.service.ItemsService;
import net.challenge.service.PaymentService;
import net.challenge.util.JsonData;
import net.challenge.vo.TaxVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Payment Model")
@RestController
@CrossOrigin
@RequestMapping("/api/payment/v1")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;
  @Autowired
  private CustomerService customerService;

  @ApiOperation("checkTax")
  @PostMapping("checkTax")
  public JsonData checkTax(
      @ApiParam("order object") @RequestBody PaymentCalculation paymentCalculation
  ) {
    if (paymentCalculation.getUserId() == null
        || customerService.detail(paymentCalculation.getUserId()) == null) {
      return JsonData.buildCodeAndMsg(BizCodeEnum.CUSTOMER_NOT_EXIST.getCode(),
          BizCodeEnum.CUSTOMER_NOT_EXIST.getMessage());

    }

    if (paymentCalculation.getItems().isEmpty()) {
      return JsonData.buildCodeAndMsg(BizCodeEnum.CART_FAIL.getCode(),
          BizCodeEnum.CART_FAIL.getMessage());
    }

    TaxVO tax = paymentService.paymentCalculation(paymentCalculation.getUserId(),
        paymentCalculation.getItems());
    if (tax.getSingleItemVOList() == null) {
      return JsonData.buildCodeAndMsg(BizCodeEnum.CODE_TO_ERROR.getCode(),
          BizCodeEnum.CODE_TO_ERROR.getMessage());

    }

    return JsonData.buildSuccess(tax);
  }

}
