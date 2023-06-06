package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button upcomingmatches,tum_takimlar,btn,bitmis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(MainActivity.this,gelecekmaclar.class);
        Intent i2 = new Intent(MainActivity.this,tum_takimlar.class);
        Intent i3 = new Intent(MainActivity.this,matchinTurkey.class);
        Intent i4 = new Intent(MainActivity.this,bitmismaclar.class);
        setContentView(R.layout.activity_main);
        upcomingmatches = findViewById(R.id.upcomingmatches);
        bitmis = findViewById(R.id.button);
        btn = findViewById(R.id.button2);
        List<Item> items = new ArrayList<Item>();
        List<Item2> items2 = new ArrayList<Item2>();
        tum_takimlar = findViewById(R.id.tum_takimlar);
        final Map<String, String> headers = new HashMap<String, String>();
        upcomingmatches.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i3);

            }});
        tum_takimlar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                startActivity(i2);

            }});
        bitmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i4);
            }
        });



    }
}
