package com.scrapyd.client.app.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author huangyong
 * createTime 2019-07-23
 */
public class SpiderPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    String[] title = {"等待","运行中","已完成"};

    public SpiderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
