package com.cjp.os_china.ui.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cjp.os_china.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by panj on 2016/11/19.
 */

public class NavFragment extends Fragment {

    @Bind(R.id.nav_item_news)
    NavigationButton mNewsBtn;

    @Bind(R.id.nav_item_tweet)
    NavigationButton mTweetBtn;

    @Bind(R.id.nav_item_explore)
    NavigationButton mExploreBtn;

    @Bind(R.id.nav_item_me)
    NavigationButton mMeBtn;

    @Bind(R.id.nav_item_tweet_pub)
    ImageView mTweetPubBtn;

    View mSelectedBtn = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        mNewsBtn.init(R.drawable.tab_icon_new, R.string.main_tab_name_news);
        mTweetBtn.init(R.drawable.tab_icon_tweet, R.string.main_tab_name_tweet);
        mExploreBtn.init(R.drawable.tab_icon_explore, R.string.main_tab_name_explore);
        mMeBtn.init(R.drawable.tab_icon_me, R.string.main_tab_name_my);
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
        if (v == mNewsBtn) {
            mNewsBtn.setSelected(true);
        } else if (v == mTweetBtn) {
            mTweetBtn.setSelected(true);
        } else if (v == mExploreBtn) {
            mExploreBtn.setSelected(true);
        } else if (v == mMeBtn) {
            mMeBtn.setSelected(true);
        }
    }
}
