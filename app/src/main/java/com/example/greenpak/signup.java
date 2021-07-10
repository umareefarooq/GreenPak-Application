package com.example.greenpak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signup(View view) {

        EditText em = (EditText)findViewById(R.id.email);
        EditText pass = (EditText)findViewById(R.id.pin);
        EditText name = (EditText)findViewById(R.id.name);
        EditText phone = (EditText)findViewById(R.id.phonenumber);
        EditText age = (EditText)findViewById(R.id.age);


        String fn = name.getText().toString();
        String p = phone.getText().toString();
        String e = em.getText().toString();
        String pas = pass.getText().toString();
        String a = age.getText().toString();



        FirebaseAuth mAuth;
        // ...
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(e, pas)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myref = database.getReference("Users").child(p);

                            myref.child("Name").setValue(fn);
                            myref.child("Email").setValue(e);
                            myref.child("Password").setValue(pas);
                            myref.child("Age").setValue(a);

                            //getting current user details
                            FirebaseUser user = mAuth.getCurrentUser();
                            UserProfileChangeRequest profileupdate = new
                                    UserProfileChangeRequest.Builder()
                                    .setDisplayName(fn).build();
                            user.updateProfile(profileupdate);

                            Toast.makeText(signup.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(), home.class);
                            startActivity(i);


                        } else {

                            Toast.makeText(signup.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();

                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }


    public void gotologin(View view) {
        Intent i = new Intent(this, signin.class);
        startActivity(i);
    }
}