package com.example.rcarb.popularmovies.Utils;

import android.content.ContentValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by rcarb on 10/19/2017.
 */

public class JsonUtils {

    public static ArrayList<MovieInfoHolder> parseJsonObject(String jsonDataString) throws JSONException {

        JSONObject jsonData = new JSONObject(jsonDataString);


        JSONArray resultsInData = jsonData.getJSONArray("results");

        //StringArray to hold the movie poster
        ArrayList<MovieInfoHolder> movieArray = new ArrayList<>();
        for (int i = 0; i < resultsInData.length(); i++){

            JSONObject object = resultsInData.getJSONObject(i);
            if (object != null){

                int movieId =(int)object.get("id");
                String moviePoster =(String)object.get("poster_path");
                String movieTitle = (String)object.get("title");
                String releaseDate = (String)object.get("release_date");

                //TODO: need to add MovieLength.

                String movieRating = object.get("vote_average").toString();
                String movieDesctiption = (String)object.get("overview");

                //Add the movie values into MovieInfoHolder.
                MovieInfoHolder movieInfo = new MovieInfoHolder();
                movieInfo.setMovieId(movieId);
                movieInfo.setMoviePoster(moviePoster);
                movieInfo.setMovieTitle(movieTitle);
                movieInfo.setMovieReleaseDate(releaseDate);

                movieInfo.setMovieRating(movieRating);
                movieInfo.setMovieDescription(movieDesctiption);


                movieArray.add(i,movieInfo);

            }
        }
        return movieArray;
    }

}
//    public int idOfMovie;
//    public String moviePoster;
//    public String titleOfMovie;
//    public String releaseDate;
//    public int movieLength;
//    public int rating;
//    public String movieDescription;