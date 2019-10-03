package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "activity_main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }

    public void login(View view) {
        EditText emailid = findViewById(R.id.usertext);
        EditText pass = findViewById(R.id.passtext);
        String email = emailid.getText().toString();
        String password = pass.getText().toString();
        signIn(email,password);
    }

    public void signup(View view) {
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }
    private void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "login success");
                            Toast.makeText(MainActivity.this,
                                    "Authenticated\n ---welcome---",
                                    Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, searchpage.class);
                            startActivity(intent);
                        } else {
                            Log.e(TAG, "Login fail", task.getException());
                            Toast.makeText(MainActivity.this,
                                    "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
