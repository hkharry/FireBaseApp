package com.rawdatatech.firebaseapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ShowActivity extends Activity {
    JSONObject result;
    ArrayList<UserInfo> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Firebase ref = new Firebase("https://incandescent-inferno-7834.firebaseio.com/");
        usersList=new ArrayList<>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
                try {
                    result=new JSONObject(firebaseError.getMessage());
//                    for (int i=0;i<result.length();i++)
//                    {
//                        JSONObject object=result.getJSONObject();
//                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
