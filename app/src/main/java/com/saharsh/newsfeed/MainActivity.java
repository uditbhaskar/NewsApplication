package com.saharsh.newsfeed;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.saharsh.newsfeed.Adapters.NewsAdapter;
import com.saharsh.newsfeed.Models.NewsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
//b48821f1a4844343b750fb3383758e07 key

    

    RecyclerView recycler_view;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<NewsModel> newsList;
    private RecyclerView.Adapter adapter;
    public Toolbar toolbar;

    String TAG = "result";
    ProgressDialog pDialog;
    ProgressBar progressBar;
    int count;
    String status;
    String url;
    Typeface MR, MRR;
    ImageView back, reload;
    TextView title;


    //https://newsapi.org/v2/top-headlines?country=in&apiKey=b48821f1a4844343b750fb3383758e07

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialising typefaces and views...
        MRR = Typeface.createFromAsset(getAssets(), "fonts/myriadregular.ttf");
        MR = Typeface.createFromAsset(getAssets(), "fonts/myriad.ttf");

        back = findViewById(R.id.close);
        reload = findViewById(R.id.reload);
        title = findViewById(R.id.toolbar_title);
        progressBar = findViewById(R.id.progressbar);
        recycler_view=findViewById(R.id.news_list);

        title.setTypeface(MR);

        back.setImageResource(R.drawable.arrow3);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Reloading Functionality by making a call...
        reload.setVisibility(View.VISIBLE);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //calling....
                Toast.makeText(getBaseContext(),"Loading",Toast.LENGTH_SHORT).show();
                calling();
            }
        });


        //Checking from where we got the intent...
        if(getIntent()!= null && getIntent().getExtras()!= null)
        {
            if(getIntent().getExtras().getString("source_id")!= null && !getIntent().getExtras().getString("source_id").isEmpty()) {

                String source_id = getIntent().getExtras().getString("source_id");
                String source_name = getIntent().getExtras().getString("source_name");
                title.setText(source_name);
                url = "https://newsapi.org/v2/top-headlines?sources=" + source_id + "&apiKey=b48821f1a4844343b750fb3383758e07";
            }
            else if(getIntent().getExtras().getString("category")!= null && !getIntent().getExtras().getString("category").isEmpty())
            {
                String category = getIntent().getExtras().getString("category");
                title.setText(category);
                url = "https://newsapi.org/v2/top-headlines?category=" + category + "&apiKey=b48821f1a4844343b750fb3383758e07";

            }

        }




        newsList = new ArrayList<>();
        adapter = new NewsAdapter(this,this,newsList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(recycler_view.getContext(), linearLayoutManager.getOrientation());

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(linearLayoutManager);
        recycler_view.addItemDecoration(dividerItemDecoration);
        recycler_view.setAdapter(adapter);
        // Pass results to ViewPagerAdapter Class



        //making a call
        calling();

        //adapter.notifyDataSetChanged();
        //Pager.setAdapter(adapter);





    }


    //Making call to Server using Volley(no need to handle threads manually)...
    public void calling(){

        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";

//        String url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=b48821f1a4844343b750fb3383758e07";

        if(url == null && url.isEmpty())
        {
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
            //url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=b48821f1a4844343b750fb3383758e07";
        }
        /*pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();*/
        progressBar.setVisibility(View.VISIBLE);


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            count = Integer.valueOf(response.getString("totalResults"));
                            status = response.getString("status");
                            Log.d("result","count "+count);
                            Log.d("result","status "+status);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");
                            Log.d("result","response size "+jsonArray.length());

                            for(int i =0; i<jsonArray.length(); i++)
                            {
                                JSONObject obj = jsonArray.getJSONObject(i);


                                NewsModel newsmodel = new NewsModel();
                                newsmodel.setNews_title(obj.getString("title"));
                                newsmodel.setNews_desc(obj.getString("description"));
                                newsmodel.setNews_author(obj.getString("author"));
                                newsmodel.setNews_content(obj.getString("content"));
                                newsmodel.setNews_url(obj.getString("url"));
                                newsmodel.setNews_urlToImage(obj.getString("urlToImage"));

                                String dateTime = dateTimeFormat(obj.getString("publishedAt"));
                                newsmodel.setNews_time(dateTime);

                                JSONObject src_obj = obj.getJSONObject("source");
                                newsmodel.setNews_source_name(src_obj.getString("name"));

                                newsList.add(newsmodel);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, response.toString());
                        adapter.notifyDataSetChanged();
                        /*pDialog.hide();*/
                        progressBar.setVisibility(View.GONE);

                        Log.d("result","model size "+newsList.size());



                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
//                pDialog.hide();
                  progressBar.setVisibility(View.GONE);

            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);



//viewPager.setPageTransformer(false, new ZoomOutTransformer());
//viewPager.setPageTransformer(true, new StackTransformer());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //Changing datetime fetched from json to user friendly time using SimpleDateFormat Class.......
    public String dateTimeFormat(String dateString) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString.substring(0, 10) + " " + dateString.substring(11, 16));
            String formattedDate = new SimpleDateFormat("dd MMM''yy, hh:mm aa").format(date);
            String newformattedDate = formattedDate.replace("AM", "am").replace("PM", "pm");
            Log.d("upisdk", "System.currentTimeMillis(): " + System.currentTimeMillis() + "parsed datetime: " + formattedDate);
            return newformattedDate;


        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
