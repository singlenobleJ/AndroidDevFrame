package com.llj.loadsirmodule.callback;

import com.llj.loadsirmodule.R;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 14:53
 *     desc  : 服务器端错误反馈
 * </pre>
 */
public class ServerErrorCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.loadsir_server_error;
    }
}
