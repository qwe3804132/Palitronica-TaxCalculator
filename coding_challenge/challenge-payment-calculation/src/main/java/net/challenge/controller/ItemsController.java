package net.challenge.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import net.challenge.enums.BizCodeEnum;
import net.challenge.service.ItemsService;
import net.challenge.util.JsonData;
import net.challenge.vo.CustomerVO;
import net.challenge.vo.ItemsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Peiran Liu
 * @since 2021-12-08
 */
@Api(tags = "Items Model")
@RestController
@CrossOrigin
@RequestMapping("/api/items/v1")
public class ItemsController {

  @Autowired
  private ItemsService itemsService;

  @ApiOperation("list all items")
  @GetMapping("/checkAllItems")
  public JsonData checkAll() {
    List<ItemsVO> list = itemsService.listAllItems();
    return list == null ? JsonData.buildCodeAndMsg(BizCodeEnum.NO_ITEMS_EXIST.getCode(),
        BizCodeEnum.NO_ITEMS_EXIST.getMessage()) : JsonData.buildSuccess(list);

  }

}

