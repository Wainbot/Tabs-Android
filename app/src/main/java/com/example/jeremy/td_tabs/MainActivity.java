package com.example.jeremy.td_tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.NumberPicker;

public class MainActivity extends FragmentActivity {

    ViewPager         mViewPager;
    Fragment          mFragmentChoose;
    Fragment          mFragmentView;
    NumberPicker      mNumberPickerChevres;
    ImageView         mImageViewChevre;
    TabsPagerAdapter  mAdapter;
    String[]          tabs = { "Choose", "View" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager          = (ViewPager) findViewById(R.id.pager);
        mAdapter            = new TabsPagerAdapter(getSupportFragmentManager());

        for (String tab_name : tabs) {
            tabLayout.addTab(tabLayout.newTab().setText(tab_name));
        }

        mViewPager.setAdapter(mAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

                mFragmentChoose = mAdapter.getItem(0);
                if (mFragmentChoose instanceof ChooseFragment) {
//                    Log.i("ChooseFragment ?", "YEEEEEEEES!");
                    mNumberPickerChevres = ((ChooseFragment) mFragmentChoose).getNumberPicker();
                }

                mFragmentView = mAdapter.getItem(1);
                if (mFragmentView instanceof ViewFragment) {
//                    Log.i("ViewFragment ?", "YEEEEEEEES!");
                    mImageViewChevre = ((ViewFragment) mFragmentView).getImageView();
                }

                mNumberPickerChevres.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        switch (newVal) {
                            case 0 :
                                mImageViewChevre.setImageResource(R.mipmap.chevre_1);
                                break;
                            case 1 :
                                mImageViewChevre.setImageResource(R.mipmap.chevre_2);
                                break;
                            case 2 :
                                mImageViewChevre.setImageResource(R.mipmap.chevre_3);
                        }

//                        Log.i("RESULT::::", ((ChooseFragment) mFragmentChoose).mesChevres()[newVal]);
                    }
                });

//                Log.i("CHOOSE MY CHEVRES !!!", Arrays.toString(((ChooseFragment) mFragmentChoose).mesChevres()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.i("UNSELECTED", "UNSELECTED");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.i("RESELECTED", "RESELECTED");
            }
        });
    }
}
