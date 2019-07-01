package com.furconcreative.submission2.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.furconcreative.submission2.R;
import com.furconcreative.submission2.models.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String MOVIE = "movie";
    @BindView(R.id.iv_thumbnail)
    ImageView ivThumbnail;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_rating)
    TextView tvRating;
    @BindView(R.id.tv_director)
    TextView tvDirector;
    @BindView(R.id.tv_cast)
    TextView tvCast;
    @BindView(R.id.tv_duration)
    TextView tvDuration;
    @BindView(R.id.tv_genre)
    TextView tvGenre;
    @BindView(R.id.tv_release)
    TextView tvRelease;
    @BindView(R.id.tv_sinopsis)
    TextView tvSinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        ButterKnife.bind(this);
        Movie movie = getIntent().getParcelableExtra(MOVIE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(movie.getTitle());
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvTitle.setText(movie.getTitle());
        tvCast.setText(movie.getCast());
        tvDirector.setText(movie.getDirector());
        tvSinopsis.setText(movie.getSinopsis());
        tvRelease.setText(movie.getReleaseDate());
        tvDuration.setText(movie.getDuration());
        tvRating.setText(movie.getRating());
        tvGenre.setText(movie.getGenre());
        Glide.with(this).load(movie.getThumbnail()).into(ivThumbnail);
    }

    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}
