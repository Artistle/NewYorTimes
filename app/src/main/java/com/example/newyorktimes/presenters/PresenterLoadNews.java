package com.example.newyorktimes.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.newyorktimes.models.ModelNews;
import com.example.newyorktimes.retrofitsDI.RetrofitDI;
import com.example.newyorktimes.view.RecyclerViewNewsAdapter;
import com.example.newyorktimes.view.View;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class PresenterLoadNews extends MvpPresenter<View> {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ArrayList<ModelNews.Results> modelNewsList;
    private RecyclerViewNewsAdapter adapter;

    @Inject
    RetrofitDI retrofitDI = new RetrofitDI();

    public void loadNews(){

        compositeDisposable.add(retrofitDI.retrofitNews().retrofit()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(this::handleResponse, this::handleError));
    }

    private void handleResponse(ModelNews results) {
        adapter(results);
    }

    private void handleError(Throwable throwable) {
        Log.e("error responce", "Tag " + throwable.getLocalizedMessage());
    }

    /*private void handleResponse(ModelNews modelNews) {
        adapter(modelNews);
    }*/

    private void adapter(ModelNews results){
        //modelNewsList.add(modelNews);
        modelNewsList = results.getResults();

        adapter = new RecyclerViewNewsAdapter(modelNewsList);
        adapter.notifyDataSetChanged();
        getViewState().adapter(adapter);
    }

}
