package com.llj.basemodule.util;

import java.util.List;
import java.util.Map;

/**
 * @author: lilinjie
 * @date: 2019/5/15 9:23 AM
 * @description:
 */
public final class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException("u can not instantiation me ...");
    }

    /**
     * Returns true if the data is null or 0-length.
     *
     * @param data the list to be checked
     * @return true if data is null or 0-length
     */
    public static <T> boolean isEmpty(List<T> data) {
        return data == null || data.size() == 0;
    }

    /**
     * Returns true if the data is null or 0-length.
     *
     * @param data the map to be checked
     * @return true if data is null or 0-length
     */
    public static <K, V> boolean isEmpty(Map<K, V> data) {
        return data == null || data.size() == 0;
    }

}