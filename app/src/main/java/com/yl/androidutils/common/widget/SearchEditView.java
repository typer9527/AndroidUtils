package com.yl.androidutils.common.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cc.ahxb.hlg.R;
import cc.ahxb.hlg.common.utils.KeyBoardUtils;

/**
 * 自定义搜索控件
 * Created by Luke on 2017/11/23.
 */

public class SearchEditView extends RelativeLayout implements
        View.OnTouchListener, View.OnClickListener {

    private EditText searchEdit;
    private Button clearButton;
    private TextView cancelSearch;
    private onSearchListener listener;

    public SearchEditView(Context context) {
        this(context, null);
    }

    public SearchEditView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchEditView(Context context, @Nullable AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_search_layout, this);
        searchEdit = findViewById(R.id.search_edit);
        clearButton = findViewById(R.id.clear_button);
        cancelSearch = findViewById(R.id.cancel_search);
        setViewListener();
    }

    public void setSearchHint(String hintText) {
        searchEdit.setHint(hintText);
    }

    public void isCancelSearchGone(boolean isGone) {
        if (isGone)
            cancelSearch.setVisibility(GONE);
        else
            cancelSearch.setVisibility(VISIBLE);
    }

    public void seOnSearchListener(onSearchListener listener) {
        this.listener = listener;
    }

    public void setSearchText(String text) {
        searchEdit.setText(text);
        clearButton.setVisibility(VISIBLE);
    }

    private void setViewListener() {
        searchEdit.setOnTouchListener(this);
        // 软键盘搜索监听
        searchEdit.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER &&
                        event.getAction() == KeyEvent.ACTION_UP) {
                    if (listener != null) {
                        KeyBoardUtils.toggleSoftKeyboard(getContext());
                        listener.onSearchClick(searchEdit.getText().toString());
                    }
                }
                return false;
            }
        });
        clearButton.setOnClickListener(this);
        cancelSearch.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        clearButton.setVisibility(VISIBLE);
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear_button:
                searchEdit.setText("");
                KeyBoardUtils.toggleSoftKeyboard(getContext());
                // 获取焦点
                searchEdit.requestFocus();
                break;
            case R.id.cancel_search:
                if (listener != null) {
                    listener.onCancelClick();
                }
                break;
            default:
        }
    }

    public interface onSearchListener {
        void onSearchClick(String searchKey);

        void onCancelClick();
    }
}
