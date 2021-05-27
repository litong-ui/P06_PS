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

public class Frag2 extends Fragment {

    Button btnChangeColor2;
    TextView tv2;
    LinearLayout ll2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        tv2 = view.findViewById(R.id.textView2);
        btnChangeColor2 = view.findViewById(R.id.btnChangeColor2);
        ll2 = view.findViewById(R.id.linearLayout2);
        tv2.setText("Of all the words in the English language, the word 'set' has the most definitions!");
        btnChangeColor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ll2.setBackgroundColor(color);
//                ll2.setBackgroundColor(Color.parseColor("#91A0F1"));
            }
        });
        return view;
    }
}