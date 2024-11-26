package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment01 extends Fragment {

    private EditText titleEdit;
    private EditText directorEdit;
    private EditText yearEdit;
    private Intent mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_01, container, false);
        // Tworzenie referencji do pól EditText
        titleEdit = (EditText) view.findViewById(R.id.title);
        directorEdit = (EditText) view.findViewById(R.id.director);
        yearEdit = (EditText) view.findViewById(R.id.year);

        Button addButton = (Button) view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEdit.getText().toString();
                String director = directorEdit.getText().toString();
                String year = yearEdit.getText().toString();
                // Warunek sprawdzający czy żadne pole nie jest puste
                if (
                        title.matches("") ||
                                director.matches("") ||
                                year.matches("")
                ) {
                    Toast.makeText(view.getContext(), "Nie wprowadzono wszystkich danych",
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    // Utworzenie intencji i przekazanie danych do glownej aktywnosci
                    mainActivity = new Intent(view.getContext(), MainActivity.class);
                    mainActivity.putExtra("title", title);
                    mainActivity.putExtra("director", director);
                    mainActivity.putExtra("year", Integer.parseInt(year));
                    startActivity(mainActivity);
                }
            }
        });
        return view;
    }
}
