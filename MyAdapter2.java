package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyViewHolder2> {
    Context context;
    List<Item2> item;
    public MyAdapter2( Context context, List<Item2> item) {

        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.tumtakimlar,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.TeamName.setText(item.get(position).getTeamName());
        Glide.with(context)
                .load(item.get(position).getTeamImage())
                .into(holder.TeamImage);




    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
