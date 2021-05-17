package com.example.playmolove;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private EditText p_lost;
    private Button signup;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.identifiant);
        password = findViewById(R.id.mdp);
        login = findViewById(R.id.connexion);
        p_lost = findViewById(R.id.mdp_oublie);
        signup = findViewById(R.id.inscrire);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = username.getText().toString();
                String inputPassword = password.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(this,"Entrer les données correspondantes correctement", Toast.LENGTH_SHORT).show();
                }
                else
                {

                }
                }
        })


    }
}