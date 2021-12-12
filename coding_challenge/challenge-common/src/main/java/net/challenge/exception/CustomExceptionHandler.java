package net.challenge.exception;


import lombok.extern.slf4j.Slf4j;
import net.challenge.util.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handler(Exception e) {
        if (e instanceof BizException) {
            BizException bizException  = (BizException) e;
            log.error("[Business Exception {}]",e);
            return JsonData.buildCodeAndMsg(bizException.getCode(),bizException.getMsg());
        } else {
            log.error("[System Exception {}]",e);
            return JsonData.buildError("System Error，unknown");
        }


    }

}
