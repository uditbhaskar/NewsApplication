package com.saharsh.newsfeed.Adapters;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saharsh.newsfeed.MainActivity;
import com.saharsh.newsfeed.Models.SourceModel;
import com.saharsh.newsfeed.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


//This Adapter holds sources data.....

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<SourceModel> list;
    private Typeface MR, MRR;

    public MyRecyclerViewAdapter(Context context, List<SourceModel> list) {
        this.context = context;
        this.list = list;
        MRR = Typeface.createFromAsset(context.getAssets(), "fonts/myriadregular.ttf");
        MR = Typeface.createFromAsset(context.getAssets(), "fonts/myriad.ttf");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_source_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SourceModel sourceModel = list.get(position);

        holder.source_name.setText(sourceModel.getSource_name());
        holder.source_image.setImageResource(sourceModel.getSource_image());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("source_id",sourceModel.getSource_id());
                intent.putExtra("source_name",sourceModel.getSource_name());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView source_name;
        public CircleImageView source_image;
        public LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);

            source_name = itemView.findViewById(R.id.source_name);
            source_image = itemView.findViewById(R.id.source_image);
            layout = itemView.findViewById(R.id.layout);
            source_name.setTypeface(MRR);
        }
    }

}
