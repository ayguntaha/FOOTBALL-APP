package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

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

public class matchinTurkey extends AppCompatActivity {



    public  List<Item3> items = new ArrayList<Item3>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    RequestQueue queue = Volley.newRequestQueue(matchinTurkey.this);

// İstek URL'si
    String url = "https://api.football-data.org/v4/competitions/PL/standings"; //86 numaralı takımın bilgilerini bastırır.
//
        //https://api.football-data.org/v4/competitions/CL/matches
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
                        JSONArray standings = response.getJSONArray("standings");
                        JSONObject standings2 = standings.getJSONObject(0);
                        System.out.println("girdi");
                        JSONArray table = standings2.getJSONArray("table");
                        for (int i = 0 ; i < table.length();i++){
                            JSONObject team = table.getJSONObject(i);
                            int position = team.getInt("position");
                            JSONObject team_info = team.getJSONObject("team");
                            String teamName = team_info.getString("name");
                            String imageUrl = team_info.getString("crest");
                            int point = team.getInt("points");
                            String point_str = Integer.toString(point);
                            String position_str = Integer.toString(position);
                            items.add(new Item3(position_str,point_str,teamName,imageUrl));
                        }
                        System.out.println("cikti");



                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    setContentView(R.layout.gecis2);
                    RecyclerView recyclerView = findViewById(R.id.recyclerview2);
                    recyclerView.setLayoutManager(new LinearLayoutManager(matchinTurkey.this));
                    MyAdapter3 adapter = new MyAdapter3( matchinTurkey.this,items);
                    recyclerView.setAdapter(adapter);
                    System.out.println("cikti2");




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