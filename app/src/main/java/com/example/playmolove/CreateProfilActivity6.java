package com.example.playmolove;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateProfilActivity6 extends AppCompatActivity {
    String check_etablissement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofil6);

        Button button = findViewById(R.id.termine);
        button.setOnClickListener(v -> gotomain());

        EditText etablissementEditText = (EditText) findViewById(R.id.etablissement);
        check_etablissement = etablissementEditText.getText().toString();

    }
    public void gotomain() {
        //if (check_etablissement.matches("")) {
          //  Toast.makeText(this, "Le champ est vide", Toast.LENGTH_SHORT).show();
       // }
        //else {
        startActivity(new Intent(this, ProfilActivity.class));
        //}
    }
}
