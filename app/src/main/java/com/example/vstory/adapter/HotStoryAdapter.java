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

import java.util.List;

public class HotStoryAdapter extends RecyclerView.Adapter<HotStoryAdapter.ViewHolder> {

    private List<Story> listHotStory;
    private Context context;
    private StoryInteractionListener callBack;

    public HotStoryAdapter(List<Story> listHotStory, Context context, StoryInteractionListener callBack) {
        this.listHotStory = listHotStory;
        this.context = context;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_story, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story story = listHotStory.get(position);
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
        return listHotStory.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView story_title, story_author_and_chap;
        private ImageView story_image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            story_title = itemView.findViewById(R.id.story_title);
            story_author_and_chap = itemView.findViewById(R.id.story_author_and_chap);
            story_image = itemView.findViewById(R.id.story_image);
        }

        public void bind(Story story) {
            this.getStory_title().setText(story.getTitle());
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

        public ImageView getStory_image() {
            return story_image;
        }
    }
}
