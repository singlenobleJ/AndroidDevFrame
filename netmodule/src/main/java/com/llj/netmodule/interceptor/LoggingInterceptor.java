package com.llj.netmodule.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/18 13:36
 *     desc  : 网络层日志拦截器
 * </pre>
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
