package com.example.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<Film> filmList;
    private LayoutInflater layoutInflater;

    // Konstruktor
    public CustomAdapter(Context context, List<Film> filmList) {
        this.context = context;
        this.filmList = filmList;

        layoutInflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return filmList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Łączenie listy z widokiem
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row, parent, false);
        }
        // Tworzenie referencji do pól TextView
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView year = (TextView) convertView.findViewById(R.id.year);
        TextView director = (TextView) convertView.findViewById(R.id.director);
        // Wypisanie danych filmu
        title.setText(filmList.get(position).getTitle());
        director.setText("Reżyser: " + filmList.get(position).getDirector());
        year.setText("Rok produkcji: " + filmList.get(position).getYear());

        // Usuwanie filmu z listy
        Button deleteButton = (Button) convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filmList.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}

