package com.example.myapplication2;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Item> item;
    public MyAdapter(Context context, List<Item> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_gelecekmaclar,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.homeTeamName.setText(item.get(position).getHomeTeamName());
        holder.awayTeamName.setText(item.get(position).getAwayTeamName());
        holder.saat.setText(String.valueOf(item.get(position).getSaat()));
        holder.tarih.setText(item.get(position).getTarih());
        //holder.awayTeamScore.setText(String.valueOf(item.get(position).getAwayTeamScore()));
        Glide.with(context)
                .load(item.get(position).getHomeTeamImage())
                .into(holder.homeTeamImage);
        Glide.with(context)
                .load(item.get(position).getAwayTeamImage())
                .into(holder.awayTeamImage);


    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
