package com.example.vstory.ui.story;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vstory.R;
import com.example.vstory.adapter.StoryAdapter;
import com.example.vstory.apiservice.Service;
import com.example.vstory.controller.StoryInteractionListener;
import com.example.vstory.model.Story;

import java.util.List;

import static com.example.vstory.ui.story.ListStoryFragment.SELECTED_STORY;


public class ListStoryGridFragment extends Fragment {

    private static final String ID_CATEGORY_IS_PASSED = "idCategoryIsPassed";
    private static final String STRING_IS_PASSED = "stringIsPassed";
    private int idCategoryIsPassed;
    private String stringIsPassed;
    private RecyclerView listStoryRecView;
    public ListStoryGridFragment() {
        // Required empty public constructor
    }

    public static ListStoryGridFragment newInstance(int idCategoryIsPassed, String str) {
        ListStoryGridFragment fragment = new ListStoryGridFragment();
        Bundle args = new Bundle();
        args.putInt(ID_CATEGORY_IS_PASSED, idCategoryIsPassed);
        args.putString(STRING_IS_PASSED, str);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idCategoryIsPassed = getArguments().getInt(ID_CATEGORY_IS_PASSED);
            stringIsPassed = getArguments().getString(STRING_IS_PASSED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_story_grid, container, false);

        Log.i(
                "Category","int: "+idCategoryIsPassed
        );
        listStoryRecView = view.findViewById(R.id.list_story_grid_recview);
        listStoryRecView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        listStoryRecView.setLayoutManager(gridLayoutManager);
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

        if(!stringIsPassed.isEmpty()){
            service.searchStory(stringIsPassed, getListStoryResponse);
            this.setStringIsPassed("");
        }else {
            service.getStoryByCategory(idCategoryIsPassed, getListStoryResponse);
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

    public void setStringIsPassed(String stringIsPassed) {
        this.stringIsPassed = stringIsPassed;
    }
}