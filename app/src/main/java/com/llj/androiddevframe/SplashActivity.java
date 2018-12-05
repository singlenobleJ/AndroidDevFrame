package com.llj.androiddevframe;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.llj.basemodule.base.BaseAppActivity;

import java.lang.ref.WeakReference;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 15:07
 *     desc  :
 * </pre>
 */
public class SplashActivity extends BaseAppActivity {
    public static final int MESSAGE_WHAT = 666;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.app_ac_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {

    }

    @Override
    public void doBusiness() {
        mHandler = new TimerTaskHandler(this);
        mHandler.sendEmptyMessageDelayed(MESSAGE_WHAT, 3000);

    }

    private static class TimerTaskHandler extends Handler {
        private WeakReference<Activity> refActivity;

        public TimerTaskHandler(SplashActivity activity) {
            refActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            if (MESSAGE_WHAT == what) {
                if (refActivity != null && refActivity.get() != null) {
                    MainActivity.start(refActivity.get());
                    refActivity.get().finish();
                }
            }
        }
    }

    @Override
    public void onWidgetClick(View view) {

    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();

    }
}
