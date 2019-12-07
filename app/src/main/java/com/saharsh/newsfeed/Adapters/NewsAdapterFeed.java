package com.saharsh.newsfeed.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saharsh.newsfeed.Dialogs.CustomDialogBox;
import com.saharsh.newsfeed.Models.NewsModel;
import com.saharsh.newsfeed.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapterFeed extends RecyclerView.Adapter<NewsAdapterFeed.ViewHolder> {

    private Context context;
    private Activity activity;
    private List<NewsModel> list;
    Typeface MR, MRR;

    public NewsAdapterFeed(Activity activity, Context context, List<NewsModel> list) {
        this.context = context;
        this.list = list;
        this.activity = activity;

        //Instantiating TypeFaces...
        MRR = Typeface.createFromAsset(activity.getAssets(), "fonts/myriadregular.ttf");
        MR = Typeface.createFromAsset(activity.getAssets(), "fonts/myriad.ttf");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.all_news_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final NewsModel newsModel = list.get(position);

        holder.news_title.setText(newsModel.getNews_title());
        holder.news_time.setText("Published on "+newsModel.getNews_time());
        holder.news_desc.setText(newsModel.getNews_desc());

        holder.news_title.setTypeface(MR);
        holder.news_time.setTypeface(MRR);

        if(newsModel.getNews_urlToImage()!= null && !newsModel.getNews_urlToImage().isEmpty()) {
            //Using Picasso to Load Images....
            Picasso.with(context).load(newsModel.getNews_urlToImage()).placeholder(R.drawable.newspaper).into(holder.news_image);
        }
        holder.news_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowDetailsDialog(newsModel);
                /*Intent intent = new Intent(context, NewsDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("title", newsModel.getNews_title());
                b.putString("time" , newsModel.getNews_time());
                b.putString("urlToImage", newsModel.getNews_urlToImage());
                b.putString("author" , newsModel.getNews_author());
                b.putString("desc" , newsModel.getNews_desc());
                b.putString("content" , newsModel.getNews_content());
                b.putString("url" , newsModel.getNews_url());

                intent.putExtras(b);
                context.startActivity(intent);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView news_title, news_time, news_desc;
        public ImageView news_image;
        public LinearLayout news_layout;

        public ViewHolder(View itemView) {
            super(itemView);

            news_title = itemView.findViewById(R.id.news_title);
            news_image = itemView.findViewById(R.id.news_image);
            news_time = itemView.findViewById(R.id.news_time);
            news_layout = itemView.findViewById(R.id.news_layout);
            news_desc = itemView.findViewById(R.id.news_desc);
        }
    }

    //Creating CustomDialog with Fragment Transaction....
    private void ShowDetailsDialog(NewsModel newsModel) {
        //getActivity().getSupportFragmentManager()
        FragmentTransaction transaction = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        CustomDialogBox customDetailsDialog = new CustomDialogBox();
        transaction.add(customDetailsDialog, "loading");
        Bundle b = new Bundle();
        b.putString("title", newsModel.getNews_title());
        b.putString("time" , newsModel.getNews_time());
        b.putString("urlToImage", newsModel.getNews_urlToImage());
        b.putString("author" , newsModel.getNews_author());
        b.putString("desc" , newsModel.getNews_desc());
        b.putString("content" , newsModel.getNews_content());
        b.putString("url" , newsModel.getNews_url());

        customDetailsDialog.setArguments(b);

        transaction.commitAllowingStateLoss();
    }


}