package com.llj.basemodule.util;

import com.llj.basemodule.base.BaseApplication;
import com.meituan.android.walle.WalleChannelReader;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/31 11:27
 *     desc  :
 * </pre>
 */
public final class ChannelUtils {
    private ChannelUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Get channel name
     *
     * @return
     */
    public static String getChannelName() {
        return WalleChannelReader.getChannel(BaseApplication.getInstance().getApplicationContext());
    }
}
