package net.challenge.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class PaymentCalculation {

  @JsonProperty("user_id")
  private Long userId;

  private List<LineItem> items;

}
