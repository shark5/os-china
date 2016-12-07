package com.cjp.os_china.ui.news;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjp.os_china.R;
import com.cjp.os_china.base.BaseListFragment;
import com.cjp.os_china.widget.pullrecycler.BaseViewHolder;
import com.cjp.os_china.widget.pullrecycler.PullRecycler;

import java.util.Arrays;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by panj on 2016/12/6.
 */
public class InformationFragment extends BaseListFragment {

    private static final String TAG = "InformationFragment";

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_information_list_header_view, null, false);
        setHeaderView(new HeaderViewHolder(headerView));
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_information_list, parent, false);
        return new InformationListViewHolder(view);
    }

    @Override
    public void onRefresh(int action) {
        if (action == PullRecycler.ACTION_PULL_TO_REFRESH) {
            mDataList.clear();
        }

        mPullRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    mDataList.add("Title:" + i);
                }
                mAdapter.notifyDataSetChanged();
                mPullRecycler.onRefreshCompleted();
                if (mDataList.size() > 50) {
                    mPullRecycler.enableLoadMore(false);
                } else {
                    mPullRecycler.enableLoadMore(true);
                }
            }
        }, 3000);
    }

    class InformationListViewHolder extends BaseViewHolder {

        TextView mTitleTv;
        TextView mDesTv;

        public InformationListViewHolder(View itemView) {
            super(itemView);
            mDesTv = (TextView) itemView.findViewById(R.id.info_title_tv);
            mTitleTv = (TextView) itemView.findViewById(R.id.des_tv);
        }

        @Override
        public void onBindViewHolder(int position) {
        }

        @Override
        public void onItemClick(View view, int position) {

        }

    }

    class HeaderViewHolder extends BaseViewHolder {

        BGABanner mContentBanner;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mContentBanner = (BGABanner) itemView.findViewById(R.id.banner_guide_content);
            mContentBanner.setAdapter(new BGABanner.Adapter() {
                @Override
                public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                    ((ImageView)view).setImageResource((int)model);
                }
            });
            mContentBanner.setData(Arrays.asList(R.drawable.tab_icon_tweet, R.drawable.tab_icon_tweet, R.drawable.tab_icon_tweet), null);
            mContentBanner.setOnItemClickListener(new BGABanner.OnItemClickListener() {
                @Override
                public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
                    Log.i(TAG, "点击了第" + (position + 1) + "页");
                }
            });
        }

        @Override
        public void onBindViewHolder(int position) {
        }

        @Override
        public void onItemClick(View view, int position) {

        }

    }
}
