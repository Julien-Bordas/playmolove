package com.example.playmolove;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateProfilActivity extends AppCompatActivity {

    String check_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofil);

        Button button = findViewById(R.id.next);
        button.setOnClickListener(v -> goto2());


        EditText nameEditText = (EditText) findViewById(R.id.edit_name);
        check_name = nameEditText.getText().toString();

    }
    public void goto2() {
        if (check_name.matches("")) {
            Toast.makeText(this, "Le champ est vide", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class); // CreateprofilActivity2
            CreateProfilActivity.this.startActivity(intent);
        }
    }
}