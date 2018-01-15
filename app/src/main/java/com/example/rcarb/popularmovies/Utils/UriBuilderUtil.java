package com.example.rcarb.popularmovies.Utils;
import android.net.Uri;

import com.example.rcarb.popularmovies.BuildConfig;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rcarb on 10/18/2017.
 * Java class that builds the Uri, to query a list of movies, or single movie information.
 */

public class UriBuilderUtil {



    private static String mQueryWithAPIKey = "api_key";
    private final static String BASE_POPULAR_URL = "http://api.themoviedb.org/3/movie/popular";
    private final static String BASE_RATED_URL = "http://api.themoviedb.org/3/movie/top_rated";
    private static String apiKey = BuildConfig.API_KEY;

    //variables for parsing image
    private static final String BASE_URL_FOR_IMAGE_PARSING = "http://image.tmdb.org/t/p/w185/";





    public static URL buildPopularUri(){

        Uri builtUri =
                Uri.parse(BASE_POPULAR_URL).buildUpon()
                        .appendQueryParameter(mQueryWithAPIKey, apiKey)
                        .build();

        URL url = null;
        try{
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  url;
    }

    public static URL buildRatedUri(){

        Uri builtUri =
                Uri.parse(BASE_RATED_URL).buildUpon()
                        .appendQueryParameter(mQueryWithAPIKey, apiKey)
                        .build();

        URL url = null;
        try{
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  url;
    }



    public static String imageDownload(String image){
        return BASE_URL_FOR_IMAGE_PARSING + image;
    }
}
