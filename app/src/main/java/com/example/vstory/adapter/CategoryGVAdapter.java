package com.example.vstory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vstory.R;
import com.example.vstory.model.Category;

import java.util.List;

public class CategoryGVAdapter extends ArrayAdapter<Category> {
    public CategoryGVAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        // Layout Inflater inflates each item to be displayed in GridView.
        if (view == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.card_category, parent, false);
        Category category = getItem(position);
        TextView category_name = view.findViewById(R.id.category_name);
        category_name.setText(category.getName());
        return view;
    }
}
