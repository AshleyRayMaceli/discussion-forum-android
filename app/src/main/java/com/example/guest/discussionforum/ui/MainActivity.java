package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.guest.discussionforum.Constants;
import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.adapters.FirebaseThreadViewHolder;
import com.example.guest.discussionforum.models.Thread;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mThreadReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.newPostButton) Button mNewPostButton;
    @Bind(R.id.threadsRecyclerView) RecyclerView mThreadsRecyclerView;

    public ArrayList<Thread> mThreads = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNewPostButton.setOnClickListener(this);

        mThreadReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_THREADS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Thread, FirebaseThreadViewHolder>
                (Thread.class, R.layout.thread_list_item, FirebaseThreadViewHolder.class,
                        mThreadReference) {

            @Override
            protected void populateViewHolder(FirebaseThreadViewHolder viewHolder,
                                              Thread model, int position) {
                viewHolder.bindThread(model);
            }
        };
        mThreadsRecyclerView.setHasFixedSize(true);
        mThreadsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mThreadsRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == mNewPostButton) {
            Intent intent = new Intent(MainActivity.this, NewPostActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}
