package com.yl.androidutils.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 可被ScrollView 嵌套的ListView
 * Created by xuyougen on 2018/3/6.
 */

public class NestedListView extends ListView {
    public NestedListView(Context context) {
        this(context, null);
    }

    public NestedListView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public NestedListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
