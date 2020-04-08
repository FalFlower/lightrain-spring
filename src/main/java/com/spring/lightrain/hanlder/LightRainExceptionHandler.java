package com.spring.lightrain.hanlder;

import com.spring.lightrain.VO.ResultVO;
import com.spring.lightrain.exception.RainException;
import com.spring.lightrain.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class LightRainExceptionHandler {
//异常拦截
    @ExceptionHandler(value = RainException.class)
    @ResponseBody
    public ResultVO handlerSellerException(RainException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

}
