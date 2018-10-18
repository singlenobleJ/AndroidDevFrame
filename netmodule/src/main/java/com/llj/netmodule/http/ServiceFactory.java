package com.llj.netmodule.http;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/18 13:39
 *     desc  :
 * </pre>
 */
public final class ServiceFactory {

    public static <T> T createService(Class<T> clazz) {
        return RetrofitFactory.getRetrofit().create(clazz);
    }
}
