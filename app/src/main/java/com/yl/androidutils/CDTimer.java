package com.yl.androidutils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * 倒计时显示类
 * Created by Administrator on 2018/3/6.
 */

public class CDTimer extends CountDownTimer {
    private TextView textView;
    private String text, finishText;

    /**
     * @param millisInFuture    总时长 单位秒
     * @param countDownInterval 倒计时间隔时长 单位秒
     * @param textView          要先显示倒计时的TextView
     * @param text              显示的格式化文本，例"%ds"
     * @param finishText        倒计时结束显示的文本
     */
    public CDTimer(int millisInFuture, int countDownInterval,
                   TextView textView, String text, String finishText) {
        super(millisInFuture * 1000, countDownInterval * 1000);
        this.textView = textView;
        this.text = text;
        this.finishText = finishText;
    }

    public CDTimer(int millisInFuture, TextView textView, String text, String finishText) {
        super(millisInFuture * 1000, 1000);
        this.textView = textView;
        this.text = text;
        this.finishText = finishText;
    }

    @Override
    public void onTick(long l) {
        textView.setText(String.format(text, l / 1000));
    }

    @Override
    public void onFinish() {
        textView.setText(finishText);
    }
}
