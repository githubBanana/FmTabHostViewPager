package com.xs.fmtabhostviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener,ViewPager.OnPageChangeListener{

    private FragmentTabHost mTabHost;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_Id);
        mViewPager.setOnPageChangeListener(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
//        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.viewpager_Id);
        mTabHost.setOnTabChangedListener(this);
        mTabHost.getTabWidget().setShowDividers(0);
        mTabHost.addTab(mTabHost.newTabSpec("one").setIndicator(getTabLayoutView(R.layout.tabs1)),OneFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("two").setIndicator(getTabLayoutView(R.layout.tabs2)),TwoFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("three").setIndicator(getTabLayoutView(R.layout.tabs3)),ThreeFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("four").setIndicator(getTabLayoutView(R.layout.tabs4)),FourFragment.class,null);
        initPager();
    }

    private void initPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());
        fragmentList.add(new FourFragment());
        mViewPager.setAdapter(new MyFmPagerAdapter(getSupportFragmentManager(),fragmentList));
    }


    private View getTabLayoutView(int layoutId) {
        View view =  getLayoutInflater().inflate(layoutId,null);
        return view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTabHost = null;
    }

    @Override
    public void onTabChanged(String tabId) {
        int position = mTabHost.getCurrentTab();
        mViewPager.setCurrentItem(position);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTabHost.setCurrentTab(position);
/*        TabWidget widget = mTabHost.getTabWidget();
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        mTabHost.setCurrentTab(position);
        widget.setDescendantFocusability(oldFocusability);*/
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
