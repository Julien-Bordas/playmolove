package com.example.playmolove;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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


        EditText nameEditText = findViewById(R.id.edit_name);
        check_name = nameEditText.getText().toString();

    }
    public void goto2() {
        //if (TextUtils.isEmpty(check_name)){
           // Toast.makeText(this, "Le champ est vide", Toast.LENGTH_SHORT).show();
       // } else {
            startActivity(new Intent(this, CreateprofilActivity2.class));
        //}
    }
}