package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder3 extends RecyclerView.ViewHolder {
    ImageView TeamImage;
    TextView teamName,points,position;

    public MyViewHolder3(@NonNull View itemView) {
        super(itemView);

        TeamImage = itemView.findViewById(R.id.imageView);
        teamName = itemView.findViewById(R.id.textView6);
        position = itemView.findViewById(R.id.textView10);
        points = itemView.findViewById(R.id.textView11);




    }


}