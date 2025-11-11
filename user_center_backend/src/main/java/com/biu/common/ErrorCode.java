package com.biu.common;

/**
 * 响应码（数据）
 */
public enum ErrorCode {

    SUCCESS(0, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NOT_LOGIN_ERROR(40100, "未登录"),
    NO_AUTH_ERROR(40101, "无权限"),
    NOT_FOUND_ERROR(40400, "请求数据不存在"),
    FORBIDDEN_ERROR(40300, "禁止访问"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    DATABASE_ERROR(1001, "数据库错误"),
    INVALID_REQUEST(1002, "无效请求"),
    USER_NOT_FOUND(2001, "用户未找到"),
    USER_NULL(2004,"用户名或者密码不能为空"),
    USER_ALREADY_EXISTS(2002, "用户已存在"),
    PASSWORD_INCORRECT(2003, "密码错误"),
    USER_PASSWORD_INCORRECT(2005,"用户名或者密码错误"),
    OPERATION_ERROR(50001, "操作失败"),
    TOKEN_EXPIRE(3001,"token令牌已过期，请重新登录"),
    TOKEN_ERROR(3002,"缺少或格式错误的Token"),
    DATA_ALREADY_EXISTS(3003,"数据已存在"),
    TOKEN_KICKED(3004,"该账号设备上限，请重新登录"),
    LOGIN_FAILED(3005,"oauth登陆失败"),
    REFRESH_TOKEN_EXPIRE(3006,"Refresh过期"),
    TOKEN_INVALID(3007,"Token无效"),
    USER_KICKED(3008,"用户被踢")
    ;
    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
