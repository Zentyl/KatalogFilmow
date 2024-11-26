package com.example.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Utworzenie obiektow statycznych
    public static List<Film> filmList = new ArrayList<>();
    public static CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customAdapter = new CustomAdapter(this, filmList);
        // Pozyskanie danych z intencji
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString("title");
            String director = bundle.getString("director");
            int year = bundle.getInt("year");
            // Dodanie do listy nowego filmu
            filmList.add(new Film(title, director, year));
            customAdapter.notifyDataSetChanged();
        }
    }
}

