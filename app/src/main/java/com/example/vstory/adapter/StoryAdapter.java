package com.example.vstory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.vstory.R;
import com.example.vstory.controller.StoryInteractionListener;
import com.example.vstory.model.Story;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private List<Story> listStory;
    private Context context;
    private StoryInteractionListener callBack;

    public StoryAdapter(List<Story> listStory, Context context, StoryInteractionListener callBack) {
        this.listStory = listStory;
        this.context = context;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_story, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story story = listStory.get(position);
        holder.bind(story);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.setOnClickItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listStory.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView story_title, story_author_and_chap, story_update_day;
        private ImageView story_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            story_title = itemView.findViewById(R.id.story_title);
            story_author_and_chap = itemView.findViewById(R.id.story_author_and_chap);
            story_update_day = itemView.findViewById(R.id.story_update_day);
            story_image = itemView.findViewById(R.id.story_image);
        }

        public void bind(Story story) {
            this.getStory_title().setText(story.getTitle());
            this.getStory_author_and_chap().setText("Chương: " + story.getTotal_chapters() + " - T/g: " + story.getAuthor());
            this.getStory_update_day().setText("Ngày cập nhật: " + (CharSequence) story.getDate_update());
            Glide.with(context)
                    .asBitmap()
                    .centerCrop()
                    .load(story.getImgUrl())
                    .into(this.getStory_image());
        }

        public TextView getStory_title() {
            return story_title;
        }

        public TextView getStory_author_and_chap() {
            return story_author_and_chap;
        }

        public TextView getStory_update_day() {
            return story_update_day;
        }

        public ImageView getStory_image() {
            return story_image;
        }
    }
}
