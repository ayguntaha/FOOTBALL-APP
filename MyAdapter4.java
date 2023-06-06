package com.example.myapplication2;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MyAdapter4 extends RecyclerView.Adapter<MyViewHolder4> {
    Context context;
    List<Item4> item;
    public MyAdapter4(Context context, List<Item4> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public MyViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder4(LayoutInflater.from(context).inflate(R.layout.activity_bitmismaclar,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder4 holder, int position) {
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
        holder.awayTeamScore.setText(String.valueOf(item.get(position).getAwayTeamScore()));
        holder.homeTeamScore.setText(String.valueOf(item.get(position).getHomeTeamScore()));



    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
