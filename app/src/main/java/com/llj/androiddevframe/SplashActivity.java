package com.llj.androiddevframe;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.llj.basemodule.base.BaseActivity;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 15:07
 *     desc  :
 * </pre>
 */
public class SplashActivity extends BaseActivity {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.app_ac_splash;
    }

    @Override
    protected void initViews() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.start(SplashActivity.this);
                finish();
            }
        }, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
