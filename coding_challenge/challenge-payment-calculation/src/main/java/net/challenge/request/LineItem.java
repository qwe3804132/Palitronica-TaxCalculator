package net.challenge.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class LineItem {

  @JsonProperty("product_id")
  private Long productId;

  private String title;

  private String details;

  private BigDecimal amount;
  @JsonProperty("buy_num")
  private int buyNum;
}
