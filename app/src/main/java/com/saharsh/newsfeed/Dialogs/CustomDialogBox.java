package com.saharsh.newsfeed.Dialogs;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saharsh.newsfeed.Fragments.BaseDialogFragment;
import com.saharsh.newsfeed.R;
import com.squareup.picasso.Picasso;

//Custom Dialog Box to show news in details...
public class CustomDialogBox extends BaseDialogFragment implements
        android.view.View.OnClickListener {

    Typeface MR, MRR;
    public Dialog d;
    TextView title, descp, content, openUrl;
    View v;
    int check;
    ImageView close, image;
    Bundle bundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_news_details, container, false);
        init_views();
        return v;
    }

    //Initialising Views....
    private void init_views() {

        MRR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myriadregular.ttf");
        MR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myriad.ttf");
        title = v.findViewById(R.id.title);
        descp = v.findViewById(R.id.description);
        content = v.findViewById(R.id.content);
        image = v.findViewById(R.id.image);
        openUrl = v.findViewById(R.id.openUrl);
        close = v.findViewById(R.id.close);

        if (bundle.getString("title") != null && !bundle.getString("title").equals("null")) {
            title.setText(bundle.getString("title"));
        }

        if (bundle.getString("desc") != null && !bundle.getString("desc").equals("null")) {
            descp.setText(bundle.getString("desc"));
        }
        if (bundle.getString("content") != null && !bundle.getString("content").equals("null")) {
            content.setText(bundle.getString("content"));
        }
        //Loading Image through Picasso....
        Picasso.with(getContext()).load(bundle.getString("urlToImage")).placeholder(R.drawable.search).into(image);

        openUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToBrowser(bundle.getString("url"));
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        title.setTypeface(MR);
        descp.setTypeface(MRR);
        content.setTypeface(MRR);

        //button.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
           /* case R.id.button:
                dismiss();
                break;*/
        }
    }

    //Sending Intent to Browser...
    public void sendToBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}

