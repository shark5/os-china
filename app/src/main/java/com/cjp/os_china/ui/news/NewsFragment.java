package com.cjp.os_china.ui.news;

import com.cjp.os_china.R;
import com.cjp.os_china.base.BaseViewPagerFragment;

public class NewsFragment extends BaseViewPagerFragment {

    @Override
    protected int getLayoutResId() {
        return super.getLayoutResId();
    }

    @Override
    protected int getTitleRes() {
        return R.string.main_tab_name_news;
    }

    @Override
    protected PagerInfo[] getPagers() {
        PagerInfo [] pagerInfos = new PagerInfo[4];
        pagerInfos[0] = new PagerInfo(getString(R.string.information), InformationFragment.class, null);
        pagerInfos[1] = new PagerInfo(getString(R.string.blog), BlogFragment.class, null);
        pagerInfos[2] = new PagerInfo(getString(R.string.answer), AnswerFragment.class, null);
        pagerInfos[3] = new PagerInfo(getString(R.string.activity), ActivityFragment.class, null);
        return pagerInfos;
    }
}
