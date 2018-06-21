package com.example.abhishek.asynctaskproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        imageView = (ImageView) findViewById(R.id.async_image);
        new ImageTask(imageView).execute(new String[]{"https://raw.githubusercontent.com/sonal-sahu/CS6392018/master/Fort.jpg"});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ImageTask extends AsyncTask<String,String,Bitmap>
    {
        private ImageView imageView;

        public ImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap bmap=null;
            URL url=null;
            try {

                url = new URL(urls[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                if (con.getResponseCode() != 200) {
                    throw new Exception("Failed to connect");
                }
                InputStream is = con.getInputStream();
                bmap= BitmapFactory.decodeStream(is);

            }
            catch (Exception e)
            {
                Log.e("Image","Failed to load image",e);
                Log.e("error",e.getMessage());

            }
           return bmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap  bitmap) {
            imageView.setImageBitmap(bitmap);

        }
    }

}
