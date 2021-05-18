package com.example.vstory.controller;

import com.example.vstory.model.Category;

import java.util.List;

public interface CategoryGVClinkedListener {
    void setItemClicked(int pos);
    List<Category> getList();
}
