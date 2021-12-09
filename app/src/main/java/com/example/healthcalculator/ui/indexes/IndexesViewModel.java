package com.example.healthcalculator.ui.indexes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IndexesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public IndexesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is indexes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}