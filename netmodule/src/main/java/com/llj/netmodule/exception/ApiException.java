package com.llj.netmodule.exception;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/18 13:37
 *     desc  :
 * </pre>
 */
public class ApiException extends RuntimeException {
    private int code;
    private String msg;

    public ApiException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    public ApiException(String message, int code, Throwable cause) {
        super(message, cause);
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
