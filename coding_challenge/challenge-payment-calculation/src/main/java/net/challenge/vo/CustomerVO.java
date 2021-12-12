package net.challenge.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerVO {

  private Long id;
  @JsonProperty("user_name")
  private String userName;
  private String name;
  private Integer sex;
  private String country;
  private String zip;
  private String state;
  private String city;
  private String street;


}
