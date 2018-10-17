package com.llj.basemodule.manager;

import com.llj.basemodule.base.BaseApplication;
import com.llj.basemodule.base.IApplicationDelegate;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 15:03
 *     desc  :
 * </pre>
 */
public class ModuleManager {

    private static String[] modules = {
            "com.llj.loginmodule.LoginApplicationDelegate",
    };

    public static void initModule() {
        //反射创建IApplicationDelegate实例
        try {
            for (String className : modules) {
                Class<?> clazz = Class.forName(className);
                Object object = clazz.newInstance();
                if (object instanceof IApplicationDelegate) {
                    ((IApplicationDelegate) object).onCreate(BaseApplication.getInstance());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
