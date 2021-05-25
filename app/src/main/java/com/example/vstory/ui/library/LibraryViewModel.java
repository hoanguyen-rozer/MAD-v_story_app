package com.example.vstory.ui.library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LibraryViewModel {

    private MutableLiveData<String> mText;

    public LibraryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Library fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
