package com.ixiaoma.modify;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.ixiaoma.hybrid.LogHelper;
import com.ixiaoma.modify.views.TabAFragment;
import com.ixiaoma.modify.views.TabBFragment;
import com.ixiaoma.modify.views.TabCFragment;
import com.ixiaoma.modify.views.TabDFragment;
import com.ixiaoma.modify.views.TabEFragment;
import com.ixiaoma.modify.views.TabFFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PagerSlidingTabStrip mTabs;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private String[] mTitles = new String[]{"全部", "待确认", "已确认",
            "已付款", "已完成", "已取消"};
    private TabLayout mTabLoyout;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mTabs = (PagerSlidingTabStrip) findViewById(R.id.pts_head);
        mTabLoyout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        initViews();
        initDatas();
        mViewPager.setCurrentItem(0,false);
        LogHelper.e("hybrid","开始了");
        
    }

 
    private void initDatas() {


       FragmentStatePagerAdapter mAdapter= new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
        };
        
        
        mViewPager.setAdapter(mAdapter);
//        mTabs.setViewPager(mViewPager);
        mTabLoyout.addTab(mTabLoyout.newTab().setText(mTitles[0]));
        mTabLoyout.addTab(mTabLoyout.newTab().setText(mTitles[1]));
        mTabLoyout.addTab(mTabLoyout.newTab().setText(mTitles[2]));
        mTabLoyout.addTab(mTabLoyout.newTab().setText(mTitles[3]));
        mTabLoyout.addTab(mTabLoyout.newTab().setText(mTitles[4]));
        mTabLoyout.addTab(mTabLoyout.newTab().setText(mTitles[5]));
        mTabLoyout.setupWithViewPager(mViewPager);
        mTabLoyout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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

        changeTabs();
     /*   mTabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        });*/
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void changeTabs() {
        Class<?> tablayout = mTabLoyout.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tablayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(mTabLoyout);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.setMarginStart(DensityUtil.dp2px(this,8));
            params.setMarginEnd(DensityUtil.dp2px(this,8));
            child.setLayoutParams(params);
            child.invalidate();
        }
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
