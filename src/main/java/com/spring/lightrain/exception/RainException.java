package com.spring.lightrain.exception;

import com.spring.lightrain.enums.ResultEnum;

public class RainException extends RuntimeException {
    private Integer code;
    private String message;
    public RainException( Integer code,String message) {
        super(message);
        this.code = code;
    }

    public RainException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
