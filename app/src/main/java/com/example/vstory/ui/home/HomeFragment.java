package com.example.vstory.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.vstory.ui.story.ListStoryGridFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public static String SELECTED_STORY = "selected_story";

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        addMainFragment();
        return root;
    }

    private void addMainFragment(){
        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.home_frag_frame_layout, mainFragment, mainFragment.getTag())
                .commit();
    }

}