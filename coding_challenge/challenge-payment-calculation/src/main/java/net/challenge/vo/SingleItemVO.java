package net.challenge.vo;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class SingleItemVO {
      private String itemId;
      private String title;
      private int quantity;
      private Float totalPrice;

}
