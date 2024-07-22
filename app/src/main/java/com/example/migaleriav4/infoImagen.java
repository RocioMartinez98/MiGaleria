package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class infoImagen extends AppCompatActivity {

    private int id_estilo=0;
    private int id_artista=0;
    private String nombre_artista=null;
    private int id_obra=0;
    private int id_obra_bd=0;
    private String nombre_obra=null;
    private int año_creacion=0;
    private float precio_estimado=0;
    private String nombre_dueño=null;
    private long nro_telefono;
    private int [] ids_obras_bd;
    private TextView nombre_Obra_Textview;
    private TextView año_creacion_Obra_Textview;
    private TextView precio_estimado_Obra_Textview;
    private TextView nombre_dueño_Obra_Textview;
    private TextView nro_telefono_Obra_Textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_imagen);
        Bundle bundle=this.getIntent().getExtras();
        id_estilo=(int)bundle.getInt("estilo");
        id_artista=(int)bundle.getInt("artista");
        nombre_artista=(String)bundle.getString("nombre_artista");
        id_obra=(int)bundle.getInt("id_obra");
        id_obra_bd=(int)bundle.getInt("id_obra_bd");
        ids_obras_bd=(int[])bundle.getIntArray("ids_obras_bd"); ///
        nombre_Obra_Textview=(TextView) findViewById(R.id.nombreImg);
        año_creacion_Obra_Textview=(TextView) findViewById(R.id.fechaCreacion);
        precio_estimado_Obra_Textview=(TextView) findViewById(R.id.precio);
        nombre_dueño_Obra_Textview=(TextView) findViewById(R.id.dueño);
        nro_telefono_Obra_Textview=(TextView) findViewById(R.id.relefono);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"baseDeDatos",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono from obras_artista where id_obra== "+id_obra_bd,null);
        if(fila.moveToFirst()){
            nombre_obra = fila.getString(0);
            año_creacion = Integer.parseInt(fila.getString(1));
            precio_estimado = Float.parseFloat(fila.getString(2));
            nombre_dueño = fila.getString(3);
            nro_telefono = Long.parseLong(fila.getString(4));
        }else{
            Toast.makeText(this,"Ha ocurrido un error",Toast.LENGTH_SHORT).show();
        }
        nombre_Obra_Textview.setText("Nombre de la Obra: "+nombre_obra);
        año_creacion_Obra_Textview.setText("Año de Creacion: "+año_creacion);
        precio_estimado_Obra_Textview.setText("Precio Estimado: $"+precio_estimado);
        nombre_dueño_Obra_Textview.setText("Dueño Actual: "+nombre_dueño);
        nro_telefono_Obra_Textview.setText("Nro Telefono: "+nro_telefono);
        bd.close();
    }
    public void atrasInfoImg(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra",id_obra);
        bundle.putInt("id_obra_bd",id_obra_bd);
        bundle.putIntArray("ids_obras_bd",ids_obras_bd);///
        Intent intent = new Intent( infoImagen.this, obra.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void menuPrincipalInfoImg(View view){
        Intent intent = new Intent( infoImagen.this, MainActivity.class);
        startActivity(intent);
    }

}