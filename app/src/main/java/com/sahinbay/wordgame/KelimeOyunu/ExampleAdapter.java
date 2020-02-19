package com.sahinbay.wordgame.KelimeOyunu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sahinbay.wordgame.R;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private int index;
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.imagelist, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        index = position + 2;

        // int mId = currentItem.getId();
        String mName = currentItem.getName();
        int mScore = currentItem.getScore();

        // holder.id.setText("" + mId);
        holder.name.setText(mName);
        holder.score.setText("" + mScore);
        holder.index.setText("" + index);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        // public ImageView mImageView;
        // public TextView id;
        public TextView index;
        public TextView name;
        public TextView score;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            // mImageView = itemView.findViewById(R.id.image_view);
            // id = itemView.findViewById(R.id.tv_id);
           /* index = itemView.findViewById(R.id.tv_index);
            name = itemView.findViewById(R.id.tv_name);
            score = itemView.findViewById(R.id.tv_score);*/
        }
    }
}