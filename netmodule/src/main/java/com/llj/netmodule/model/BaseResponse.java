package com.llj.netmodule.model;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 13:35
 *     desc  :
 * </pre>
 */
public class BaseResponse<T> {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
