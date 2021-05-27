package com.myapplicationdev.android.p06_ps;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Frag1 extends Fragment {
    Button btnChangeColor1;
    TextView tv1;
    LinearLayout ll1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tv1 = view.findViewById(R.id.textView1);
        btnChangeColor1 = view.findViewById(R.id.btnChangeColor1);
        ll1 = view.findViewById(R.id.linearLayout1);
        tv1.setText("Coca-Cola would be green if colouring weren’t added to it.");
        btnChangeColor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ll1.setBackgroundColor(color);
            }
        });
        return view;
    }
}