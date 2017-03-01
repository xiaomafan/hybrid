package com.ixiaoma.modify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ixiaoma.modify.views.TabAFragment;
import com.ixiaoma.modify.views.TabBFragment;
import com.ixiaoma.modify.views.TabCFragment;
import com.ixiaoma.modify.views.TabDFragment;
import com.ixiaoma.modify.views.TabEFragment;
import com.ixiaoma.modify.views.TabFFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip mTabs;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private String[] mTitles = new String[]{"全部", "待确认", "已确认",
            "已付款", "已完成", "已取消"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabs = (PagerSlidingTabStrip) findViewById(R.id.pts_head);
        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        initViews();
        initDatas();
        mViewPager.setCurrentItem(0,false);
    }

    private void initDatas() {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });
        mTabs.setViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position,false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position,false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {
        mFragments = new ArrayList<>();
        mFragments.add(new TabAFragment());
        mFragments.add(new TabBFragment());
        mFragments.add(new TabCFragment());
        mFragments.add(new TabDFragment());
        mFragments.add(new TabEFragment());
        mFragments.add(new TabFFragment());
    }
}
