package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void menuGenero(View view){
        Intent intent = new Intent(MainActivity.this, menuGenero.class);
        startActivity(intent);
    }
    public void infoGrupos(View view){
        Intent intent = new Intent( MainActivity.this, info.class);
        startActivity(intent);
    }
}