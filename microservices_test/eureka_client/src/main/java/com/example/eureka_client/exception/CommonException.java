package com.example.eureka_client.exception;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangying
 * @Description:基本异常处理
 * @Date: Created in  2018/5/14
 */
public class CommonException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -2420433858545877604L;

    private String code;
    private List errorInfo;

    public CommonException(String[] constants, List errorInfo, String... args) {
        super(String.format(constants[1], args));
        this.code = constants[0];
        this.errorInfo = errorInfo;
    }
    public CommonException() {
        super("空指针异常");
    }
    public CommonException(String[] constants, Object errorInfo, String... args) {
        super(String.format(constants[1], args));
        this.code = constants[0];
        this.errorInfo = new ArrayList();
        this.errorInfo.add(errorInfo);
    }



    public CommonException(String[] constants, String... args) {
        super(String.format(constants[1], args));
        this.code = constants[0];
    }

    public CommonException(String message) {
        super(message);
        this.code = "99";
    }
    public CommonException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public CommonException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }



    public final String getCode() {
        return this.code;
    }

    public List getErrorInfo() {
        return this.errorInfo;
    }

    public void setErrorInfo(List errorInfo) {
        this.errorInfo = errorInfo;
    }
}
