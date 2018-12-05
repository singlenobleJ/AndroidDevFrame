package com.llj.basemodule.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.llj.basemodule.R;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/17 11:26
 *     desc  : 基础标题栏Activity
 * </pre>
 */
public abstract class BaseTitleActivity extends BaseActivity {

    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBusiness();
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        //初始化TitleBar的控件
        mTvTitle = findViewById(R.id.tv_title);
        ImageView ivBack = findViewById(R.id.iv_back);
        if (ivBack != null) {
            ivBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

    }

    protected void setTitle(@NonNull String title) {
        if (mTvTitle != null && !TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
    }
}
