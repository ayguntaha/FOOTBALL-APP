package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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

public class gelecekmaclar extends AppCompatActivity {
    List<Item> items = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gecis);
        RequestQueue queue = Volley.newRequestQueue(gelecekmaclar.this);

// İstek URL'si
        String url = "https://api.football-data.org/v4/matches"; // gelecek maçları yazdırır.

// Başlık
        final String API_KEY = "YOUR API KEY";
        final Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Auth-Token", API_KEY);

// İstek oluşturun
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("MainActivity", response.toString()); //response bir json dosyası ve içinde ne varsa consola bastırır.
                        try {
                            JSONArray match = response.getJSONArray("matches");
                            for(int i = 0; i<match.length();i++){
                                JSONObject matches = match.getJSONObject(i);
                                String utc_date = matches.getString("utcDate");
                                String tarih = utc_date.substring(0,10);
                                String saat = utc_date.substring(11,16);
                                int int_saat = Integer.parseInt(saat.substring(0,2));
                                int_saat += 3;
                                if(int_saat >= 24 ){
                                    int_saat = 24-int_saat;
                                }
                                String son_saat = Integer.toString(int_saat) + ":" +saat.substring(3,5);
                                JSONObject homeTeam = matches.getJSONObject("homeTeam");
                                String homeName = homeTeam.getString("name");
                                JSONObject awayTeam = matches.getJSONObject("awayTeam");
                                String awayName = awayTeam.getString("name");
                                String versus = "-";
                                String homeTeamImageUrl = homeTeam.getString("crest");
                                String awayTeamImageUrl = awayTeam.getString("crest");
                                System.out.println("Home Team Infos " + homeName + " Away Team Infos " + awayName );
                                items.add(new Item(homeName,awayName,versus,homeTeamImageUrl,awayTeamImageUrl,tarih,son_saat));
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        RecyclerView recyclerView = findViewById(R.id.recyclerview);
                        recyclerView.setLayoutManager(new LinearLayoutManager(gelecekmaclar.this));
                        MyAdapter adapter = new MyAdapter(gelecekmaclar.this,items);
                        recyclerView.setAdapter(adapter);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ERROR", error.toString());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };

        queue.add(jsonObjectRequest);

    }
}