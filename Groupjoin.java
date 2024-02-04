package com.example.softteamapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Groupjoin extends AppCompatActivity {
    private static final String TAG = "Groupjoin";

    EditText user;
    EditText Pass;
    EditText Code;
    Button button2;
    ProgressBar progress_circular;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupjoin);

        mAuth = FirebaseAuth.getInstance();
        user = findViewById(R.id.user);
        Pass = findViewById(R.id.Pass);
        Code = findViewById(R.id.Code);
        button2 = findViewById(R.id.button2);
        progress_circular = findViewById(R.id.progress_circular);

        button2.setOnClickListener(v -> {
            progress_circular.setVisibility(View.VISIBLE); // Show progress bar

            String mail = String.valueOf(user.getText());
            String password = String.valueOf(Pass.getText());
            String digit = String.valueOf(Code.getText());

            if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(password) || TextUtils.isEmpty(digit)) {
                Toast.makeText(Groupjoin.this, "All fields are required", Toast.LENGTH_SHORT).show();
                progress_circular.setVisibility(View.INVISIBLE); // Hide progress bar
                return;
            }

            mAuth.signInWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(Groupjoin.this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Groupjoin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        progress_circular.setVisibility(View.INVISIBLE); // Hide progress bar
                    });
        });
    }
}
