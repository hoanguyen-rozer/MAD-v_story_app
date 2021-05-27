package com.example.vstory.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.vstory.R;
import com.example.vstory.apiservice.Service;
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

        Service service = new Service(getContext());
        service.getAllCategory(new Service.GetListCategoryResponse() {
            @Override
            public void onError(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Category> listCategory) {
                setListCategory(listCategory);
                addMainFragment();
            }
        });
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

    public void setListCategory(List<Category> listCategory) {
        this.listCategory = listCategory;
    }
}