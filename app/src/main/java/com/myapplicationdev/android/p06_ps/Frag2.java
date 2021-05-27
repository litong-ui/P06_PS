package com.myapplicationdev.android.p06_ps;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class Frag2 extends Fragment {

    Button btnChangeColor2;
    TextView tv2;
    LinearLayout ll2;
    ImageView iv, iv2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        tv2 = view.findViewById(R.id.textView2);
        btnChangeColor2 = view.findViewById(R.id.btnChangeColor2);
        ll2 = view.findViewById(R.id.linearLayout2);
        tv2.setText("Of all the words in the English language, the word 'set' has the most definitions!");

        iv = view.findViewById(R.id.iv);
        iv2 = view.findViewById(R.id.iv2);

        btnChangeColor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ll2.setBackgroundColor(color);
//                ll2.setBackgroundColor(Color.parseColor("#91A0F1"));
            }
        });

        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Arctic-Foxs-Colorful-Fur.png";
        Picasso.with(getContext()).load(imageUrl).into(iv);

        String imageUrl2 = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Pop-Tarts-All-Sold-Out.png";
        Picasso.with(getContext()).load(imageUrl2).into(iv2);

        return view;
    }
}