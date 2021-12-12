package net.challenge.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import net.challenge.enums.BizCodeEnum;
import net.challenge.service.CustomerService;
import net.challenge.util.JsonData;
import net.challenge.vo.CustomerVO;
import org.junit.jupiter.api.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * front controller
 * </p>
 *
 * @author Peiran Liu
 * @since 2021-12-08
 */
@Api(tags = "Customer Model")
@RestController
@CrossOrigin
@RequestMapping("/api/customer/v1")
public class CustomerController {

  @Autowired
  private CustomerService customerService;


  @ApiOperation("checking all customer information")
  @GetMapping("/checkAll")
  public JsonData checkAll() {
    List<CustomerVO> list = customerService.list();
    return JsonData.buildSuccess(list);

  }


  @ApiOperation("checking customer information detail")
  @GetMapping("/check/{customer_id}")
  public JsonData detail(
      @ApiParam(value = "customerIO", required = true) @PathVariable("customer_id") Long customerId) {
    CustomerVO customerVO = customerService.detail(customerId);

    return customerVO == null ? JsonData.buildCodeAndMsg(BizCodeEnum.CUSTOMER_NOT_EXIST.getCode(),
        BizCodeEnum.CUSTOMER_NOT_EXIST.getMessage()) : JsonData.buildSuccess(customerVO);

  }

}

