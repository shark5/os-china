package com.cjp.os_china.ui.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cjp.os_china.R;
import com.cjp.os_china.base.BaseListFragment;
import com.cjp.os_china.entity.Banner;
import com.cjp.os_china.entity.BannerResult;
import com.cjp.os_china.widget.pullrecycler.BaseViewHolder;
import com.cjp.os_china.widget.pullrecycler.PullRecycler;

import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by panj on 2016/12/6.
 */
public class InformationFragment extends BaseListFragment<InformationPresenterImpl, InformationModel, String> implements InformationContract.View {

    private static final String TAG = "InformationFragment";
    private HeaderViewHolder mBannerHolder;

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.item_information_list_header_view, null, false);
        mBannerHolder = new HeaderViewHolder(headerView);
        setHeaderView(mBannerHolder);
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_information_list, parent, false);
        return new InformationListViewHolder(view);
    }

    @Override
    protected void initData() {
        super.initData();
        getBannerList();
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

    private void getBannerList() {
        if (mPresenter != null) {
            mPresenter.getBannerList();
        }
    }

    @Override
    public void setBannerList(BannerResult result) {
        mLogger.d(result.toString());
        mBannerHolder.setItems(result.getItems());
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
        List<Banner> mItems;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            mContentBanner = (BGABanner) itemView.findViewById(R.id.banner_guide_content);
            mContentBanner.setAdapter(new BGABanner.Adapter() {
                @Override
                public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                    Banner item = (Banner) model;
                    ImageView imageView = (ImageView) view.findViewById(R.id.news_iv);
                    TextView titleTv = (TextView) view.findViewById(R.id.news_title_tv);
                    titleTv.setText(item.getName());
                    Glide.with(getActivity()).load(item.getImg()).into(imageView);
                }
            });
            mContentBanner.setOnItemClickListener(new BGABanner.OnItemClickListener() {
                @Override
                public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
                    mLogger.d("点击了第" + (position + 1) + "页");
                }
            });
        }

        @Override
        public void onBindViewHolder(int position) {
        }

        @Override
        public void onItemClick(View view, int position) {

        }

        public void setItems(List<Banner> items) {
            this.mItems = items;
            mContentBanner.setData(R.layout.item_news_banner, items, null);

        }

    }
}
