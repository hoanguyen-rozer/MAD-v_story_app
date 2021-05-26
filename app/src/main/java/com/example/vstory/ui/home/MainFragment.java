package com.example.vstory.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vstory.R;
import com.example.vstory.databinding.FragmentHomeBinding;
import com.example.vstory.databinding.FragmentMainBinding;
import com.example.vstory.ui.story.ListStoryFragment;
import com.example.vstory.ui.story.ListStoryGridFragment;

public class MainFragment extends Fragment {

    private TextView kiemHiep, trinhTham, coTrang;
    private FragmentMainBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        kiemHiep = root.findViewById(R.id.kiemHiep);
        trinhTham = root.findViewById(R.id.trinhTham);
        coTrang = root.findViewById(R.id.coTrang);
        kiemHiep.setOnClickListener(onClickListener);
        trinhTham.setOnClickListener(onClickListener);
        coTrang.setOnClickListener(onClickListener);
        addMainFragment();
        addMainFragment6();
        addMainFragment2();
        addMainFragment3();
        return root;


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            switch (v.getId()){
                case R.id.kiemHiep:
                    ListStoryGridFragment listStoryByCategoryFragment = ListStoryGridFragment.newInstance(1, "");

                    fragmentManager.beginTransaction()
                            .replace(R.id.home_frag_frame_layout, listStoryByCategoryFragment, listStoryByCategoryFragment.getTag())
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.trinhTham:
                    ListStoryGridFragment listStoryByCategoryFragment1 = ListStoryGridFragment.newInstance(3, "");

                    fragmentManager.beginTransaction()
                            .replace(R.id.home_frag_frame_layout, listStoryByCategoryFragment1, listStoryByCategoryFragment1.getTag())
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.coTrang:
                    ListStoryGridFragment listStoryByCategoryFragment2 = ListStoryGridFragment.newInstance(2, "");

                    fragmentManager.beginTransaction()
                            .replace(R.id.home_frag_frame_layout, listStoryByCategoryFragment2, listStoryByCategoryFragment2.getTag())
                            .addToBackStack(null)
                            .commit();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
        }
    };

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