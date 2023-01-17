package com.credadevs.conveyance;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.credadevs.conveyance.Fragments.OwnedPassesFragment;
import com.credadevs.conveyance.Fragments.PurchasePassFragment;

public class myViewPagerAdapter extends FragmentStateAdapter {

    public myViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new PurchasePassFragment();
        }
        return new OwnedPassesFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
