package com.example.vstory.ui.story;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vstory.R;

public class SearchActivity extends AppCompatActivity {

    private EditText search_text;
    private Button action_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        search_text = findViewById(R.id.search_text);
        action_search = findViewById(R.id.action_search);

        action_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!search_text.getText().toString().equals("")) {
                    ListStoryGridFragment listStoryGridFragment = ListStoryGridFragment.newInstance(-1, search_text.getText().toString());
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.search_result_frame_layout, listStoryGridFragment, listStoryGridFragment.getTag())
                            .commit();
                }


            }
        });

    }
}