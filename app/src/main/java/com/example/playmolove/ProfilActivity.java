package com.example.playmolove;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.jetbrains.annotations.NotNull;

public class ProfilActivity extends AppCompatActivity {

    Button button ;
    ImageView imageView ;
    Intent intent ;
    public  static final int RequestPermissionCode  = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        button = (Button)findViewById(R.id.button);
        imageView = (ImageView)findViewById(R.id.photo);

        EnableRuntimePermission();

        button.setOnClickListener(view -> {

            intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(intent, 7);

        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(ProfilActivity.this,
                Manifest.permission.CAMERA))
        {

            Toast.makeText(ProfilActivity.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(ProfilActivity.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, @NotNull String per[], @NotNull int[] PResult) {

        if (RC == RequestPermissionCode) {
            if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(ProfilActivity.this, "Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

            } else {

                Toast.makeText(ProfilActivity.this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

            }
        }
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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}