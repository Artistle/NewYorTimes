package com.example.newyorktimes.retrofit;

import com.example.newyorktimes.models.ModelNews;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitNews {

    @GET("all.json?api-key=IV83NfimcfZqZ8Et1QEnoYxaRAP9lhWh")
    Observable<ModelNews> retrofit();
}
