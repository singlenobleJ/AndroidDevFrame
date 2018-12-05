package com.llj.basemodule.util;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * <pre>
 *     author: lilinjie
 *     time  : 2018/12/5 15:50
 *     desc  :
 * </pre>
 */
public class GlideUtils {

    private GlideUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void loadWithDefault(@NonNull Context context, @NonNull String url, @DrawableRes int error, @DrawableRes int placeholder, @NonNull ImageView imageView) {
        RequestOptions options = new RequestOptions().placeholder(placeholder).error(error);
        Glide.with(context).load(url).apply(options).into(imageView);
    }
    public static void loadWithDefault(@NonNull Context context, @NonNull String url, @NonNull ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }
}
