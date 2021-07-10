package com.example.greenpak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class complaints extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaints);


    }

    public void submit(View view) {


       EditText msg = (EditText)findViewById(R.id.message);
       String m = msg.getText().toString();

        FirebaseAuth mAuth;
        // ...
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String id = currentFirebaseUser.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("Complaints").child(id);


        myref.child("Complaint").setValue(m);

        Toast.makeText(complaints.this, "Complaint Submitted Successfully", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(getApplicationContext(), home.class);
        startActivity(i);
    }
}