package com.example.playmolove;

import android.Manifest;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GeolocActivity extends AppCompatActivity implements LocationListener {

    private static final int PERMS_CALL_ID = 1234;

    private LocationManager lm;
    private MapFragment mapFragment;  // récupérer la map (utilise code .xml)
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoloc);

        FragmentManager fragmentManager = getFragmentManager();
        mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map);
    }

    @Override
    protected void onResume() { //invoque check permission
        super.onResume();
    }

    private void checkPermissions() { //Test permissions
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                && (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, new String[]{ //appel asynchrone (affiche le popup)
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, PERMS_CALL_ID);
            return; //si permissions pas activées
        }
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
        }
        if (lm.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)) {
            lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 10000, 0, this);
        }
        if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, this);
        }
        loadMap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMS_CALL_ID) {
            checkPermissions(); //redemande appel à check permissions et abonne au niveau des fournissuers de GPS
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (lm != null) {
            lm.removeUpdates(this);
        }
    }

    @SuppressWarnings("MissingPermission")
// ayant déjà demandé les permissions plus haut, on ne se préoccupe pas des permissions ici
    private void loadMap() {
        mapFragment.getMapAsync(new OnMapReadyCallback() {   //on dérive une classe basée sur l'interface OnMapReadyCallback

            @Override
            public void onMapReady(GoogleMap googleMap) {
                GeolocActivity.this.googleMap = googleMap; // capture notre objet de cartographie sur lequelon travaille
                googleMap.moveCamera(CameraUpdateFactory.zoomBy(15)); //paramétrage du zoom
                googleMap.setMyLocationEnabled(true); //affiche la position courante //nécéssite une permission en temps normal
                googleMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(44.86604322419884, -0.5745918154462507)) //ajout d'un marqueur de position
                                .title("ESME Sudria Bordeaux"));

            }
        });
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override //localisation capturée
    public void onLocationChanged(@NonNull Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Toast.makeText(this, "Location : " + latitude + "/" + longitude, Toast.LENGTH_LONG).show(); //popup
        if (googleMap != null) { // à chq fois qu'il y a une nouvelle info de loc, vérifier qu'il n'y ait pas d'erreur
            LatLng googleLocation = new LatLng(latitude, longitude);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(googleLocation)); //replace la carto à la position demandée
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.chat:
                Toast.makeText(this, "Chargement des messages", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MessagerieActivity.class));
                return true;
            case R.id.find:
                Toast.makeText(this, "Autre menu choisi", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MatchingActivity.class));
                return true;
            case R.id.profil:
                Toast.makeText(this, "Autre menu choisi", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, ProfilActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
// TODO: Consider calling
//    ActivityCompat#requestPermissions
// here to request the missing permissions, and then overriding
//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                          int[] grantResults)
// to handle the case where the user grants the permission. See the documentation
// for ActivityCompat#requestPermissions for more details.