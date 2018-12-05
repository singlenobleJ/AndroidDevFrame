package com.llj.loadsirmodule.callback;

import com.llj.loadsirmodule.R;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 14:49
 *     desc  : 加载中反馈
 * </pre>
 */
public class LoadingCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.loadsir_loading;
    }
}
