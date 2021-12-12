package net.challenge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taxjar.model.taxes.BreakdownLineItem;
import com.taxjar.model.taxes.TaxResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.challenge.constant.ApiKey;
import net.challenge.constant.WarehouseAddress;
import net.challenge.mapper.CustomerMapper;
import net.challenge.mapper.ItemsMapper;
import net.challenge.model.CustomerDO;
import net.challenge.model.ItemsDO;
import net.challenge.request.LineItem;
import net.challenge.service.PaymentService;
import net.challenge.vo.SingleItemVO;
import net.challenge.vo.TaxVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxjar.Taxjar;
import com.taxjar.exception.TaxjarException;


@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private CustomerMapper customerMapper;
  @Autowired
  private ItemsMapper itemsMapper;

  @Override
  public TaxVO paymentCalculation(long userId, List<LineItem> items) {

    CustomerDO customerDO = customerMapper.selectOne(
        new QueryWrapper<CustomerDO>().eq("id", userId));
    if (customerDO == null) {
      return null;
    }
    Taxjar client = new Taxjar(ApiKey.API_KEY);

    try {
      Map<String, Object> params = new HashMap<>();
      params.put("from_country", WarehouseAddress.FROM_COUNTRY);
      params.put("from_zip", WarehouseAddress.FROM_ZIP);
      params.put("from_state", WarehouseAddress.FROM_STATE);
      params.put("from_city", WarehouseAddress.FROM_CITY);
      params.put("from_street", WarehouseAddress.FROM_STREET);
      params.put("to_country", customerDO.getCountry());
      params.put("to_zip", customerDO.getZip());
      params.put("to_state", customerDO.getState());
      params.put("to_city", customerDO.getCity());
      params.put("to_street", customerDO.getStreet());
      // params.put("amount", 15);
      params.put("shipping", 0);


      List<String> nameList = new ArrayList<>();
      List<Integer> quantityList = new ArrayList<>();

      List<Map> lineItems = new ArrayList();

      for (LineItem a : items) {

        ItemsDO itemsDO = itemsMapper.selectOne(new QueryWrapper<ItemsDO>().eq("id",a.getProductId()));


        Map<String, Object> lineItem = new HashMap<>();
        lineItem.put("id", itemsDO.getId());
        lineItem.put("quantity", a.getBuyNum());
        //lineItem.put("product_tax_code", "20010");
        lineItem.put("unit_price", itemsDO.getAmount());
        lineItem.put("discount", 0);
        lineItems.add(lineItem);
        nameList.add(itemsDO.getTitle());
        quantityList.add(a.getBuyNum());


      }
      params.put("line_items", lineItems);
      TaxResponse res = client.taxForOrder(params);


      List<BreakdownLineItem> lineItemList =   res.tax.getBreakdown().getLineItems();
      List<SingleItemVO> singleItemVOList = new ArrayList<>();
     for(int i = 0;i<lineItemList.size();i++){
       SingleItemVO singleItemVO = new SingleItemVO();
       singleItemVO.setItemId(lineItemList.get(i).getId());
       singleItemVO.setTitle(nameList.get(i));
       singleItemVO.setQuantity(quantityList.get(i));
       singleItemVO.setTotalPrice(lineItemList.get(i).getTaxableAmount());
       singleItemVOList.add(singleItemVO);


     }

      TaxVO taxVO = new TaxVO();
      taxVO.setName(customerDO.getName());
      taxVO.setSingleItemVOList(singleItemVOList);
      taxVO.setTotalPrice(res.tax.getTaxableAmount());
      taxVO.setTotalTaxes(res.tax.getAmountToCollect());
      taxVO.setTax(res);


      return taxVO;

    } catch (TaxjarException e) {
      e.printStackTrace();
    }
    return null;
  }
}
