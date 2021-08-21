package com.learning.cricket247.home.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learning.cricket247.model.seriesdata.LiveSeries;
import com.learning.cricket247.remoteconnection.ApiServices;

import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;

public class AllSeriesViewModel extends ViewModel {

    MutableLiveData<ArrayList<LiveSeries>> mutableLiveData = new MutableLiveData<>();

    public AllSeriesViewModel() {
        super();
    }

    public MutableLiveData<ArrayList<LiveSeries>> getAllSeriesData() {

        ApiServices.getAllSeries().subscribeWith(new DisposableObserver<ArrayList<LiveSeries>>() {
            @Override
            public void onNext(ArrayList<LiveSeries> liveSeries) {
                if (liveSeries != null) {
                    mutableLiveData.setValue(liveSeries);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return mutableLiveData;
    }
}