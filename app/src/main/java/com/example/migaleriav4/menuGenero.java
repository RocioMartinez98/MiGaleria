package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menuGenero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_genero);
    }
    public void menuPrincipal(View view){
        Intent intent = new Intent( menuGenero.this, MainActivity.class);
        startActivity(intent);
    }

    public void bodegon(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",1);
        Intent intent = new Intent( menuGenero.this, artistas.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void abstracto(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",2);
        Intent intent = new Intent( menuGenero.this, artistas.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void religion(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",3);
        Intent intent = new Intent( menuGenero.this, artistas.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void paisaje(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",4);
        Intent intent = new Intent( menuGenero.this, artistas.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}