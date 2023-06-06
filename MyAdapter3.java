package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter3 extends RecyclerView.Adapter<MyViewHolder3> {
    Context context;
    List<Item3> item;
    public MyAdapter3( Context context, List<Item3> item) {

        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder3(LayoutInflater.from(context).inflate(R.layout.activity_matchin_turkey,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 holder, int position) {
        holder.points.setText(item.get(position).getPoint());
        holder.teamName.setText(item.get(position).getTeamName());
        Glide.with(context)
                .load(item.get(position).getImageUrl())
                .into(holder.TeamImage);
        holder.position.setText(item.get(position).getPosition());




    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
