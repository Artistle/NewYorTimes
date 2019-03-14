package com.example.newyorktimes.view.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.newyorktimes.R;
import com.example.newyorktimes.presenters.PresenterLoadNews;
import com.example.newyorktimes.view.RecyclerViewNewsAdapter;
import com.example.newyorktimes.view.ViewMainActivity;

public class NewsFragment extends MvpFragment implements ViewMainActivity {
    private RecyclerView recyclerView;

    @InjectPresenter
    PresenterLoadNews presenterLoadNews;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_news, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_news);
        initRecyclerView();
        //resenterLoadNews.loadNews();
        return view;
    }

    public NewsFragment() {
    }

    public static  NewsFragment getInstance(){
        return new NewsFragment();
    }

    public void initRecyclerView(){

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void adapter(RecyclerViewNewsAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
