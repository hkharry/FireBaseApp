package com.rawdatatech.firebaseapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.Firebase;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);


        setContentView(R.layout.activity_main);
    }

    public void create(View view)
    {
        Intent intent = new Intent(this,CreateActivity.class);
        startActivity(intent);
    }
    public void show(View view)
    {

        Intent intent = new Intent(this,ShowActivity.class);
        startActivity(intent);
    }

}
