package com.example.eureka_client.exception;


import com.example.eureka_client.enums.ErrorCode;

public class AsyncMethodLockException extends CommonException2{

    private static final long serialVersionUID = -2420433858545877604L;

    public AsyncMethodLockException(String message) {
        super(message);
    }

    public AsyncMethodLockException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public AsyncMethodLockException(String errorCode, String message) {
        super(errorCode, message);
    }

    public AsyncMethodLockException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AsyncMethodLockException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public AsyncMethodLockException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public AsyncMethodLockException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public AsyncMethodLockException(String errorCode, String message, boolean propertiesKey) {
        super(errorCode, message, propertiesKey);
    }

    public AsyncMethodLockException(String errorCode, String message, Throwable cause, boolean propertiesKey) {
        super(errorCode, message, cause, propertiesKey);
    }

    public AsyncMethodLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
