package com.example.rcarb.popularmovies.Utils;

import android.os.Parcel;



/**
 * Java class that has getter and setter methods to hold movie information.
 *
 */
public class MovieInfoHolder{
    private String moviePoster;
    private String movieTitle;
    private String movieReleaseDate;
    private String movieRating;
    private String movieDescription;

    public MovieInfoHolder(){

    }

    public MovieInfoHolder(String moviePoster,
                           String movieTitle,
                           String movieReleaseDate,
                           String movieRating,
                           String movieDescription){


        this.moviePoster = moviePoster;
        this.movieTitle = movieTitle;
        this.movieReleaseDate = movieReleaseDate;
        this.movieRating = movieRating;
        this.movieDescription =movieDescription;


    }

    protected MovieInfoHolder(Parcel in) {
        moviePoster = in.readString();
        movieTitle = in.readString();
        movieReleaseDate = in.readString();
        movieRating = in.readString();
        movieDescription = in.readString();
    }


    public void setMoviePoster(String moviePoster){
        this.moviePoster = moviePoster;
    }

    public String getMoviePoster(){
        return moviePoster;
    }

    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public String getMovieTitle(){
        return movieTitle;
    }

    public void setMovieReleaseDate(String movieReleaseDate){
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieReleaseDate(){
        return movieReleaseDate;
    }


    public void setMovieRating(String movieRating){
        this.movieRating = movieRating;
    }

    public String getMovieRating(){
        return movieRating;
    }

    public void setMovieDescription(String movieDescription){
        this.movieDescription = movieDescription;
    }

    public String getMovieDescription(){
        return movieDescription;
    }

}

