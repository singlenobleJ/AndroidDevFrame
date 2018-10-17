package com.llj.basemodule.base;

import android.app.Application;

import com.llj.basemodule.manager.ModuleManager;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 11:26
 *     desc  :
 * </pre>
 */
public class BaseApplication extends Application {
    private static BaseApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        ModuleManager.initModule();
    }


    public static BaseApplication getInstance() {
        return sInstance;
    }
}
