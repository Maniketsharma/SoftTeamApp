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

        import com.google.firebase.FirebaseApp;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class Groupadd extends AppCompatActivity {
    private static final String TAG = "Groupadd";

    EditText user;
    EditText email;
    EditText phone;
    EditText pass;
    EditText cpass;
    Button button2;
    ProgressBar progress_circular;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupadd);
        FirebaseApp FirebaseApp =com.google.firebase.FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        user = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.number);
        pass = findViewById(R.id.pass);
        cpass = findViewById(R.id.cpass);
        button2 = findViewById(R.id.button2);
        progress_circular = findViewById(R.id.progress_circular);

        button2.setOnClickListener(v -> {
            progress_circular.setVisibility(View.VISIBLE); // Show progress bar

            String name = String.valueOf(user.getText());
            String mail = String.valueOf(email.getText());
            String number = String.valueOf(phone.getText());
            String password = String.valueOf(pass.getText());
            String digit = String.valueOf(cpass.getText());

            if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(password) || TextUtils.isEmpty(digit)) {
                Toast.makeText(Groupadd.this, "All fields are required", Toast.LENGTH_SHORT).show();
                progress_circular.setVisibility(View.INVISIBLE); // Hide progress bar
                return;
            }

            // Create a new user
            mAuth.createUserWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(Groupadd.this, createUserTask -> {
                        if (createUserTask.isSuccessful()) {
                            // User creation success
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();

                            // Now, you can store data in the Realtime Database
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
                            if (firebaseUser != null) {
                                databaseReference.child(firebaseUser.getUid()).child("name").setValue(name);
                            }
                            assert firebaseUser != null;
                            databaseReference.child(firebaseUser.getUid()).child("email").setValue(mail);
                            databaseReference.child(firebaseUser.getUid()).child("number").setValue(number);

                            Toast.makeText(Groupadd.this, "User created and data stored", Toast.LENGTH_SHORT).show();
                        } else {
                            // If user creation fails
                            Log.w(TAG, "createUserWithEmail:failure", createUserTask.getException());
                            Toast.makeText(Groupadd.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }

                        progress_circular.setVisibility(View.INVISIBLE); // Hide progress bar
                    });
        });
    }
}
        /*
        button2.setOnClickListener(v -> {
            progress_circular.setVisibility(View.VISIBLE); // Show progress bar
            String name=String.valueOf(user.getText());
            String mail = String.valueOf(email.getText());
            String number=String.valueOf(phone.getText());
            String password = String.valueOf(pass.getText());
            String digit = String.valueOf(cpass.getText());

            if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(password) || TextUtils.isEmpty(digit)) {
                Toast.makeText(Groupadd.this, "All fields are required", Toast.LENGTH_SHORT).show();
                progress_circular.setVisibility(View.INVISIBLE); // Hide progress bar
                return;
            }

            mAuth.signInWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(Groupadd.this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Groupadd.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        progress_circular.setVisibility(View.INVISIBLE); // Hide progress bar
                    });
        });*/