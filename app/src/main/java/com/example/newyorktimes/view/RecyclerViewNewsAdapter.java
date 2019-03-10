package com.example.newyorktimes.view;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newyorktimes.R;
import com.example.newyorktimes.models.ModelNews;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewNewsAdapter extends RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolder> {

    private ArrayList<ModelNews.Results> modelNews;


    public RecyclerViewNewsAdapter(ArrayList<ModelNews.Results> modelNews) {
        this.modelNews = modelNews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        ModelNews.Results model = modelNews.get(i);

        viewHolder.title_news.setText(model.getTitle());
        //viewHolder.url.setText(model.getUrl());

        Glide
                .with(viewHolder.context)
                .load(model.getImage_url())
                .into(viewHolder.image_title);

    }

    @Override
    public int getItemCount() {
        return modelNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title_news;
        private ImageView image_title;
        private TextView url;
        private Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_news = (TextView)itemView.findViewById(R.id.title_news);
            image_title = (ImageView)itemView.findViewById(R.id.image_title_news);
            url = (TextView)itemView.findViewById(R.id.url);
            context = itemView.getContext();
        }
    }
}
