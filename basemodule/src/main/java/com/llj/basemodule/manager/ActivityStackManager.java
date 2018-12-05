package com.llj.basemodule.manager;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 13:40
 *     desc  : Activity管理器
 * </pre>
 */
public final class ActivityStackManager {

    private static List<WeakReference<Activity>> sActivityList = new LinkedList<>();

    private ActivityStackManager() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Add Activity to LinkedList
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        sActivityList.add(new WeakReference<>(activity));
    }

    /**
     * Remove Activity from LinkedList
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        Iterator<WeakReference<Activity>> iterator = sActivityList.iterator();
        while (iterator.hasNext()) {
            WeakReference<Activity> refActivity = iterator.next();
            if (refActivity.get() == null) {
                iterator.remove();
                continue;
            }
            if (refActivity.get() == activity) {
                iterator.remove();
                break;
            }
        }
    }

    /**
     * Remove All Activity from LinkedList
     */
    public static void removeAllActivity() {
        Iterator<WeakReference<Activity>> iterator = sActivityList.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
    }

    /**
     * Exit Application
     */
    public static void exitApp() {
        for (WeakReference<Activity> refActivity : sActivityList) {
            if (refActivity != null && refActivity.get() != null) {
                refActivity.get().finish();
            }
        }
        sActivityList.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * Get the Stack Top Activity
     *
     * @return
     */
    public static Activity getStackTopActivity() {
        Activity topActivity = null;
        if (!sActivityList.isEmpty()) {
            WeakReference<Activity> refActivity = sActivityList.get(sActivityList.size() - 1);
            if (refActivity != null && refActivity.get() != null) {
                topActivity = refActivity.get();
            }
        }
        return topActivity;

    }
}
