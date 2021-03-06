package com.cjp.os_china.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiongbull.jlog.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by panj on 2016/11/19.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;
    protected Logger mLogger;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLogger = MyApplication.getLogger();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutResId(), container, false);
        onPreBindViews(view);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected void initViews(View view) {
    }

    protected void initData() {
    }

    abstract protected int getLayoutResId();

    protected void onPreBindViews(View root) {
    }
}
