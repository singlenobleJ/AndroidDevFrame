package com.llj.androiddevframe;

import android.content.Context;
import android.content.Intent;

import com.llj.basemodule.base.BaseActivity;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 15:08
 *     desc  :
 * </pre>
 */
public class MainActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.app_ac_main;
    }

    @Override
    protected void initViews() {

    }
}
