package com.example.playmolove;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.M)
public class GeolocActivity extends AppCompatActivity {
    LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    ArrayList<LocationProvider> providers = new ArrayList<LocationProvider>();
    ArrayList<String> names = locationManager.getProviders(true);
    for(String name: names)
            providers.add(locationManager.getProvider(name));

    Criteria critere = new Criteria();

// Pour indiquer la précision voulue
// On peut mettre ACCURACY_FINE pour une haute précision ou ACCURACY_COARSE pour une moins bonne précision
    critere.setAccuracy(Criteria.ACCURACY_FINE);

// Est-ce que le fournisseur doit être capable de donner une altitude ?
    critere.setAltitudeRequired(true);

// Est-ce que le fournisseur doit être capable de donner une direction ?
    critere.setBearingRequired(true);

// Est-ce que le fournisseur peut être payant ?
    critere.setCostAllowed(false);

// Pour indiquer la consommation d'énergie demandée
// Criteria.POWER_HIGH pour une haute consommation, Criteria.POWER_MEDIUM pour une consommation moyenne et Criteria.POWER_LOW pour une basse consommation
    critere.setPowerRequirement(Criteria.POWER_HIGH);

// Est-ce que le fournisseur doit être capable de donner une vitesse ?
    critere.setSpeedRequired(true);


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoloc);

    }
}