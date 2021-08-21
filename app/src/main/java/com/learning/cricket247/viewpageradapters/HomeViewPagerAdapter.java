package com.learning.cricket247.viewpageradapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.learning.cricket247.home.AllSeriesFragment;
import com.learning.cricket247.home.FinishedFragment;
import com.learning.cricket247.home.LiveHomeFragment;
import com.learning.cricket247.home.UpcomingFragment;

public class HomeViewPagerAdapter extends FragmentStateAdapter {

    public HomeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new UpcomingFragment();
            case 2:
                return new FinishedFragment();
            case 3:
                return new AllSeriesFragment();
            default:
                return new LiveHomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
