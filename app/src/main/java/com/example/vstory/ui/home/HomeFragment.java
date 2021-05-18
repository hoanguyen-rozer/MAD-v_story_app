package com.example.vstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vstory.R;
import com.example.vstory.adapter.StoryAdapter;
import com.example.vstory.controller.StoryInteractionListener;
import com.example.vstory.databinding.FragmentHomeBinding;
import com.example.vstory.model.Story;
import com.example.vstory.ui.story.AboutStoryActivity;
import com.example.vstory.ui.story.ListStoryFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public static String SELECTED_STORY = "selected_story";

    private RecyclerView allStoryRecView;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        ArrayList<Story> allStory = new ArrayList<>();
//        String[] category = {"Kiem hiep", "Co trang"};
//        allStory.add(new Story("1", "Hiep Khach Giang Ho 1", "Yamaha", category, "https://th.bing.com/th/id/Ra8ae2c3be15e632bfb304dbe81f758d6?rik=Ohf1WYKKMfvxpw&pid=ImgRaw", "update", "test", "20/04/2021", 43));
//        allStory.add(new Story("2", "Hiep Khach Giang Ho 2", "John Doe", category, "https://th.bing.com/th/id/OIP.soWw-aviX3eoGjKw5L0ioQAAAA?pid=ImgDet&rs=1", "update", "test", "20/04/2021", 43));
//        allStory.add(new Story("3", "Hiep Khach Giang Ho 3", "Yamaha", category, "https://th.bing.com/th/id/Ra8ae2c3be15e632bfb304dbe81f758d6?rik=Ohf1WYKKMfvxpw&pid=ImgRaw", "update", "test", "20/04/2021", 43));
//        allStory.add(new Story("4", "Hiep Khach Giang Ho 4", "John Doe", category, "https://th.bing.com/th/id/OIP.soWw-aviX3eoGjKw5L0ioQAAAA?pid=ImgDet&rs=1", "update", "test", "20/04/2021", 43));
//        allStory.add(new Story("5", "Hiep Khach Giang Ho 5", "Yamaha", category, "https://th.bing.com/th/id/Ra8ae2c3be15e632bfb304dbe81f758d6?rik=Ohf1WYKKMfvxpw&pid=ImgRaw", "update", "test", "20/04/2021", 43));
//        allStory.add(new Story("6", "Hiep Khach Giang Ho 6", "John Doe", category, "https://th.bing.com/th/id/OIP.soWw-aviX3eoGjKw5L0ioQAAAA?pid=ImgDet&rs=1", "update", "test", "20/04/2021", 43));
//        allStory.add(new Story("7", "Hiep Khach Giang Ho 7", "John Doe", category, "https://th.bing.com/th/id/OIP.soWw-aviX3eoGjKw5L0ioQAAAA?pid=ImgDet&rs=1", "update", "test", "20/04/2021", 43));
//        allStory.add(new Story("8", "Hiep Khach Giang Ho 8", "John Doe", category, "https://th.bing.com/th/id/OIP.soWw-aviX3eoGjKw5L0ioQAAAA?pid=ImgDet&rs=1", "update", "test", "20/04/2021", 43));
//
//        allStoryRecView = root.findViewById(R.id.list_story_recview);
//        allStoryRecView.setHasFixedSize(true);
//        allStoryRecView.setLayoutManager(new LinearLayoutManager(root.getContext()));
//
//        StoryAdapter storyAdapter = new StoryAdapter(allStory, getContext(), new StoryInteractionListener() {
//            @Override
//            public void setOnClickItem(int pos) {
//                Intent intent = new Intent(getActivity().getBaseContext(), AboutStoryActivity.class);
//                intent.putExtra(SELECTED_STORY, allStory.get(pos));
//                getContext().startActivity(intent);
//            }
//
//            @Override
//            public ArrayList<Story> getList() {
//                return allStory;
//            }
//        });
//        allStoryRecView.setAdapter(storyAdapter);
        addMainFragment();

        return root;


    }

    private void addMainFragment(){
        ListStoryFragment listStoryFragment = ListStoryFragment.newInstance(-1);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.home_frame_layout, listStoryFragment, listStoryFragment.getTag())
                .commit();
    }



}