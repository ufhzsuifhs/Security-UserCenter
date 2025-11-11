package ${package.Parent}.common;

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
    USER_ALREADY_EXISTS(2002, "用户已存在"),
    PASSWORD_INCORRECT(2003, "密码错误"),
    OPERATION_ERROR(50001, "操作失败");

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
