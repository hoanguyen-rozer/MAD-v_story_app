package com.example.vstory.ui.story;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.vstory.R;
import com.example.vstory.adapter.StoryAdapter;
import com.example.vstory.apiservice.Service;
import com.example.vstory.controller.StoryInteractionListener;
import com.example.vstory.model.Story;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListStoryFragment extends Fragment {

    private static final String ARG_IS_PASSED = "idIsPassed";
    public static String SELECTED_STORY = "selected_story";
    private int idIsPassed;
    private RecyclerView listStoryRecView;

    public ListStoryFragment() {
        // Required empty public constructor
    }

    public static ListStoryFragment newInstance(int idIsPassed) {
        ListStoryFragment fragment = new ListStoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IS_PASSED, idIsPassed);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idIsPassed = getArguments().getInt(ARG_IS_PASSED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_story, container, false);

        listStoryRecView = view.findViewById(R.id.list_story_recview);
        listStoryRecView.setHasFixedSize(true);
        listStoryRecView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        Service service = new Service(getContext());

        Service.GetListStoryResponse getListStoryResponse = new Service.GetListStoryResponse() {
            @Override
            public void onError(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Story> listStory) {
                initView(listStory);
            }
        };

        if(idIsPassed == -1){
            service.getAllStory(getListStoryResponse);
//            service.getAllStory(new Service.GetListStoryResponse() {
//                @Override
//                public void onError(String message) {
//                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onResponse(List<Story> listStory) {
//                    initView(listStory);
//                }
//            });
        }else {
            service.getStoryByCategory(idIsPassed, getListStoryResponse);
//            service.getStoryByCategory(idIsPassed, new Service.GetListStoryResponse() {
//                @Override
//                public void onError(String message) {
//                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onResponse(List<Story> listStory) {
//                    initView(listStory);
//                }
//            });
        }
        return view;
    }

    public void initView(List<Story> listStory){
        StoryAdapter storyAdapter = new StoryAdapter(listStory, getContext(), new StoryInteractionListener() {
            @Override
            public void setOnClickItem(int pos) {
                Intent intent = new Intent(getActivity().getBaseContext(), AboutStoryActivity.class);
                intent.putExtra(SELECTED_STORY, listStory.get(pos));
                getContext().startActivity(intent);
            }

            @Override
            public List<Story> getList() {
                return listStory;
            }
        });
        listStoryRecView.setAdapter(storyAdapter);
    }
}