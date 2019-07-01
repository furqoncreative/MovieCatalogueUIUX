package com.furconcreative.submission2.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.furconcreative.submission2.R;
import com.furconcreative.submission2.activities.DetailTvshowActivity;
import com.furconcreative.submission2.models.TvShow;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {


    private Context context;
    ArrayList<TvShow> tvShowsList;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<TvShow> getTvShowsList() {
        return tvShowsList;
    }

    public void setTvShowsList(ArrayList<TvShow> tvShowsList) {
        this.tvShowsList = tvShowsList;
    }

    public TvShowAdapter(Context context) {
        this.context = context;
        tvShowsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TvShow tvShow = tvShowsList.get(position);
        holder.imgThumnail.setImageResource(tvShow.getThumbnail());
        holder.txtTitle.setText(tvShow.getTitle());
        holder.txtCast.setText(tvShow.getCast());
        holder.txtDirector.setText(tvShow.getDirector());
        holder.txtRating.setText(tvShow.getRating());
        holder.txtSinopsis.setText(tvShow.getSinopsis().substring(0, 50) + " .. ");
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailTvshowActivity.class);
                intent.putExtra(DetailTvshowActivity.TV_SHOW, tvShow);
                context.startActivity(intent);
            }
        });
        holder.btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(tvShow.getTrailer()));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getTvShowsList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_thumnail)
        ImageView imgThumnail;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_rating)
        TextView txtRating;
        @BindView(R.id.txt_director)
        TextView txtDirector;
        @BindView(R.id.txt_cast)
        TextView txtCast;
        @BindView(R.id.txt_sinopsis)
        TextView txtSinopsis;
        @BindView(R.id.btn_detail)
        Button btnDetail;
        @BindView(R.id.btn_trailer)
        Button btnTrailer;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
