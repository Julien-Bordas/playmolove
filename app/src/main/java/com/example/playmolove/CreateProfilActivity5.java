package com.example.playmolove;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateProfilActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofil5);

        Button button = findViewById(R.id.next);
        button.setOnClickListener(v -> goto6());
    }

    public void goto6() {
            Intent intent = new Intent(this, CreateProfilActivity6.class);
            CreateProfilActivity5.this.startActivity(intent);

    }
}


