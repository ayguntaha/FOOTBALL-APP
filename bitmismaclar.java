package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bitmismaclar extends AppCompatActivity {
    List<Item4> items = new ArrayList<Item4>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(cal.getTime());
        Date currentDate = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate2 = dateFormat.format(currentDate);
        super.onCreate(savedInstanceState);
        RequestQueue queue = Volley.newRequestQueue(bitmismaclar.this);

// İstek URL'si
        String url = "https://api.football-data.org/v4/matches?dateFrom="+formattedDate+"&dateTo=" + formattedDate2;
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
                            JSONArray matches = response.getJSONArray("matches");
                            System.out.println(matches.getJSONObject(5));
                            for (int i = 0 ; i < matches.length();i++){
                                JSONObject first_match = matches.getJSONObject(i);
                                String utc_date = first_match.getString("utcDate");
                                String tarih = utc_date.substring(0,10);
                                String saat = utc_date.substring(11,16);
                                int int_saat = Integer.parseInt(saat.substring(0,2));
                                int_saat += 3;
                                if(int_saat >= 24 ){
                                    int_saat = 24-int_saat;
                                }
                                String son_saat = Integer.toString(int_saat) + ":" +saat.substring(3,5);
                                JSONObject homeTeamInfo = first_match.getJSONObject("homeTeam");
                                JSONObject awayTeamInfo = first_match.getJSONObject("awayTeam");
                                String homeTeamName = homeTeamInfo.getString("name");
                                String homeTeamImageUrl = homeTeamInfo.getString("crest");
                                String awayTeamName = awayTeamInfo.getString("name");
                                String awayTeamImageUrl = awayTeamInfo.getString("crest");
                                JSONObject scores = first_match.getJSONObject("score");
                                JSONObject fullTimeScore = scores.getJSONObject("fullTime");
                                String versus = "-";
                                String status = first_match.getString("status");
                                if(status.equals("FINISHED")){
                                    int homeScoreInt = fullTimeScore.getInt("home");
                                    int awayScoreInt = fullTimeScore.getInt("away");
                                    String homeScore = Integer.toString(homeScoreInt);
                                    String awayScore = Integer.toString(awayScoreInt);
                                    items.add(new Item4(homeTeamName,awayTeamName,versus,homeTeamImageUrl,awayTeamImageUrl,tarih,son_saat,homeScore,awayScore));
                                    for(Item4 items : items){
                                        System.out.println(items.getHomeTeamName() + items.getAwayTeamName());
                                    }
                                }
                            }

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        setContentView(R.layout.gecis);
                        RecyclerView recyclerView = findViewById(R.id.recyclerview);
                        recyclerView.setLayoutManager(new LinearLayoutManager(bitmismaclar.this));
                        MyAdapter4 adapter = new MyAdapter4( bitmismaclar.this,items);
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