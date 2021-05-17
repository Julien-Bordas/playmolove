package com.example.playmolove;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CreateProfilActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofil4);

        Button button = findViewById(R.id.next);
        button.setOnClickListener(v -> goto5());
    }
    public void goto5() {
        Intent intent = new Intent(this, CreateProfilActivity5.class);
        CreateProfilActivity4.this.startActivity(intent);
    }
}
