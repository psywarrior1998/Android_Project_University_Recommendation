package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "activity_signup";
    private String e;
    private String p;

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
        e=email;
        p=password;

        registerAccount(email,password);
    }
    private void registerAccount(String email,String password) {
        String e=email;
        String p=password;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "account created");
                            Toast.makeText(signup.this,
                                    "Registered.",
                                    Toast.LENGTH_SHORT).show();
                            move(task.getResult().getUser());

                        } else {
                            Log.d(TAG, "register account failed", task.getException());
                            Toast.makeText(signup.this,
                                    "account registration failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void move(FirebaseUser User){
        Intent intent = new Intent(signup.this, detailspage.class);
        Bundle b = new Bundle();
        EditText emailid = (EditText) findViewById(R.id.usertext);
        EditText pass = (EditText) findViewById(R.id.passtext);
        String email = emailid.getText().toString();
        String password = pass.getText().toString();
        b.putString("Username",email);
        b.putString("Password",password);
//        b.putString("uId",User.getUid());
        intent.putExtras(b);
        startActivity(intent);
    }
}
