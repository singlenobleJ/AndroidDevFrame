package com.llj.basemodule.manager;

import org.greenrobot.eventbus.EventBus;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 13:31
 *     desc  : EventBus封装
 * </pre>
 */
public final class EventBusManager {
    private EventBusManager() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void postSticky(Object event) {
        EventBus.getDefault().postSticky(event);
    }

    public static void removeStickyEvent(Object event) {
        EventBus.getDefault().removeStickyEvent(event);
    }

    public static void removeAllStickyEvents() {
        EventBus.getDefault().removeAllStickyEvents();
    }

}
