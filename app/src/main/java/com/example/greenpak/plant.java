package com.example.greenpak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class plant extends AppCompatActivity {
    long id =  0;
    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);


    }

    public void plantatree(View view) {

        EditText latitude = (EditText)findViewById(R.id.lats);
        String lats = latitude.getText().toString();

        EditText longitude = (EditText)findViewById(R.id.longs);
        String longs = longitude.getText().toString();

        EditText plant = (EditText)findViewById(R.id.plantname);
        String pn = plant.getText().toString();

        FirebaseAuth mAuth;
        // ...
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();




        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myref  = database.getReference("Plants").child(String.valueOf(id+1));



        myref.child("Name").setValue(pn);
        myref.child("Latitude").setValue(lats);
        myref.child("Longitude").setValue(longs);

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    id = snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        Toast.makeText(plant.this, "Planted Successfully", Toast.LENGTH_SHORT).show();
        Toast.makeText(plant.this, "Awaiting Confirmation", Toast.LENGTH_LONG).show();

        Intent i = new Intent(getApplicationContext(), home.class);
        startActivity(i);


    }
}