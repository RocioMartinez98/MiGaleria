package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class artistas extends AppCompatActivity {

    private int id_artista=0;
    private int id_estilo=0;
    private Button btn_artista_1;
    private Button btn_artista_2;
    private Button btn_artista_3;
    private Button btn_artista_4;
    private int artista_1=0;
    private int artista_2=0;
    private int artista_3=0;
    private int artista_4=0;
    private int [] artistas = null;
    private String [] nombres_artista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistas);
        Bundle bundle=this.getIntent().getExtras();
        id_estilo=(int)bundle.getInt("estilo");
        btn_artista_1=(Button) findViewById(R.id.artista1Boton);
        btn_artista_2=(Button) findViewById(R.id.artista2Boton);
        btn_artista_3=(Button) findViewById(R.id.artista3Boton);
        btn_artista_4=(Button) findViewById(R.id.artista4Boton);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"baseDeDatos",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select distinct artista.id_artista,artista.nombre_artista from obras_artista,artista where (id_estilo== "+id_estilo+" and artista.id_artista==obras_artista.id_artista)",null);

        if(fila.moveToFirst()){
            artistas = new int[fila.getCount()];
            nombres_artista = new String[fila.getCount()];
            int i = 0;
            do {
                artistas[i] = Integer.parseInt(fila.getString(0));
                nombres_artista[i] = fila.getString(1);
                i++;
            }while (fila.moveToNext());

        }else{
            Toast.makeText(this,"no se han encontrado artistas.",Toast.LENGTH_SHORT).show();
        }
        btn_artista_1.setText(nombres_artista[0]);
        btn_artista_2.setText(nombres_artista[1]);
        btn_artista_3.setText(nombres_artista[2]);
        btn_artista_4.setText(nombres_artista[3]);
        artista_1=artistas[0];
        artista_2=artistas[1];
        artista_3=artistas[2];
        artista_4=artistas[3];
        bd.close();
    }
    public void atras(View view){
        Intent intent = new Intent( artistas.this, menuGenero.class);
        startActivity(intent);
    }

    public void menuPrincipal(View view){
        Intent intent = new Intent( artistas.this, MainActivity.class);
        startActivity(intent);
    }


    public void artista1(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",artista_1);
        bundle.putString("nombre_artista",nombres_artista[0]);
        Intent intent = new Intent( artistas.this, imagenes.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void artista2(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",artista_2);
        bundle.putString("nombre_artista",nombres_artista[1]);
        Intent intent = new Intent( artistas.this, imagenes.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void artista3(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",artista_3);
        bundle.putString("nombre_artista",nombres_artista[2]);
        Intent intent = new Intent( artistas.this, imagenes.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void artista4(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",artista_4);
        bundle.putString("nombre_artista",nombres_artista[3]);
        Intent intent = new Intent( artistas.this, imagenes.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}