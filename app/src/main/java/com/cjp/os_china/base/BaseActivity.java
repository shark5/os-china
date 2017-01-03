package com.cjp.os_china.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cjp.os_china.event.IEventBus;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by panj on 2016/11/19.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        unbinder = ButterKnife.bind(this);

        if (this instanceof IEventBus) {
            EventBus.getDefault().register(this);
        }
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ApplicationDelegate.getInstance().setTopActivity(this);
    }

    @Override
    protected void onDestroy() {
        if (this instanceof IEventBus) {
            EventBus.getDefault().unregister(this);
        }
        unbinder.unbind();
        super.onDestroy();
    }

    protected void initViews() {

    }

    abstract protected int getLayoutResId();
}
