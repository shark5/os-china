package com.cjp.os_china.ui.main;

import android.view.View;
import android.widget.ImageView;

import com.cjp.os_china.R;
import com.cjp.os_china.base.AppDefs;
import com.cjp.os_china.base.BaseFragment;
import com.cjp.os_china.event.ActionEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by panj on 2016/11/19.
 */

public class NavFragment extends BaseFragment {

    @BindView(R.id.nav_item_news)
    NavigationButton mNewsBtn;

    @BindView(R.id.nav_item_tweet)
    NavigationButton mTweetBtn;

    @BindView(R.id.nav_item_explore)
    NavigationButton mExploreBtn;

    @BindView(R.id.nav_item_me)
    NavigationButton mMeBtn;

    @BindView(R.id.nav_item_tweet_pub)
    ImageView mTweetPubBtn;

    View mSelectedBtn = null;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_nav;
    }

    protected void initViews(View view) {
        mNewsBtn.init(R.drawable.tab_icon_new, R.string.main_tab_name_news);
        mTweetBtn.init(R.drawable.tab_icon_tweet, R.string.main_tab_name_tweet);
        mExploreBtn.init(R.drawable.tab_icon_explore, R.string.main_tab_name_explore);
        mMeBtn.init(R.drawable.tab_icon_me, R.string.main_tab_name_my);
        mNewsBtn.setSelected(true);
        mSelectedBtn = mNewsBtn;
    }

    @OnClick({R.id.nav_item_news, R.id.nav_item_tweet, R.id.nav_item_explore, R.id.nav_item_me})
    public void navButtonClick(View v) {
        navigateTo(v);
    }

    @OnClick(R.id.nav_item_tweet_pub)
    public void publishButtonClick() {

    }

    private void navigateTo(View v) {
        if (v == mSelectedBtn) {
            return;
        }
        if (mSelectedBtn != null) {
            ((NavigationButton) mSelectedBtn).setSelected(false);
        }
        mSelectedBtn = v;
        int which = 0;
        if (v == mNewsBtn) {
            mNewsBtn.setSelected(true);
            which = AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_INFORMATION;
        } else if (v == mTweetBtn) {
            mTweetBtn.setSelected(true);
            which = AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_BLOG;
        } else if (v == mExploreBtn) {
            mExploreBtn.setSelected(true);
            which = AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_ANSWER;
        } else if (v == mMeBtn) {
            mMeBtn.setSelected(true);
            which = AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_ACTIVTTY;
        }
        EventBus.getDefault().post(new ActionEvent(which, ActionEvent.EVENT_MAIN_ACTIVITY_NAVIGATE_TO));
    }
}
