package com.example.jeremy.td_tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private ChooseFragment  chooseFragment;
    private ViewFragment    viewFragment;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);

        viewFragment   = new ViewFragment();
        chooseFragment = new ChooseFragment();
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return chooseFragment;
            case 1:
                return viewFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}