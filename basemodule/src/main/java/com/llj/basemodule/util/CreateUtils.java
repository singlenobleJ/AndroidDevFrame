package com.llj.basemodule.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 17:52
 *     desc  :
 * </pre>
 */
public class CreateUtils {

    public static <T> T getT(Object obj, int index) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        try {
            return ((Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[index]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
