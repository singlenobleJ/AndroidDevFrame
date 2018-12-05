package com.llj.basemodule.base;

import android.os.Bundle;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 11:26
 *     desc  : 基础Activity
 * </pre>
 */
public abstract class BaseAppActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBusiness();
    }

}
