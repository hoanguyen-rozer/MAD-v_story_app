package com.example.vstory.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.vstory.R;
import com.example.vstory.databinding.FragmentCategoryBinding;
import com.example.vstory.model.Category;
import com.example.vstory.ui.story.ListStoryFragment;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;
    private List<Category> listCategory;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listCategory = new ArrayList<>();
        listCategory.add(new Category(1, "Kiem hiep"));
        listCategory.add(new Category(2, "Co Trang"));
        listCategory.add(new Category(3, "Trinh Tham"));
        listCategory.add(new Category(4, "Ma- Kinh Di"));
        listCategory.add(new Category(4, "Tham hiem - Phieu luu"));
        addMainFragment();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void addMainFragment(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        ListCategoryFragment listCategoryFragment = new ListCategoryFragment();
        listCategoryFragment.setListCategory(listCategory);
        manager.beginTransaction()
                .add(R.id.category_frag_frame_layout, listCategoryFragment, listCategoryFragment.getTag())
                .commit();
    }
}