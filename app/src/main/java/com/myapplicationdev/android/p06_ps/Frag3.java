package com.myapplicationdev.android.p06_ps;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Frag3 extends Fragment {

    Button btnChangeColor3;
    TextView tv3;
    LinearLayout ll3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);

        tv3 = view.findViewById(R.id.textView3);
        btnChangeColor3 = view.findViewById(R.id.btnChangeColor3);
        ll3 = view.findViewById(R.id.linearLayout3);
        tv3.setText("Queen Elizabeth I regarded herself as a paragon of cleanliness. She declared that she bathed once every three months, whether she needed it or not");
        btnChangeColor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll3.setBackground(Drawable.createFromPath("#97EF40"));
            }
        });
        return view;
    }
}