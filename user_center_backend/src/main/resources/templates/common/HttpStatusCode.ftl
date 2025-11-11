package ${package.Parent}.common;

/**
 * HTTP 状态码枚举类 （请求是否成功）
 */
public enum HttpStatusCode {

    // 1xx 信息性状态码
    CONTINUE(100, "继续"),
    SWITCHING_PROTOCOLS(101, "切换协议"),
    PROCESSING(102, "处理进行中"),

    // 2xx 成功状态码
    OK(200, "成功"),
    CREATED(201, "已创建"),
    ACCEPTED(202, "已接受"),
    NO_CONTENT(204, "无内容"),
    RESET_CONTENT(205, "重置内容"),
    PARTIAL_CONTENT(206, "部分内容"),

    // 3xx 重定向状态码
    MOVED_PERMANENTLY(301, "永久移动"),
    FOUND(302, "找到"),
    SEE_OTHER(303, "查看其他"),
    NOT_MODIFIED(304, "未修改"),
    USE_PROXY(305, "使用代理"),
    TEMPORARY_REDIRECT(307, "临时重定向"),
    PERMANENT_REDIRECT(308, "永久重定向"),

    // 4xx 客户端错误状态码
    BAD_REQUEST(400, "错误请求"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到"),
    METHOD_NOT_ALLOWED(405, "方法不允许"),
    NOT_ACCEPTABLE(406, "不可接受"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "冲突"),
    GONE(410, "已删除"),
    LENGTH_REQUIRED(411, "需要内容长度"),
    PRECONDITION_FAILED(412, "先决条件失败"),
    PAYLOAD_TOO_LARGE(413, "请求实体过大"),
    URI_TOO_LONG(414, "请求URI过长"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),
    RANGE_NOT_SATISFIABLE(416, "无法满足请求范围"),
    EXPECTATION_FAILED(417, "预期失败"),
    I_AM_A_TEAPOT(418, "我是一个茶壶"),

    // 5xx 服务器错误状态码
    INTERNAL_SERVER_ERROR(500, "内部服务器错误"),
    NOT_IMPLEMENTED(501, "未实现"),
    BAD_GATEWAY(502, "错误网关"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP版本不支持");

    private final int code;
    private final String message;

    HttpStatusCode(int code, String message) {
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
