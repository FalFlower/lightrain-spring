package com.spring.lightrain.utils;

import com.spring.lightrain.VO.ResultVO;

public class ResultVOUtil  {
    private static Integer SUCCESS=100;
    public static ResultVO success(Object object){
        return new ResultVO(SUCCESS,"success",object);
    }

    public static ResultVO success(){
        return new ResultVO(SUCCESS,"success",null);
    }

    public static ResultVO error(Integer code,String msg){
        return new ResultVO(code,msg,null);
    }
}
