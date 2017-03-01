package com.ixiaoma.modify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.ixiaoma.modify.view.SimpleViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoma on 2017/2/26.
 */

public class StickyNavActivity extends FragmentActivity {
    private String[] mTitles = new String[]{"简介", "评价", "相关"};
    private SimpleViewPagerIndicator mIndicator;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    //    private TabFragment[] mFragments = new TabFragment[mTitles.length];
    private List<Fragment> myFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickynav);

        initViews();
        initDatas();
        initEvents();
    }

    private void initViews() {
        mIndicator = (SimpleViewPagerIndicator) findViewById(R.id.id_stickynavlayout_indicator);
        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);
    }

    private void initDatas() {
        mIndicator.setTitles(mTitles);
        myFragments = new ArrayList<>();

        for (int i = 0; i < mTitles.length - 1; i++) {
//            mFragments[i] = TabFragment.newInstance(mTitles[i]);
            myFragments.add(TabFragment.newInstance(mTitles[i]));
        }
        myFragments.add(new BlankFragment());

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int position) {
//                return mFragments[position];
                return myFragments.get(position);
            }

        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
    }

    private void initEvents() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
