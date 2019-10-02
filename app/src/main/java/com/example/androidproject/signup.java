package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "activity_signup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
    }

    public void Signup(View view) {
        EditText emailid = (EditText) findViewById(R.id.usertext);
        EditText pass = (EditText) findViewById(R.id.passtext);
        String email = emailid.getText().toString();
        String password = pass.getText().toString();

        registerAccount(email,password);
    }
    private void registerAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "account created");
                            Toast.makeText(signup.this,
                                    "Registered.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signup.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Log.d(TAG, "register account failed", task.getException());
                            Toast.makeText(signup.this,
                                    "account registration failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
