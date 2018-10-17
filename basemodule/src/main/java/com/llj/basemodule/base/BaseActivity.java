package com.llj.basemodule.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 11:26
 *     desc  :
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        initViews();
    }

    @LayoutRes
    protected abstract int provideLayoutId();

    protected abstract void initViews();
}
