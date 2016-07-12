package com.example.guest.discussionforum.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.adapters.ThreadPagerAdapter;
import com.example.guest.discussionforum.models.Thread;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ThreadDetailActivity extends AppCompatActivity {

    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ThreadPagerAdapter adapterViewPager;
    ArrayList<Thread> mThreads = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_detail);
        ButterKnife.bind(this);

        mThreads = Parcels.unwrap(getIntent().getParcelableExtra("threads"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        adapterViewPager = new ThreadPagerAdapter(getSupportFragmentManager(), mThreads);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
