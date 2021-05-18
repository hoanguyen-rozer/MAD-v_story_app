package com.example.vstory.controller;

import com.example.vstory.model.Story;

import java.util.ArrayList;
import java.util.List;

public interface StoryInteractionListener {
    void setOnClickItem(int pos);
    List<Story> getList();
}
