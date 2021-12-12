package net.challenge.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.challenge.enums.BizCodeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {

  /**
   *  0 success，1 in progress，-1 failed
   */

  private Integer code;
  /**
   * data
   */
  private Object data;
  /**
   * description
   */
  private String msg;

  /**
   * RPC data and camel transformation
   * @param typeReference
   * @param <T>
   * @return
   */
  public <T> T getData(TypeReference<T> typeReference) {
    return JSON.parseObject(JSON.toJSONString(data),typeReference);
  }

  /**
   * success without data
   *
   * @return
   */
  public static JsonData buildSuccess() {
    return new JsonData(0, null, null);
  }

  /**
   * get data in party
   *
   * @param data
   * @return
   */
  public static JsonData buildSuccess(Object data) {
    return new JsonData(0, data, null);
  }

  /**
   * description
   *
   * @param msg
   * @return
   */
  public static JsonData buildError(String msg) {
    return new JsonData(-1, null, msg);
  }


  /**
   * custome data
   *
   * @param code
   * @param msg
   * @return
   */
  public static JsonData buildCodeAndMsg(int code, String msg) {
    return new JsonData(code, null, msg);
  }

  /**
   * giv enum
   *
   * @param codeEnum
   * @return
   */
  public static JsonData buildResult(BizCodeEnum codeEnum) {
    return JsonData.buildCodeAndMsg(codeEnum.getCode(), codeEnum.getMessage());
  }
}
