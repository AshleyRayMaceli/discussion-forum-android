package com.example.guest.discussionforum.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Thread;

public class FirebaseThreadViewHolder extends RecyclerView.ViewHolder {

    View mView;
    Context mContext;

    public FirebaseThreadViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindThread(Thread thread) {

        TextView userNameTextView = (TextView) mView.findViewById(R.id.userNameTextView);
        TextView messageTextView = (TextView) mView.findViewById(R.id.messageTextView);
        ImageButton upImageButton = (ImageButton) mView.findViewById(R.id.upImageButton);
        TextView scoreTextView = (TextView) mView.findViewById(R.id.scoreTextView);
        ImageButton downImageButton = (ImageButton) mView.findViewById(R.id.downImageButton);

        messageTextView.setText(thread.getMessage());
        userNameTextView.setText(thread.getUserName());
        scoreTextView.setText(thread.getScore() + "");
    }

}
