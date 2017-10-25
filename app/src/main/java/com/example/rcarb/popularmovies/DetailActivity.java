package com.example.rcarb.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.graphics.Point;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rcarb.popularmovies.Utils.MovieInfoHolder;
import com.example.rcarb.popularmovies.Utils.UriBuilderUtil;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    MovieInfoHolder movieInfoHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = (TextView)findViewById(R.id.movie_title);


        MovieInfoHolder movie =getIntent().getParcelableExtra("movie");
        movieInfoHolder = movie;
        FillDetailTask task = new FillDetailTask();
        task.execute();

    }

    class FillDetailTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {




    //int movieLength;

    String movieDescription;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //dest.writeInt(movieId);
//        dest.writeString(moviePoster);
//        dest.writeString(movieTitle);
//        dest.writeString(movieReleaseDate);
//        dest.writeString(movieRating);
//        dest.writeString(movieDescription);

            //Set Movie Poster
            ImageView posterImage = (ImageView)findViewById(R.id.poster_image);
            Picasso.with(DetailActivity.this).load(UriBuilderUtil.imageDownload(movieInfoHolder.getMoviePoster()))
                    .into(posterImage);
            //Set Movie Title
            TextView movieTitle = (TextView)findViewById(R.id.movie_title);
            movieTitle.setText(movieInfoHolder.getMovieTitle());

            //Set Release Date
            TextView movieReleaseDate = (TextView)findViewById(R.id.relase_date);
            movieReleaseDate.setText(movieInfoHolder.getMovieReleaseDate());

            //Set movie rating
            TextView movieRating = (TextView)findViewById(R.id.user_rating);
            movieRating.setText(movieInfoHolder.getMovieRating());

            //Set Movie Description
            TextView movieDescription = (TextView)findViewById(R.id.movieDescription);
            movieDescription.setText(movieInfoHolder.getMovieDescription());

            String a ="";

            MovieInfoHolder movieInfo = new MovieInfoHolder();
//                movieInfo.setMovieId(movieId);
//                movieInfo.setMoviePoster(moviePoster);
//                movieInfo.setMovieTitle(movieTitle);
//                movieInfo.setMovieReleaseDate(releaseDate);
//
//                movieInfo.setMovieRating(movieRating);
//                movieInfo.setMovieDescription(movieDesctiption);


        }
    }
}
