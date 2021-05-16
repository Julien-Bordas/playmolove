package com.example.playmolove;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.BottomNavigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.bottom_navigation_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.geoloc:
                Toast.makeText(this, "Chargement de la localisation", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, GeolocActivity.class));
                return true;
            case R.id.chat:
                Toast.makeText(this, "Chargement des messages", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MessagerieActivity.class));
                return true;
            case R.id.find:
                Toast.makeText(this, "Autre menu choisi", Toast.LENGTH_LONG).show();
                return true;
            case R.id.profil:
                Toast.makeText(this, "Autre menu choisi", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, ProfilActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
        switch (menuitem.getItemId()) {
            case R.id.geoloc:
                Toast.makeText(this, "Chargement de la localisation", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, GeolocActivity.class));
                return true;
            case R.id.chat:
                Toast.makeText(this, "Autre menu choisi", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MessagerieActivity.class));
                return true;
            case R.id.find:
                Toast.makeText(this, "Autre menu choisi", Toast.LENGTH_LONG).show();
                return true;
            case R.id.profil:
                Toast.makeText(this, "Autre menu choisi", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, ProfilActivity.class));
                return true;
        }
        return false;
    }
}