package com.example.guest.discussionforum.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Thread;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ThreadDetailFragment extends Fragment {
    @Bind(R.id.messageTextView) TextView mMessageTextView;
    @Bind(R.id.userNameTextView) TextView mUserNameTextView;
    @Bind(R.id.upImageButton) ImageButton mUpImageButton;
    @Bind(R.id.downImageButton) ImageButton mDownImageButton;
    @Bind(R.id.scoreTextView) TextView mScoreTextView;
    @Bind(R.id.commentsRecyclerView) RecyclerView mCommentsRecyclerView;
    @Bind(R.id.commentEditText) EditText mCommentEditText;
    @Bind(R.id.submitCommentButton) Button mSubmitCommentButton;

    private Thread mThread;

    public static ThreadDetailFragment newInstance(Thread thread) {
        ThreadDetailFragment threadDetailFragment = new ThreadDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("thread", Parcels.wrap(thread));
        threadDetailFragment.setArguments(args);
        return threadDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mThread = Parcels.unwrap(getArguments().getParcelable("thread"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thread_detail, container, false);
        ButterKnife.bind(this, view);

        mMessageTextView.setText(mThread.getMessage());
        mUserNameTextView.setText(mThread.getUserName());
        mScoreTextView.setText(mThread.getScore() + "");

        return view;
    }

}
