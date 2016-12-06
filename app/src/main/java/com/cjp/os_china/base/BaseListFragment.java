package com.cjp.os_china.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cjp.os_china.R;
import com.cjp.os_china.widget.pullrecycler.BaseListAdapter;
import com.cjp.os_china.widget.pullrecycler.BaseViewHolder;
import com.cjp.os_china.widget.pullrecycler.DividerItemDecoration;
import com.cjp.os_china.widget.pullrecycler.ILayoutManager;
import com.cjp.os_china.widget.pullrecycler.MyLinearLayoutManager;
import com.cjp.os_china.widget.pullrecycler.PullRecycler;

import java.util.ArrayList;

/**
 * Created by Stay on 8/3/16.
 * Powered by www.stay4it.com
 */
public abstract class BaseListFragment<T> extends BaseFragment implements PullRecycler.OnRecyclerRefreshListener {
    protected BaseListAdapter mAdapter;
    protected ArrayList<T> mDataList = new ArrayList<>();
    protected PullRecycler mPullRecycler;

    protected int getLayoutResId() {
        return R.layout.fragment_base_list;
    }

    protected void initViews(View view) {
        mPullRecycler = (PullRecycler) view.findViewById(R.id.pullRecycler);
        setUpAdapter();
        mPullRecycler.setOnRefreshListener(this);
        mPullRecycler.setLayoutManager(getLayoutManager());
        mPullRecycler.addItemDecoration(getItemDecoration());
        mPullRecycler.setAdapter(mAdapter);
    }

    protected void initData() {
        mPullRecycler.setRefreshing();
    }

    protected void setUpAdapter() {
        mAdapter = new ListAdapter();
    }

    protected ILayoutManager getLayoutManager() {
        return new MyLinearLayoutManager(getContext());
    }

    protected RecyclerView.ItemDecoration getItemDecoration() {
        return new DividerItemDecoration(getContext(), R.drawable.list_divider);
    }

    public class ListAdapter extends BaseListAdapter {

        @Override
        protected BaseViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
            return getViewHolder(parent, viewType);
        }

        @Override
        protected int getDataCount() {
            return mDataList != null ? mDataList.size() : 0;
        }

        @Override
        protected int getDataViewType(int position) {
            return getItemType(position);
        }

        @Override
        public boolean isSectionHeader(int position) {
            return BaseListFragment.this.isSectionHeader(position);
        }
    }

    protected boolean isSectionHeader(int position) {
        return false;
    }

    protected int getItemType(int position) {
        return 0;
    }

    protected abstract BaseViewHolder getViewHolder(ViewGroup parent, int viewType);

    public void setHeaderView(BaseViewHolder headerViewHolder) {
        if (mAdapter != null) {
            mAdapter.setHeaderView(headerViewHolder);
        }
    }
}
