package com.example.newyorktimes.retrofitsDI;


import com.example.newyorktimes.retrofit.RetrofitNews;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitDI {
    @Provides
    @Singleton
    public RetrofitNews retrofitNews(){
        RetrofitNews retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/news/v3/content/all/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitNews.class);
        return retrofit;
    }
}
