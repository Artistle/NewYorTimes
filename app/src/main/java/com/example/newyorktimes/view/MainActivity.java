package com.example.newyorktimes;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.newyorktimes.presenters.PresenterLoadNews;
import com.example.newyorktimes.view.RecyclerViewNewsAdapter;
import com.example.newyorktimes.view.View;

public class MainActivity extends MvpActivity implements View {
    private RecyclerView recyclerView;

    @InjectPresenter
    PresenterLoadNews presenterLoadNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_news);
        initRecyclerViewNews();

        presenterLoadNews.loadNews();

    }

    public void initRecyclerViewNews(){
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void adapter(RecyclerViewNewsAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
