package com.myapplicationdev.android.p06_ps;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;
import java.util.Random;

public class Frag4 extends Fragment implements RssReader.RssCallback{

    RssReader rssReader;
    TextView tvTitle, tvTitle2;
    WebView description, description2;
    Button btnLoadRSS, btnChangeColor;
    LinearLayout ll4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        tvTitle = view.findViewById(R.id.tvTitle);
        description = view.findViewById(R.id.description);
        tvTitle2 = view.findViewById(R.id.tvTitle2);
        description2 = view.findViewById(R.id.description2);
        btnLoadRSS = view.findViewById(R.id.btnLoadRSS);
        btnChangeColor = view.findViewById(R.id.btnChangeColor4);
        ll4 = view.findViewById(R.id.linearLayout4);

        rssReader = new RssReader( this);

        btnLoadRSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] url = {"https://www.singstat.gov.sg/rss"};
                rssReader.loadFeeds(url);
            }
        });

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                ll4.setBackgroundColor(color);
            }
        });

        return view;
    }

    private void loadFeeds(String[] urls) {
        rssReader.loadFeeds(urls);
    }

    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {
        RSS currItem = rssList.get(0);

        int total = currItem.getChannel().getItems().size();

        Random rnd = new Random();
        int randomItem = rnd.nextInt(total + 1);
        int randomItem2 = rnd.nextInt(total + 1);

        String title = currItem.getChannel().getItems().get(randomItem).getTitle();
        String desc = currItem.getChannel().getItems().get(randomItem).getDescription();
        tvTitle.setText(title);
        description.loadData(desc, "text/html; charset=utf-8", "utf-8");


        String title2 = currItem.getChannel().getItems().get(randomItem2).getTitle();
        String desc2 = currItem.getChannel().getItems().get(randomItem2).getDescription();
        tvTitle2.setText(title2);
        description2.loadData(desc2, "text/html; charset=utf-8", "utf-8");
    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {
        Toast.makeText(getActivity(), "RSS Loading Failed", Toast.LENGTH_LONG).show();
    }
}