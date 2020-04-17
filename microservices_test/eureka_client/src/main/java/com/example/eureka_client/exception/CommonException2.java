package com.example.eureka_client.exception;


import com.example.eureka_client.enums.ErrorCode;

import java.io.Serializable;

/**
 * @Author: wangying
 * @Description:基本异常处理
 * @Date: Created in  2018/5/14
 */
public class CommonException2 extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -2420433858545877604L;

    /**
     * 错误编码
     */
    private String errorCode;

    /**
     * 消息是否为属性文件中的Key
     */
    private boolean propertiesKey = true;

    /**
     * 构造一个基本异常.
     *
     * @param message
     *            信息描述
     */
    public CommonException2(String message)
    {
        this(ErrorCode.SYSTEM_ERROR.getCode(), message, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     */
    public CommonException2(ErrorCode errorCode, Throwable cause)
    {
        this(errorCode.getCode(), errorCode.getMessage(), cause, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public CommonException2(String errorCode, String message)
    {
        this(errorCode, message, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     */
    public CommonException2(ErrorCode errorCode)
    {
        this(errorCode.getCode(), errorCode.getMessage(), true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public CommonException2(ErrorCode errorCode, String message)
    {
        this(errorCode.getCode(), message, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public CommonException2(String errorCode, String message, Throwable cause)
    {
        this(errorCode, message, cause, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public CommonException2(ErrorCode errorCode, String message, Throwable cause)
    {
        this(errorCode.getCode(), message, cause, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     * @param propertiesKey
     *            消息是否为属性文件中的Key
     */
    public CommonException2(String errorCode, String message, boolean propertiesKey)
    {
        super(message);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public CommonException2(String errorCode, String message, Throwable cause, boolean propertiesKey)
    {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    /**
     * 构造一个基本异常.
     *
     * @param message
     *            信息描述
     * @param cause
     *            根异常类（可以存入任何异常）
     */
    public CommonException2(String message, Throwable cause)
    {
        super(message, cause);
        this.setErrorCode(ErrorCode.SYSTEM_ERROR.getCode());
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey()
    {
        return propertiesKey;
    }

    public ErrorCode getErrorEnum()
    {
        return ErrorCode.getByCode(Integer.valueOf(this.getErrorCode()));
    }

    public void setPropertiesKey(boolean propertiesKey)
    {
        this.propertiesKey = propertiesKey;
    }
}
