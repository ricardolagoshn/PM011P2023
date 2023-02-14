package com.example.pm011p2023;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityPhoto extends AppCompatActivity {

    static final  int REQUEST_IMAGE = 101;
    static final  int PETICION_ACCESS_CAM = 201;

    ImageView imageView;
    Button btntakefoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageView = (ImageView) findViewById(R.id.imageView);
        btntakefoto = (Button) findViewById(R.id.btnfoto);

        btntakefoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permisos();
            }
        });
    }

    private void permisos()
    {
        // Metodo para obtener los permisos requeridos de la aplicacion
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},PETICION_ACCESS_CAM);
        }
        else
        {
            TomarFoto();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PETICION_ACCESS_CAM)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                TomarFoto();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "se necesita el permiso de la camara",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void TomarFoto()
    {
        Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intent.resolveActivity(getPackageManager())!= null)
        {
            startActivityForResult(intent,REQUEST_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE)
        {
            Bundle extra = data.getExtras();
            Bitmap imagen = (Bitmap) extra.get("data");
            imageView.setImageBitmap(imagen);
        }
    }
}