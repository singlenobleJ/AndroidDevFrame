package com.llj.basemodule.widget.recyclerview;


/**
 * Created by LLJ on 18/12/07.
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
