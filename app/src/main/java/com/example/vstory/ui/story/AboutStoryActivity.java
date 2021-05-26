package com.example.vstory.ui.story;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vstory.R;
import com.example.vstory.model.Story;

import java.util.ArrayList;

import static com.example.vstory.ui.home.HomeFragment.SELECTED_STORY;

public class AboutStoryActivity extends AppCompatActivity {


    public static final String ID_STORY = "idStory";
    private ImageView story_img_cover, story_img_primary;
    private TextView story_about_title, story_about_author, story_about_categories, story_about_status, story_total_chapter, story_date_update, story_date_release, story_description;
    private Button btn_read_story;
    private Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_story);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        initView();
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra(SELECTED_STORY);
        setData(story);
        btn_read_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutStoryActivity.this, ChapterContentActivity.class);
                intent.putExtra(ID_STORY, story.getId());
                startActivity(intent);
            }
        });
    }



    private void initView() {
        story_img_cover = findViewById(R.id.story_img_cover);
        story_img_primary = findViewById(R.id.story_img_primary);
        story_about_title = findViewById(R.id.story_about_title);
        story_about_author = findViewById(R.id.story_about_author);
        story_about_categories = findViewById(R.id.story_about_categories);
        story_about_status = findViewById(R.id.story_about_status);
        story_total_chapter = findViewById(R.id.story_total_chapter);
        story_date_release = findViewById(R.id.story_date_release);
        story_date_update = findViewById(R.id.story_date_update);
        story_description = findViewById(R.id.story_description);
        btn_read_story = findViewById(R.id.btn_read_story);
    }



    public void setData(Story story){
        Glide.with(this)
                .asBitmap()
                .centerCrop()
                .load(story.getImgUrl())
                .into(story_img_cover);

        Glide.with(this)
                .asBitmap()
                .centerCrop()
                .load(story.getImgUrl())
                .into(story_img_primary);
        story_about_title.setText(story.getTitle());
        story_about_author.setText(story.getAuthor());
        story_about_status.setText(story.getStatus());
        story_about_categories.setText(TextUtils.join(", ", story.getCategory()));
        story_total_chapter.setText(String.valueOf(story.getTotal_chapters()));
        story_date_release.setText(story.getDate_update());
        story_description.setText(story.getDescription());
    }
}