package com.example.newyorktimes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelNews {
    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("abstract")
    private String description;

    @Expose
    @SerializedName("url")
    private String image_url;

    public ModelNews(String title, String description, String image_url) {
        this.title = title;
        this.description = description;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
