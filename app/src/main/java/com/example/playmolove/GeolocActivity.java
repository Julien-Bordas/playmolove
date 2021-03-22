package com.example.playmolove;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.M)
public abstract class GeolocActivity<names, name> extends AppCompatActivity {
    LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    ArrayList<LocationProvider> providers = new ArrayList<LocationProvider>();
    ArrayList<String> names = (ArrayList<String>) locationManager.getProviders(true);

    for (String name:names)
        providers.add(locationManager.getProvider(name))

    Criteria critere = new Criteria();
// Critères de précision
    critere.setAccuracy(Criteria.ACCURACY_FINE); // critère de haut précision
    critere.setAltitudeRequired(true) // donne une altitude
    critere.setBearingRequired(true) // donner une direction
    critere.setSpeedRequired(true) // donne une vitesse
    critere.setCostAllowed(false) // le fournisseur ne peut être payant


// Critères consommation d'énergie demandée
    critere.setPowerRequirement(Criteria.POWER_HIGH) // haute consommation d'énergie

    abstract String getBestProvider(Criteria criteria, boolean enabledOnly);

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoloc);

    }
}