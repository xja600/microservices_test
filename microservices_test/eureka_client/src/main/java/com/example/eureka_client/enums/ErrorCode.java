package com.example.eureka_client.enums;

/**
 * @Author: XiongFeng
 * @Description: 错误码
 * @Date: Created in 9:39 2018/4/10
 */
public enum ErrorCode {

	SYSTEM_ERROR(500, "系统错误", "系统错误"),
	ERROR(501, "错误", "错误"),
	PARAMETER_CHECK_ERROR(400, "参数校验错误","参数校验错误"),
    AUTH_VALID_ERROR(701, "用户权限不足", "用户权限不足"),

    ;

    private final Integer value;
    private final String message;
    private final String log;

    ErrorCode(int value, String message, String log) {
        this.value = value;
        this.message = message;
        this.log = log;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public String getLog() {
        return log;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public String getCode() {
        return value.toString();
    }

    public static ErrorCode getByCode(Integer value) {
        for (ErrorCode _enum : values()) {
            if (_enum.getValue() == value) {
                return _enum;
            }
        }
        return null;
    }

}
