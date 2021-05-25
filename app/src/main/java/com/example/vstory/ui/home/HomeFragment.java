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
        addMainFragment();
        addMainFragment6();
        addMainFragment2();
        addMainFragment3();
        return root;


    }

    private void addMainFragment(){
        ListStoryFragment listStoryFragment = ListStoryFragment.newInstance(-1);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.home_frame_layout, listStoryFragment, listStoryFragment.getTag())
                .commit();
    }
    private void addMainFragment6(){
        ListStoryFragment listStoryFragment = ListStoryFragment.newInstance(1);//id kiểm hiệp
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.home_frame_layout6, listStoryFragment,"Fragment6")
                .commit();
    }
    private void addMainFragment2(){
        ListStoryFragment listStoryFragment = ListStoryFragment.newInstance(3);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.home_frame_layout2, listStoryFragment,"Fragment2")
                .commit();
    }
    private void addMainFragment3(){
        ListStoryFragment listStoryFragment = ListStoryFragment.newInstance(2);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.home_frame_layout3, listStoryFragment,"Fragment3")
                .commit();
    }


}