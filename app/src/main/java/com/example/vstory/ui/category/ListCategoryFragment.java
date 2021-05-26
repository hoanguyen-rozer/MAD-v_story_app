package com.example.vstory.ui.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.vstory.R;
import com.example.vstory.adapter.CategoryGVAdapter;
import com.example.vstory.databinding.FragmentListCategoryBinding;
import com.example.vstory.model.Category;
import com.example.vstory.ui.story.ListStoryGridFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListCategoryFragment extends Fragment {

    private FragmentListCategoryBinding binding;
    private List<Category> listCategory;
    public ListCategoryFragment() {
        // Required empty public constructor
    }

    public static ListCategoryFragment newInstance() {
        ListCategoryFragment fragment = new ListCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_category, container, false);

        GridView categoryGV = view.findViewById(R.id.gridview);


        CategoryGVAdapter adapter = new CategoryGVAdapter(getContext(), 0, listCategory);
        categoryGV.setAdapter(adapter);
        categoryGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListStoryGridFragment listStoryByCategoryFragment = ListStoryGridFragment.newInstance(listCategory.get(position).getId(), "");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.category_frag_frame_layout, listStoryByCategoryFragment, listStoryByCategoryFragment.getTag())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    public void setListCategory(List<Category> listCategory) {
        this.listCategory = listCategory;
    }
}