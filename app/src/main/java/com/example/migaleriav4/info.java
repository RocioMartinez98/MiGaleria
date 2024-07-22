package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    public void menuPrincipal(View view){
        Intent intent = new Intent( info.this, MainActivity.class);
        startActivity(intent);
    }

    public void genero(View view){
        Intent intent = new Intent(info.this, menuGenero.class);
        startActivity(intent);
    }
}