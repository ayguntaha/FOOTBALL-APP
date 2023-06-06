package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder2 extends RecyclerView.ViewHolder {
    ImageView TeamImage;
    TextView TeamName;

    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        TeamImage = itemView.findViewById(R.id.imageView);
       TeamName = itemView.findViewById(R.id.textView6);



    }


}