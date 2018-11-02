package com.llj.upgrademodule;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/10/31 14:10
 *     desc  : App版本升级提示对话框
 * </pre>
 */
public class UpgradeDialog extends Dialog {
    public UpgradeDialog(@NonNull Context context) {
        super(context);
    }

    public UpgradeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected UpgradeDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrade_dialog_app_upgrade);
    }
}
