package com.example.rcarb.popularmovies.Utils;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rcarb on 10/18/2017.
 */

public class UriBuilderUtil {
    //http://api.themoviedb.org/3/movie/popular?api_key=[YOUR_API_KEY]

    private static String mScheme ="http";
    private static String mAuthority ="api.themoviedb.org";
    private static String mPathDirectory ="3";
    private static String mPathDirectoryMovie ="movie";
    private static String mPathDirectoryPolular ="poular";
    private static String mQueryWithAPIKey = "api_key";
    private final static String API_KEY = "80c08a7febb5450bffb919f2c3416264";
    private final static String BASE_POPULAR_URL = "http://api.themoviedb.org/3/movie/popular";
    private final static String BASE_RATED_URL = "http://api.themoviedb.org/3/movie/top_rated";


    //variables for parsing image
    private static final String BASE_URL_FOR_IMAGE_PARSING = "http://image.tmdb.org/t/p/w185/";




    public static URL buildPopularUri(){

        Uri builtUri =
                Uri.parse(BASE_POPULAR_URL).buildUpon()
                        .appendQueryParameter(mQueryWithAPIKey, API_KEY)
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
                        .appendQueryParameter(mQueryWithAPIKey, API_KEY)
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
        String url = BASE_URL_FOR_IMAGE_PARSING + image;
        return url;
    }
}
