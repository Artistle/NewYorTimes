package com.example.newyorktimes.retrofit;

import com.example.newyorktimes.models.ModelNews;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Retrofit {

    @GET("testTask.json")
    Observable<ModelNews> retrofit;
}
