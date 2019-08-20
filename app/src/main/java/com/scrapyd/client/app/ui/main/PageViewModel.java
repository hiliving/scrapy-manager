package com.scrapyd.client.app.ui.main;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PageViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private LiveData<Integer> mText = Transformations.map(mIndex, new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer input) {
            return input;
        }
    });

    public PageViewModel(@NonNull Application application) {
        super(application);

    }

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<Integer> getSpiderList() {
        return mText;
    }


}