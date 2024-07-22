package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class oferta extends AppCompatActivity {

    private int id_estilo=0;
    private int id_artista=0;
    private String nombre_artista=null;
    private int id_obra=0;
    private int id_obra_bd=0;
    private int [] ids_obras_bd;
    private EditText nombre_input;
    private EditText apellido_input;
    private EditText correo_electronico_input;
    private EditText nro_telefono_input;
    private EditText monto_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferta);
        Bundle bundle=this.getIntent().getExtras();
        id_estilo=(int)bundle.getInt("estilo");
        id_artista=(int)bundle.getInt("artista");
        nombre_artista=(String)bundle.getString("nombre_artista");
        id_obra=(int)bundle.getInt("id_obra");
        id_obra_bd=(int)bundle.getInt("id_obra_bd");
        ids_obras_bd=(int[])bundle.getIntArray("ids_obras_bd");////
        nombre_input=findViewById(R.id.nombre);
        apellido_input=findViewById(R.id.apellido);
        correo_electronico_input=findViewById(R.id.correo);
        nro_telefono_input=findViewById(R.id.telefono);
        monto_input=findViewById(R.id.monto);
    }

    public void atras(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra",id_obra);
        bundle.putInt("id_obra_bd",id_obra_bd);
        bundle.putIntArray("ids_obras_bd",ids_obras_bd);///
        Intent intent = new Intent( oferta.this, obra.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void menuPrincipal(View view){
        Intent intent = new Intent( oferta.this, MainActivity.class);
        startActivity(intent);
    }
    public void cargarOferta(View view){
        String nombre=null;
        String apellido=null;
        String correo_electronico=null;
        long nro_telefono=0;
        float monto=0;
        if(nombre_input.getText().toString().isEmpty()||apellido_input.getText().toString().isEmpty()||correo_electronico_input.getText().toString().isEmpty()
                ||correo_electronico_input.getText().toString().isEmpty()||nro_telefono_input.getText().toString().isEmpty()||monto_input.getText().toString().isEmpty()){
            Toast.makeText(this,"Por favor, Complete todos los campos.",Toast.LENGTH_SHORT).show();
        }else {
            nombre=nombre_input.getText().toString();
            apellido=apellido_input.getText().toString();
            correo_electronico=correo_electronico_input.getText().toString();
            nro_telefono=Long.parseLong(nro_telefono_input.getText().toString());
            monto=Float.parseFloat(monto_input.getText().toString());
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "baseDeDatos", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("id_obra", id_obra);
            registro.put("nombre", nombre);
            registro.put("apellido", apellido);
            registro.put("correo_electronico", correo_electronico);
            registro.put("nro_telefono", nro_telefono);
            registro.put("monto", monto);
            bd.insert("oferta", null, registro);
            Cursor cursor=bd.rawQuery("select * from oferta where id_obra == " + id_obra,null);
            Toast.makeText(this,"Oferta exitosa",Toast.LENGTH_LONG).show();
            bd.close();
            Bundle bundle=new Bundle();
            bundle.putInt("estilo",id_estilo);
            bundle.putInt("artista",id_artista);
            bundle.putString("nombre_artista",nombre_artista);
            bundle.putInt("id_obra",id_obra);
            bundle.putInt("id_obra_bd",id_obra_bd);
            bundle.putIntArray("ids_obras_bd",ids_obras_bd);///
            Intent intent = new Intent( oferta.this, obra.class);
            finish();
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}