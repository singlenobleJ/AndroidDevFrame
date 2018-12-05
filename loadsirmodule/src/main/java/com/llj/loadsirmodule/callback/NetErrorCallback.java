package com.llj.loadsirmodule.callback;

import com.llj.loadsirmodule.R;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 14:51
 *     desc  : 网络出错反馈
 * </pre>
 */
public class NetErrorCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.loadsir_net_error;
    }
}
