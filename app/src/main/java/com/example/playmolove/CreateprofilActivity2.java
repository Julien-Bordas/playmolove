package com.example.playmolove;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateprofilActivity2 extends AppCompatActivity {

    String check_birthday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofil2);

        Button button = findViewById(R.id.next);
        button.setOnClickListener(v -> goto3());

        EditText birthdayEditText = (EditText) findViewById(R.id.edit_birthday);
        check_birthday = birthdayEditText.getText().toString();

    }
    public void goto3() {
        //if (check_birthday.matches("")) {
            //Toast.makeText(this, "Le champ est vide", Toast.LENGTH_SHORT).show();
       // } else {
        startActivity(new Intent(this, CreateProfilActivity3.class));
        //}
    }
}