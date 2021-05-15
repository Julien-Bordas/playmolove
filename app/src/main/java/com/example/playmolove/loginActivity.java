package com.example.playmolove;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    private EditText email2;
    private EditText password2;
    private Button login;
    private Button register;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email2 = (EditText) findViewById(R.id.email2);
        password2 = (EditText) findViewById(R.id.password2);
        login = (Button) findViewById(R.id.login);
        register = findViewById(R.id.register);
        firebaseAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this , RegisterActivity.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email2.getText().toString().trim();
                String password = password2.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(loginActivity.this, "Entrer un email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password2.length() < 6) {
                    Toast.makeText(loginActivity.this, "Mot de passe trop court", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                            } else {
                                                Toast.makeText(loginActivity.this, "Login raté ou utilisateur inconnu", Toast.LENGTH_SHORT).show();

                                            }


                                        }
                                    }
                            );
                }
            }
        });
    }
}

