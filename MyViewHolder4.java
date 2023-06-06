package com.example.myapplication2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder4 extends RecyclerView.ViewHolder{
    ImageView awayTeamImage,homeTeamImage;
    TextView awayTeamName,homeTeamName,awayTeamScore,homeTeamScore,versus,tarih,saat;
    public MyViewHolder4(@NonNull View itemView) {
        super(itemView);
        tarih = itemView.findViewById(R.id.textView);
        saat = itemView.findViewById(R.id.textView5);
        awayTeamImage = itemView.findViewById(R.id.imageView4);
        homeTeamImage = itemView.findViewById(R.id.imageView3);
        homeTeamScore = itemView.findViewById(R.id.textView9);
        awayTeamScore = itemView.findViewById(R.id.textView12);
        awayTeamName = itemView.findViewById(R.id.textView7);
        homeTeamName = itemView.findViewById(R.id.textView4);
        versus = itemView.findViewById(R.id.textView2);

    }
}
