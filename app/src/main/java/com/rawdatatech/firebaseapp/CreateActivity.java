package com.rawdatatech.firebaseapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.firebase.client.Firebase;
import java.util.HashMap;

public class CreateActivity extends Activity {
    EditText name,number;
    Firebase alansRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_create);
        name=(EditText)findViewById(R.id.name);
        number=(EditText)findViewById(R.id.number);

    }
    public void send(View view)
    {
        Firebase myFirebaseRef = new Firebase("https://incandescent-inferno-7834.firebaseio.com/");
        String mName=name.getText().toString();
        String mNumber=number.getText().toString();

        alansRef = myFirebaseRef.child("users").child("user");
        alansRef.child("fullName").setValue(mName);
        alansRef.child("birthYear").setValue(mNumber);

        HashMap<String, String> post1 = new HashMap<>();
        post1.put("name",mName);
        post1.put("number",mNumber);
        alansRef.push().setValue(post1);

    }
}


