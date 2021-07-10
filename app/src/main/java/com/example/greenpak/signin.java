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

public class signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void gotosignup(View view) {

        Intent i = new Intent(this, signup.class);
        startActivity(i);
    }

    public void login(View view) {

        EditText emailphone = (EditText)findViewById(R.id.emailphone);
        EditText pin = (EditText)findViewById(R.id.signpin);

        FirebaseAuth mAuth;
        // ...
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(emailphone.getText().toString(), pin.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(signin.this, "Sign In Successful", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(), home.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(signin.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void resetpassword(View view) {

        EditText email = (EditText)findViewById(R.id.emailphone);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String emailaddress = email.getText().toString();
        mAuth.sendPasswordResetEmail(emailaddress)

                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){

                            Toast.makeText(signin.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(signin.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}