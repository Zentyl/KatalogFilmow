package com.example.fragments;

import static com.example.fragments.MainActivity.customAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Fragment02 extends Fragment {
    private ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_02, container, false);

        list = (ListView) view.findViewById(R.id.list);
        // Przypisanie adaptera do ListView, co powoduje wyświetlenie listy
        list.setAdapter(customAdapter);

        return view;
    }
}
