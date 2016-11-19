package com.cjp.os_china.ui.Main;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjp.os_china.R;

/**
 * Created by panj on 2016/11/19.
 */

public class NavigationButton extends FrameLayout {

    private ImageView mIconImg;
    private TextView mTitleTx;
    private View mDotView;

    public NavigationButton(Context context) {
        super(context);
        init();
    }

    public NavigationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NavigationButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NavigationButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_nav_button, this, true);

        mIconImg = (ImageView) findViewById(R.id.img_nav_icon);
        mTitleTx = (TextView) findViewById(R.id.img_nav_title);
        mDotView = (View) findViewById(R.id.view_red_dot);
    }

    public void setSelected(boolean selected) {
        super.setSelected(selected);
        mIconImg.setSelected(selected);
        mTitleTx.setSelected(selected);
    }

    public void showRedDot(boolean show) {
        mDotView.setVisibility(show ? VISIBLE : GONE);
    }

    public void init(@DrawableRes int resId, @StringRes int strId) {
        mIconImg.setImageResource(resId);
        mTitleTx.setText(strId);
    }
}
