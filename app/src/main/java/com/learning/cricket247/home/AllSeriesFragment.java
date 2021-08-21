package com.learning.cricket247.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.cricket247.FixtureFragment.adapters.SeriesWiseRecyclerViewAdapter;
import com.learning.cricket247.R;
import com.learning.cricket247.home.viewmodel.AllSeriesViewModel;
import com.learning.cricket247.model.seriesdata.LiveSeries;
import com.learning.cricket247.pointtable.PointTablectivity;
import com.learning.cricket247.utility.constantfiles.RecyclerItemClickEvent;

import java.util.ArrayList;

public class AllSeriesFragment extends Fragment implements RecyclerItemClickEvent {

    private AllSeriesViewModel mViewModel;
    private RecyclerView seriesWiseRecyclerview;

    public static AllSeriesFragment newInstance() {
        return new AllSeriesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_series_fragment, container, false);
        seriesWiseRecyclerview = view.findViewById(R.id.seriesWiseRecyclerview);

        seriesWiseRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        mViewModel = new ViewModelProvider(this).get(AllSeriesViewModel.class);
        mViewModel.getAllSeriesData().observeForever(new Observer<ArrayList<LiveSeries>>() {
            @Override
            public void onChanged(ArrayList<LiveSeries> liveSeries) {
                seriesWiseRecyclerview.setAdapter(new SeriesWiseRecyclerViewAdapter(getActivity(), liveSeries, AllSeriesFragment.this::onClick));
            }
        });
        return view;
    }

    @Override
    public void onClick(String matchType, String matchId, String title, String message) {
        startActivity(new Intent(getActivity(), PointTablectivity.class)
                .putExtra("matchId", matchId)
                .putExtra("title", title));
    }
}