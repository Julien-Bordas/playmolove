package com.example.playmolove;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateProfilActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofil3);

        Button button = findViewById(R.id.next);
        button.setOnClickListener(v -> goto4());
    }
    public void goto4() {
        Intent intent = new Intent(this, CreateProfilActivity4.class);
        CreateProfilActivity3.this.startActivity(intent);
    }
}
