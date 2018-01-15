package com.example.rcarb.popularmovies;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rcarb.popularmovies.Utils.MovieInfoHolder;
import com.example.rcarb.popularmovies.Utils.UriBuilderUtil;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private MovieInfoHolder movieInfoHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getActivityIntent();
        setupLayout();

    }
    //Gets the intent extras and sets up a MovieInfoHolder object.
    private void getActivityIntent(){
        Intent intent = getIntent();
        movieInfoHolder = new MovieInfoHolder();
        movieInfoHolder.setMoviePoster(intent.getStringExtra("moviePoster"));
        movieInfoHolder.setMovieTitle(intent.getStringExtra("movieTitle"));
        movieInfoHolder.setMovieReleaseDate(intent.getStringExtra("movieRelease"));
        movieInfoHolder.setMovieRating(intent.getStringExtra("movieRating"));
        movieInfoHolder.setMovieDescription(intent.getStringExtra("movieDescription"));

        setupLayout();
    }

    private void setupLayout(){
        //Set Movie Poster
        ImageView posterImage = (ImageView)findViewById(R.id.poster_image);
        Picasso.with(DetailActivity.this).load(UriBuilderUtil.imageDownload(movieInfoHolder.getMoviePoster()))
                .into(posterImage);
        //Set Movie Title
        TextView movieTitle = (TextView)findViewById(R.id.movie_title);
        movieTitle.setText(movieInfoHolder.getMovieTitle());

        //Set Release Date
        TextView movieReleaseDate = (TextView)findViewById(R.id.release_date);
        String dateReleased = movieInfoHolder.getMovieReleaseDate();
        String extractYear = dateReleased.substring(0,4);
        movieReleaseDate.setText(extractYear);

        //Set movie rating
        TextView movieRating = (TextView)findViewById(R.id.user_rating);
        movieRating.setText(movieInfoHolder.getMovieRating());
        movieRating.setTypeface(null, Typeface.BOLD_ITALIC);

        //Set Movie Description
        TextView movieDescription = (TextView)findViewById(R.id.movieDescription);
        movieDescription.setText(movieInfoHolder.getMovieDescription());
    }

}
