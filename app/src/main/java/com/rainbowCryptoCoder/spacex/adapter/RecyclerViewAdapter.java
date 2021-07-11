package com.rainbowCryptoCoder.spacex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.rainbowCryptoCoder.spacex.model.CrewModel;
import com.rainbowCryptoCoder.spacex.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerHolder> {

    List<CrewModel> models;
    Context context;

    public RecyclerViewAdapter(List<CrewModel> models) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.dashboard_card_view, viewGroup, false);

        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerHolder recyclerHolder, int i) {
        recyclerHolder.view_name.setText(models.get(i).getName());
        recyclerHolder.view_agency.setText(models.get(i).getAgency());
        recyclerHolder.view_link.setText(models.get(i).getWikipedia());

//        // create Picasso.Builder object
//        Picasso.Builder builder = new Picasso.Builder(context);
//
//        // let's change the standard behavior before we create the Picasso instance
//        // for example, let's switch out the standard downloader for the OkHttpClient
//        builder.downloader(new OkHttp3Downloader(context));
//        builder.build().load(models.get(i).getImage())
//                .placeholder(R.drawable.ic_loading)
//                .error(R.drawable.ic_error)
//                .into(recyclerHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder{
        TextView view_name;
        TextView view_agency;
        TextView view_link;
//        ImageView imageView;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            view_name = itemView.findViewById(R.id.tv_name);
            view_agency = itemView.findViewById(R.id.tv_agency);
            view_link = itemView.findViewById(R.id.tv_wikipedia);
//            imageView = itemView.findViewById(R.id.img_view);
        }
    }

}
