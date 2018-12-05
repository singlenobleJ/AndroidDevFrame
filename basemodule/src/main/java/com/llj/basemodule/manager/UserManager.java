package com.llj.basemodule.manager;

import com.llj.basemodule.base.BaseApplication;
import com.llj.basemodule.model.User;
import com.llj.basemodule.util.ACacheUtils;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 14:22
 *     desc  : 用户信息管理类
 * </pre>
 */
public class UserManager {
    private static User sUser;

    static {
        ACacheUtils cache = ACacheUtils.get(BaseApplication.getInstance().getApplicationContext(), "user_info");
        sUser = (User) cache.getAsObject("user");
    }

    public static boolean isLogin() {
        if (sUser != null) {
            return sUser.isLogin();
        } else {
            return false;
        }
    }

    public static String getUserId() {
        if (sUser != null) {
            return sUser.getId();
        } else {
            return "";
        }
    }

    public static String getUserName() {
        if (sUser != null) {
            return sUser.getName();
        } else {
            return "";
        }
    }

    public static String getUserAvatar() {
        if (sUser != null) {
            return sUser.getAvatar();
        } else {
            return "";
        }
    }


    public static void setUserLogin(User user) {
        ACacheUtils cache = ACacheUtils.get(BaseApplication.getInstance().getApplicationContext(), "user_info");
        cache.put("user", user);
        sUser = user;

    }

    public static void setUserLogout() {
        ACacheUtils cache = ACacheUtils.get(BaseApplication.getInstance().getApplicationContext(), "user_info");
        if (sUser != null) {
            sUser.reset();
            cache.put("user", sUser);
            sUser = null;
        }

    }

}
