package com.example.rcarb.popularmovies.Utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rcarb on 10/21/2017.
 */

public class MovieInfoHolder implements Parcelable {
    private int movieId;
    private String moviePoster;
    private String movieTitle;
    private String movieReleaseDate;
    private int movieLength;
    private String movieRating;
    private String movieDescription;

    public MovieInfoHolder(){

    }

    public MovieInfoHolder(int movieId,
                           String moviePoster,
                           String movieTitle,
                           String movieReleaseDate,
                           int movieLength,
                           String movieRating,
                           String movieDescription){


        this.movieId = movieId;
        this.moviePoster = moviePoster;
        this.movieTitle = movieTitle;
        this.movieReleaseDate = movieReleaseDate;
        this.movieLength = movieLength;
        this.movieRating = movieRating;
        this.movieDescription =movieDescription;


    }

    protected MovieInfoHolder(Parcel in) {
        movieId = in.readInt();
        moviePoster = in.readString();
        movieTitle = in.readString();
        movieReleaseDate = in.readString();
        movieLength = in.readInt();
        movieRating = in.readString();
        movieDescription = in.readString();
    }


    public void setMovieId(int movieId){
        this.movieId = movieId;

    }
    public int getMovieId(){
        return movieId;
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

    public void setMovieLength(int movieLength){
        this.movieLength = movieLength;
    }

    public int getMovieLength(){
        return movieLength;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(movieId);
        dest.writeString(moviePoster);
        dest.writeString(movieTitle);
        dest.writeString(movieReleaseDate);
        //TODO: need to implement the movie length.

        dest.writeString(movieRating);
        dest.writeString(movieDescription);
    }
    //Implements the parcel creator
    public static final Creator<MovieInfoHolder> CREATOR = new Creator<MovieInfoHolder>() {
        @Override
        public MovieInfoHolder createFromParcel(Parcel in) {
            return new MovieInfoHolder(in);
        }

        @Override
        public MovieInfoHolder[] newArray(int size) {
            return new MovieInfoHolder[size];
        }
    };
}

