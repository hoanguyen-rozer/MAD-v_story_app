package com.example.vstory.ui.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vstory.R;
import com.example.vstory.databinding.FragmentLibraryBinding;
import com.example.vstory.ui.story.ListStoryLibFragment;


public class LibraryFragment extends Fragment {

    public static String SELECTED_STORY = "selected_story";

    private RecyclerView hotStoryRecView;
    private FragmentLibraryBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        addMainFragment();

        return root;
    }

    private void addMainFragment() {
        ListStoryLibFragment listStoryFragment = ListStoryLibFragment.newInstance(-1);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.library_layout, listStoryFragment, listStoryFragment.getTag())
                .commit();
    }


}