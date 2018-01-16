package com.example.rcarb.popularmovies;



import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rcarb.popularmovies.Utils.JsonUtils;
import com.example.rcarb.popularmovies.Utils.MovieInfoHolder;
import com.example.rcarb.popularmovies.Utils.NetWorkUtils;
import com.example.rcarb.popularmovies.Utils.UriBuilderUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements GridViewAdapter.OnItemClicked{

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private GridViewAdapter mAdapter;
    private ArrayList<MovieInfoHolder> parsedMovies;
    private FetchMovieTask task;
    private Context mContext;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //The Grid will not change size
        mRecyclerView.setHasFixedSize(true);

        //Sets up the layout manager as a GridView.
        layoutManager = new GridLayoutManager(this, 2);

        //Attaches the adaptor
        mRecyclerView.setLayoutManager(layoutManager);
        
        mContext = MainActivity.this;
        task = new FetchMovieTask(mContext, mRecyclerView);

        //The Default param is to query for most popular.
        task.execute("popular");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //depending on the item selected on the menu item, the proper query param will be used.

        if (id == R.id.popular){
            FetchMovieTask task = new FetchMovieTask(mContext,mRecyclerView);
            task.execute("popular");


        }
        if (id== R.id.top_rated){
            FetchMovieTask task = new FetchMovieTask(mContext,mRecyclerView);
            task.execute("top_rated");
        }
        return super.onOptionsItemSelected(item);
    }

    class FetchMovieTask extends AsyncTask<String, Void,String> {

        final Context mContext;
        final RecyclerView mActivitiesRecyclerView;


        public FetchMovieTask(Context context,
                              RecyclerView recyclerView) {
            mContext = context;
            mActivitiesRecyclerView = recyclerView;

        }

        @Override
        protected String doInBackground(String... params) {
            String jsonData = "";


            if (params[0].equals("popular")) {
                try {

                    jsonData = NetWorkUtils.getResponseFromHttpUrl(UriBuilderUtil.buildPopularUri());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (params[0].equals("top_rated")) {
                try {

                    jsonData = NetWorkUtils.getResponseFromHttpUrl(UriBuilderUtil.buildRatedUri());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            return jsonData;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                ArrayList<MovieInfoHolder> movieArray = JsonUtils.parseJsonObject(s);

                //Get the Size of the ArrayList to pass in to the Adaptor.
                int arrayListSize = movieArray.size();
                parsedMovies = movieArray;

                //Get the view from the Context object
                GridViewAdapter adapter = new GridViewAdapter(arrayListSize, movieArray, MainActivity.this);
                mActivitiesRecyclerView.setAdapter(adapter);


                //Set the adaptor with the MovieInfoHolder data.


                //delegate.processFinish(movieArray);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onItemClick(int mNumberOfItemsIndex) {

        //Takes the clicked RecyclerView vies id and saves the selected movie information
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        MovieInfoHolder holder = parsedMovies.get(mNumberOfItemsIndex);
        intent.putExtra("moviePoster",holder.getMoviePoster());
        intent.putExtra("movieTitle",holder.getMovieTitle());
        intent.putExtra("movieRelease",holder.getMovieReleaseDate());
        intent.putExtra("movieRating",holder.getMovieRating());
        intent.putExtra("movieDescription",holder.getMovieDescription());
        startActivity(intent);
    }
}
