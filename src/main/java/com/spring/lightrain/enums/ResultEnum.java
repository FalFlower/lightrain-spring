package com.spring.lightrain.enums;

public enum ResultEnum {
    //返回前端的消息
    LOGIN_FAILED(110,"登陆失败，请检查账户或密码是否填写正确"),
    USER_NO_LOGIN(111,"用户尚未登陆，请先登录"),
    LOGOUT_FAILED(112,"注销失败，您已注销"),
    REGISTER_FAILED(113,"注册失败，该号码已注册，请去登录"),
    REGISTER_FAILED_BY_PARAM(114,"注册失败，该号码已注册，请去登录"),
    UPDATE_FAILED(115,"更新个人信息失败，请仔细检查传递参数"),
    LOGIN_REPEAT(116,"已登录，请勿重复登陆"),
    UPDATE_USER_RELATIONSHIP_FAILED(117,"更新用户关系失败"),
    GET_USER_RELATIONSHIP_FAILED(118,"获取用户关系失败"),
    USER_EXITS(119,"用户已存在，请勿重复注册"),
    FOLLOW_USER_RELATIONSHIP_FAILED(120,"关注失败，用户ID错误或者用户不存在"),
    UN_FOLLOW_USER_RELATIONSHIP_FAILED(121,"取消关注失败，用户ID错误或者用户不存在"),
    UPDATE_VIDEO_FAILED(200,"上传视频失败"),
    UPDATE_VIDEO_EVALUATE_FAILED(201,"更新用户视频评分失败"),
    VIDEO_EVALUATE_EXITS(202,"用户已评价，请勿重复评价"),
    UPDATE_UV_FAILED(202,"尚未购买，请先去购买"),
    VIDEO_TIME_ERROR(203,"传递用户观看时长错误"),
    MATCH_FAILED(300,"无搜索结果");
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
