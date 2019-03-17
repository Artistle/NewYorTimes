package com.example.newyorktimes.data;

import com.example.newyorktimes.models.ModelNews;
import com.orm.SugarRecord;

import java.util.ArrayList;

public class dataRx extends SugarRecord {
    private ArrayList<ModelNews.Results> modelNews;


    public dataRx() {
    }

    public dataRx(ArrayList<ModelNews.Results> modelNews) {
        this.modelNews = modelNews;
    }

    public ArrayList<ModelNews.Results> getModelNews() {
        return modelNews;
    }
}
