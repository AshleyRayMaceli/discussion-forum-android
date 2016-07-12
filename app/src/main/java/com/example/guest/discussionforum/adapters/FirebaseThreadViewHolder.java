package com.example.guest.discussionforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.guest.discussionforum.Constants;
import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Thread;
import com.example.guest.discussionforum.ui.ThreadDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseThreadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseThreadViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindThread(Thread thread) {

        TextView userNameTextView = (TextView) mView.findViewById(R.id.userNameTextView);
        TextView messageTextView = (TextView) mView.findViewById(R.id.messageTextView);
        TextView scoreTextView = (TextView) mView.findViewById(R.id.scoreTextView);
        ImageButton upImageButton = (ImageButton) mView.findViewById(R.id.upImageButton);
        ImageButton downImageButton = (ImageButton) mView.findViewById(R.id.downImageButton);

        messageTextView.setText(thread.getMessage());
        userNameTextView.setText(thread.getUserName());
        scoreTextView.setText(thread.getScore() + "");
    }

    @Override
    public void onClick(View v) {
        final ArrayList<Thread> threads = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_THREADS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    threads.add(snapshot.getValue(Thread.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, ThreadDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("threads", Parcels.wrap(threads));
                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

    }

}
