package net.challenge.vo;

import com.taxjar.model.taxes.TaxResponse;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class TaxVO {
  private String name;
  private List<SingleItemVO> singleItemVOList;
  private Float totalTaxes;
  private Float totalPrice;
  private TaxResponse tax;
}
