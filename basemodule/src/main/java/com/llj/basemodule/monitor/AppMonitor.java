package com.llj.basemodule.monitor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lilinjie
 * @date: 2019-08-21 09:29
 * @description: Application前后台状态监控
 */
public class AppMonitor {
    private List<AppStatusListener> mListeners;
    private boolean mInitialized = false;
    private int mActiveActivityCount = 0;
    private int mAliveActivityCount = 0;

    private AppMonitor() {
        mListeners = new ArrayList<>();
    }

    public static AppMonitor getInstance() {
        return AppMonitorHolder.INSTANCE;
    }

    private static class AppMonitorHolder {
        private static final AppMonitor INSTANCE = new AppMonitor();
    }

    /**
     * 监控初始化,此方法需要在MainThread中调用,且只需要调用一次.
     *
     * @param context {@code context}
     */
    public void init(Context context) {
        if (mInitialized) {
            return;
        }
        registerAppLifecycle(context);
        mInitialized = true;
    }

    private void registerAppLifecycle(Context context) {
        Application application = (Application) context.getApplicationContext();
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                mAliveActivityCount++;
            }

            @Override
            public void onActivityStarted(Activity activity) {
                mActiveActivityCount++;
                notifyAppStatusChanged();
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                mActiveActivityCount--;
                notifyAppStatusChanged();
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                mActiveActivityCount--;
                notifyAppDestroyed();
            }
        });
    }

    public interface AppStatusListener {

        /**
         * Application处于前台
         */
        void onAppForeground();

        /**
         * Application处于后台
         */
        void onAppBackground();

        /**
         * Application Destroyed
         */
        void onAppDestroyed();
    }


    /**
     * 注册Application状态监听器
     *
     * @param listener {@code listener}
     */
    public void register(AppStatusListener listener) {
        if (!mListeners.contains(listener) && listener != null) {
            mListeners.add(listener);
        }
    }

    /**
     * 解除监听器
     *
     * @param listener {@code listener}
     */
    public void unregister(AppStatusListener listener) {
        mListeners.remove(listener);
    }

    /**
     * Application 前后台状态改变通知监听器
     */
    private void notifyAppStatusChanged() {
        for (AppStatusListener listener : mListeners) {
            if (mActiveActivityCount > 0) {
                listener.onAppForeground();
            } else {
                listener.onAppBackground();
            }

        }
    }

    /**
     * 通知监听器Application UI Destroyed
     */
    private void notifyAppDestroyed() {
        if (mAliveActivityCount <= 0) {
            for (AppStatusListener listener : mListeners) {
                listener.onAppDestroyed();
            }
        }
    }

    /**
     * App是否在运行
     *
     * @return {@code true} alive {@code false} died
     */
    public boolean isAppAlive() {
        return mAliveActivityCount > 0;
    }

    /**
     * Application 是否在前台
     *
     * @return {@code true} foreground {@code false} background
     */
    public boolean isAppForeground() {
        return mActiveActivityCount > 0;
    }

    /**
     * Application 是否在后台
     *
     * @return {@code true} background {@code false} foreground
     */
    public boolean isAppBackground() {
        return mActiveActivityCount <= 0;
    }
}
