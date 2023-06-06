package com.example.myapplication2;

import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tum_takimlar extends AppCompatActivity{
    public  List<Item2> items2 = new ArrayList<Item2>();
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestQueue queue = Volley.newRequestQueue(tum_takimlar.this);

// İstek URL'si
        String url = "https://api.football-data.org/v4/teams?limit=350"; //86 numaralı takımın bilgilerini bastırır.

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
                            JSONArray match = response.getJSONArray("teams");
                            for(int i = 0; i<match.length();i++){
                                JSONObject team = match.getJSONObject(i);
                                int team_id = team.getInt("id");
                                String str_teamId = Integer.toString(team_id);
                                String name = team.getString("name");
                                String imageUrl = team.getString("crest");
                                items2.add(new Item2(name,imageUrl));
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        setContentView(R.layout.gecis);
                        RecyclerView recyclerView = findViewById(R.id.recyclerview);
                        recyclerView.setLayoutManager(new LinearLayoutManager(tum_takimlar.this));
                        MyAdapter2 myAdapter2;
                        MyAdapter2 adapter = new MyAdapter2( tum_takimlar.this,items2);
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