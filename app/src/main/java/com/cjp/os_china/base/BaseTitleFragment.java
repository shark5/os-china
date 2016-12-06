package com.cjp.os_china.base;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjp.os_china.R;

import butterknife.BindView;

/**
 * Created by panj on 2016/11/27.
 */

public abstract class BaseTitleFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView mTitleTv;

    @BindView(R.id.img_left)
    ImageView mLeftImg;

    @BindView(R.id.img_right)
    ImageView mRightImg;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_base_title;
    }

    @Override
    protected void onPreBindViews(View root) {
        super.onPreBindViews(root);
        ViewStub stub = (ViewStub) root.findViewById(R.id.lay_content);
        stub.setLayoutResource(getContentLayoutId());
        stub.inflate();
    }

    protected void setTitle(String title) {
        if (mTitleTv != null) {
            mTitleTv.setText(title);
        }
    }

    protected void setTitle(int resId) {
        if (mTitleTv != null && resId > 0) {
            mTitleTv.setText(getString(resId));
        }
    }

    protected void setRightImageView(int resId) {
        if (mRightImg != null) {
            mRightImg.setImageResource(resId);
            mRightImg.setVisibility(View.VISIBLE);
        }
    }

    protected void setLeftImageView(int resId) {
        if (mLeftImg != null) {
            mLeftImg.setImageResource(resId);
            mLeftImg.setVisibility(View.VISIBLE);
        }
    }

    abstract protected int getContentLayoutId();

    abstract protected int getTitleRes();

    protected int getRightIconRes() {
        return 0;
    }

    protected int getLeftIconRes() {
        return 0;
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        setTitle(getTitleRes());
        setRightImageView(getRightIconRes());
        setLeftImageView(getRightIconRes());
    }
}
