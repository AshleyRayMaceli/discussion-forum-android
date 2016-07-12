package com.example.guest.discussionforum.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.discussionforum.ui.ThreadDetailFragment;
import com.example.guest.discussionforum.models.Thread;

import java.util.ArrayList;

public class ThreadPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Thread> mThreads;

    public ThreadPagerAdapter(FragmentManager fm, ArrayList<Thread> threads) {
        super(fm);
        mThreads = threads;
    }

    @Override
    public Fragment getItem(int position) {
        return ThreadDetailFragment.newInstance(mThreads.get(position));
    }

    @Override
    public int getCount() {
        return mThreads.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mThreads.get(position).getUserName();
    }
}
