package com.example.vstory.ui.story;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.vstory.R;
import com.example.vstory.databinding.FragmentChapterContentBinding;
import com.example.vstory.model.Chapter;

import java.util.List;


public class ChapterContentFragment extends Fragment {

    private static final String ARG_ID_CHAPTER = "idChapter";

    private FragmentChapterContentBinding binding;
    private int idChapter;
    private List<Chapter> listChapter;
    private Chapter chapter;

    private ScrollView scrollView;
    private TextView tv_chapter_order, tv_chapter_name, tv_chapter_content;

    public ChapterContentFragment() {
        // Required empty public constructor
    }

//    public static ChapterContentFragment newInstance(int idChapter) {
//        ChapterContentFragment fragment = new ChapterContentFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_ID_CHAPTER, idChapter);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idChapter = getArguments().getInt(ARG_ID_CHAPTER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChapterContentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        scrollView = view.findViewById(R.id.scrollview);
        scrollView.setVerticalScrollBarEnabled(false);

        initView(view);

        return view;
    }

    private void initView(View view) {

        tv_chapter_order = view.findViewById(R.id.tv_chapter_order);
        tv_chapter_name = view.findViewById(R.id.tv_chapter_name);
        tv_chapter_content = view.findViewById(R.id.tv_chapter_content);

        tv_chapter_order.setText("Chương " + chapter.getOrder());
        tv_chapter_name.setText(chapter.getName());
        tv_chapter_content.setText(chapter.getContent());
    }

    public void setData(Chapter chapter) {
        this.chapter = chapter;
    }
}