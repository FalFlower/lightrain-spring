package com.spring.lightrain.enums;

public enum ResultEnum {
    //返回前端的消息
    LOGIN_FAILED(10,"登陆失败，请检查账户或密码是否填写正确"),
    USER_NO_LOGIN(11,"用户尚未登陆，请先登录"),
    LOGOUT_FAILED(12,"注销失败，您已注销"),
    REGISTER_FAILED(13,"注册失败，该号码已注册，请去登录"),
    REGISTER_FAILED_BY_PARAM(14,"注册失败，该号码已注册，请去登录"),
    UPDATE_FAILED(15,"更新个人信息失败，请仔细检查传递参数");
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
