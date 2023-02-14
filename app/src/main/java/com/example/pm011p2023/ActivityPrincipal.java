package com.example.pm011p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityPrincipal extends AppCompatActivity
{
    Button btn_ingresar;
    Button btn_lista, btn_combo;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btn_ingresar = (Button) findViewById(R.id.btn_ingresar);
        btn_lista = (Button) findViewById(R.id.btn_lista);
        btn_combo = (Button) findViewById(R.id.btn_combo);
        imageButton =(ImageButton) findViewById(R.id.imageButton);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        btn_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), ActivityListView.class);
                startActivity(intent);
            }
        });


        btn_combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), ActivityCombo.class);
                startActivity(intent);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityPhoto.class);
                startActivity(intent);
            }
        });

    }
}