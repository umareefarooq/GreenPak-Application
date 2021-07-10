package com.example.greenpak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home extends AppCompatActivity {

    TextView username;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = (TextView)findViewById(R.id.username);


        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
        String name = currentuser.getDisplayName();

        username.setText("Welcome, " +  name);



    }

    public void gotoupcoming(View view) {

        Intent i = new Intent(this, upcomingevents.class);
        startActivity(i);
    }
    public void gotocomplaints(View view) {

        Intent i = new Intent(this, complaints.class);
        startActivity(i);
    }
    public void gotoplant(View view) {

        Intent i = new Intent(this, plant.class);
        startActivity(i);
    }
    public void gotoallplants(View view) {

        Intent i = new Intent(this, GreenPakistan.class);
        startActivity(i);
    }
    public void logout(View view) {

        mAuth.signOut();
        Intent i = new Intent(this, signin.class);
        finish();
        startActivity(i);
    }


}