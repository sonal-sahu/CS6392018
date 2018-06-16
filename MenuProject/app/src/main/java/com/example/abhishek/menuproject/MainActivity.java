package com.example.abhishek.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        Button sms_btn= (Button) findViewById(R.id.send_sms);
        sms_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call Intent to send SMS
                final Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+ Uri.encode("16469343228")));
                intent.putExtra("sms_body","Sonal Sahu");
                startActivity(intent);
            }
        });

        Button phn_btn= (Button) findViewById(R.id.phone_call);
        phn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call Intent to dial phone
                final Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:16469343228"));
                startActivity(intent);
            }
        });

        Button web_btn=(Button)findViewById(R.id.click_web);
        web_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //call intent to open web
                final Intent web_intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://google.com"));
                startActivity(web_intent);

            }
        });

    }

    public void openGoogleMaps(View v){

        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/place/Jhansi,+Uttar+Pradesh,+India/@25.4412563,78.4922473,12z/data=!3m1!4b1!4m5!3m4!1s0x397776d458ba7703:0x96e9cda55c3481ca!8m2!3d25.4484257!4d78.5684594"));
        startActivity(intent);
    }

    public void shareChooserIntent(View view)
    {
        final Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"CS639");
        intent.putExtra(Intent.EXTRA_TEXT,"Join CS 639");
        startActivity(Intent.createChooser(intent,"Share the love"));
    }

    public void click_On_New_Activity(View view)
    {
        Intent intent = new Intent(this, NewActivity.class);
        Button new_activity_btn=(Button)findViewById(R.id.click_new_activity);
        String message="Hello Sonal, Sahu";
        intent.putExtra("name",message);
        startActivity(intent);

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
       // if (id == R.id.action_settings) {
         //   return true;
       // }

        switch(id){
            case R.id.action_help: {
                Intent intent = new Intent(this, HelpActivity.class);
                Button new_activity_btn = (Button) findViewById(R.id.action_help);
                String message = "May i help you please?";
                intent.putExtra("help_name", message);
                startActivity(intent);
                return true;
            }
            case R.id.action_settings:
                Toast.makeText(this,"Settings item is clicked",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }



    }
}
