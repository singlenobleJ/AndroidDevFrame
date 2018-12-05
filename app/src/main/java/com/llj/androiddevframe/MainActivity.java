package com.llj.androiddevframe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.llj.basemodule.base.BaseAppActivity;
import com.llj.basemodule.util.GlideUtils;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 15:08
 *     desc  :
 * </pre>
 */
public class MainActivity extends BaseAppActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.app_ac_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        ImageView imageView = findViewById(R.id.image);
        GlideUtils.loadWithDefault(this, "https://sports.eastday.com/jscss/v4/img/Sliding_img/1.jpg", imageView);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
