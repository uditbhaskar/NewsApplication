package com.saharsh.newsfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    TextView title, descp, toolbar_title, content;
    ImageView close, image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        //Initialising views...
        title = findViewById(R.id.title);
        descp = findViewById(R.id.description);
        toolbar_title = findViewById(R.id.toolbar_title);
        close = findViewById(R.id.close);
        image = findViewById(R.id.image);
        content = findViewById(R.id.content);


        if(getIntent() != null && getIntent().getExtras()!= null)
        {
            Bundle b = getIntent().getExtras();
            title.setText(b.getString("title"));
            descp.setText(b.getString("desc"));
            content.setText(b.getString("content"));
            //Setting image using Picasso.
            Picasso.with(this).load(b.getString("urlToImage")).placeholder(R.drawable.search).into(image);

           /* b.putString("title", newsModel.getNews_title());
            b.putString("time" , newsModel.getNews_time());
            b.putString("urlToImage", newsModel.getNews_urlToImage());
            b.putString("author" , newsModel.getNews_author());
            b.putString("desc" , newsModel.getNews_desc());
            b.putString("content" , newsModel.getNews_content());
            b.putString("url" , newsModel.getNews_url());*/
        }

    }
}
