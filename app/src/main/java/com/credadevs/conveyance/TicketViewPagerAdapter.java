package com.credadevs.conveyance;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.credadevs.conveyance.Fragments.OwnedTicketsFragment;
import com.credadevs.conveyance.Fragments.PurchaseTicketFragment;

public class TicketViewPagerAdapter extends FragmentStateAdapter {
    public TicketViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new PurchaseTicketFragment();
        }
        return new OwnedTicketsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
