package com.xs.fmtabhostviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-05-13 13:41
 * @email Xs.lin@foxmail.com
 */
public class MyFmPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "MyFmPagerAdapter";

    List<Fragment> fragmentList;

    public MyFmPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFmPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
