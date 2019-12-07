package com.saharsh.newsfeed;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saharsh.newsfeed.Adapters.MyRecyclerViewAdapter;
import com.saharsh.newsfeed.Models.SourceModel;

import java.util.ArrayList;

public class SourceActivity extends AppCompatActivity {

    Typeface MR, MRR;
    MyRecyclerViewAdapter adapter;
    ArrayList<SourceModel> list = new ArrayList<SourceModel>();
    ArrayList<SourceModel> globallist = new ArrayList<SourceModel>();
    LinearLayout business, entertainment, health, science, sports, technology;
    RelativeLayout all_news;
    TextView business_name, entertainment_name, health_name, science_name, sports_name, technology_name;
    int numberOfColumns = 4;
    TextView toolbar_title;
    ImageView close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);

        //Initialising Views and TypeFaces...
        MRR = Typeface.createFromAsset(getAssets(), "fonts/myriadregular.ttf");
        MR = Typeface.createFromAsset(getAssets(), "fonts/myriad.ttf");

        toolbar_title = findViewById(R.id.toolbar_title);
        close = findViewById(R.id.close);

        all_news = findViewById(R.id.all_news);

        business = findViewById(R.id.business);
        entertainment = findViewById(R.id.entertainment);
        health = findViewById(R.id.health);
        science = findViewById(R.id.science);
        sports = findViewById(R.id.sports);
        technology = findViewById(R.id.technology);

        business_name = findViewById(R.id.buisness_name);
        entertainment_name = findViewById(R.id.entertainment_name);
        health_name = findViewById(R.id.health_name);
        science_name = findViewById(R.id.science_name);
        sports_name = findViewById(R.id.sports_name);
        technology_name = findViewById(R.id.technology_name);

        toolbar_title.setTypeface(MR);
        business_name.setTypeface(MRR);
        entertainment_name.setTypeface(MRR);
        health_name.setTypeface(MRR);
        science_name.setTypeface(MRR);
        sports_name.setTypeface(MRR);
        technology_name.setTypeface(MRR);

        //Click Listeners for Categories....
        all_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SourceActivity.this, NewsFeedActivity.class);
                startActivity(intent);
            }
        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                intent.putExtra("category","business");
                startActivity(intent);
            }
        });

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                intent.putExtra("category","entertainment");
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                intent.putExtra("category","health");
                startActivity(intent);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                intent.putExtra("category","science");
                startActivity(intent);
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                intent.putExtra("category","sports");
                startActivity(intent);
            }
        });

        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                intent.putExtra("category","technology");
                startActivity(intent);
            }
        });

        // data to populate the RecyclerView with
        SourceModel sourceModel = new SourceModel("The Times of India", R.drawable.toi, "the-times-of-india");
        list.add(sourceModel);
        sourceModel = new SourceModel("The Hindu", R.drawable.hindu, "the-hindu");
        list.add(sourceModel);
        sourceModel = new SourceModel("BBC News", R.drawable.bbcworldnews, "bbc-news");
        list.add(sourceModel);
        sourceModel = new SourceModel("Buzzfeed", R.drawable.buzzfeed, "buzzfeed");
        list.add(sourceModel);
        sourceModel = new SourceModel("IGN", R.drawable.ign, "ign");
        list.add(sourceModel);
        sourceModel = new SourceModel("The New York Times", R.drawable.newyorktimes, "the-new-york-times");
        list.add(sourceModel);
        sourceModel = new SourceModel("CNN", R.drawable.cnn, "cnn");
        list.add(sourceModel);
        sourceModel = new SourceModel("TechCrunch", R.drawable.techcrunch, "techcrunch");
        list.add(sourceModel);
        sourceModel = new SourceModel("CNBC", R.drawable.cnbc, "cnbc");
        list.add(sourceModel);
        sourceModel = new SourceModel("USA Today", R.drawable.usatoday, "usa-today");
        list.add(sourceModel);
        sourceModel = new SourceModel("ABC News", R.drawable.abcnews, "abc-news");
        list.add(sourceModel);
        sourceModel = new SourceModel("BBC Sport", R.drawable.bbcsport, "bbc-sport");
        list.add(sourceModel);

        /*sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);
        sourceModel = new SourceModel("AAJ TAK", R.drawable.ic_launcher_background, "the-times-of-india");
        globallist.add(sourceModel);*/

        // set up the RecyclerView
        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView1.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, list);
        recyclerView1.setAdapter(adapter);

      /*  // set up the RecyclerView
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyclerview2);
        recyclerView2.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, globallist);
        recyclerView2.setAdapter(adapter);*/
    }
}
