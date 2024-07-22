package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class imagenes extends AppCompatActivity {

    private int id_artista=0;
    private int id_estilo=0;
    private int []id_obras;
    private String nombre_artista=null;
    private ImageButton btn_obra_1;
    private ImageButton btn_obra_2;
    private ImageButton btn_obra_3;
    private ImageButton btn_obra_4;
    private ImageButton btn_obra_5;
    private TextView obras_de;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);
        Bundle bundle=this.getIntent().getExtras();
        id_estilo=(int)bundle.getInt("estilo");
        id_artista=(int)bundle.getInt("artista");
        nombre_artista=(String)bundle.getString("nombre_artista");
        obras_de=(TextView) findViewById(R.id.titulo_obras_artista);
        btn_obra_1=(ImageButton) findViewById(R.id.imagen1);
        btn_obra_2=(ImageButton) findViewById(R.id.imagen2);
        btn_obra_3=(ImageButton) findViewById(R.id.imagen3);
        btn_obra_4=(ImageButton) findViewById(R.id.imagen4);
        btn_obra_5=(ImageButton) findViewById(R.id.imagen5);
        obras_de.setText("Obras de: "+nombre_artista);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"baseDeDatos",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select id_obra from obras_artista where id_estilo== "+id_estilo + " and id_artista== "+id_artista,null);

        if(fila.moveToFirst()){
            id_obras = new int[fila.getCount()];
            int i = 0;
            do {
                id_obras[i] = Integer.parseInt(fila.getString(0));
                i++;
            }while (fila.moveToNext());
        }else{
            Toast.makeText(this,"No hay imagenes disponibles",Toast.LENGTH_SHORT).show();
        }
        switch (id_estilo){
            case(1):{
                btn_obra_1.setImageResource(R.drawable.foto10);
                btn_obra_2.setImageResource(R.drawable.foto11);
                btn_obra_3.setImageResource(R.drawable.foto12);
                btn_obra_4.setImageResource(R.drawable.foto16);
                btn_obra_5.setImageResource(R.drawable.foto17);
                break;
            }
            case(2):{
                btn_obra_1.setImageResource(R.drawable.foto7);
                btn_obra_2.setImageResource(R.drawable.foto8);
                btn_obra_3.setImageResource(R.drawable.foto9);
                btn_obra_4.setImageResource(R.drawable.foto22);
                btn_obra_5.setImageResource(R.drawable.foto23);
                break;
            }
            case(3):{
                btn_obra_1.setImageResource(R.drawable.foto4);
                btn_obra_2.setImageResource(R.drawable.foto5);
                btn_obra_3.setImageResource(R.drawable.foto6);
                btn_obra_4.setImageResource(R.drawable.foto24);
                btn_obra_5.setImageResource(R.drawable.foto25);
                break;
            }
            case(4):{
                btn_obra_1.setImageResource(R.drawable.foto1);
                btn_obra_2.setImageResource(R.drawable.foto2);
                btn_obra_3.setImageResource(R.drawable.foto3);
                btn_obra_4.setImageResource(R.drawable.foto20);
                btn_obra_5.setImageResource(R.drawable.foto21);
                break;
            }

        }

        bd.close();
    }

    public void atras(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        Intent intent = new Intent( imagenes.this, artistas.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void menuPrincipal(View view){
        Intent intent = new Intent( imagenes.this, MainActivity.class);
        startActivity(intent);
    }
    public void imagen1(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra",1);
        bundle.putInt("id_obra_bd",id_obras[0]);
        bundle.putIntArray("ids_obras_bd",id_obras);
        Intent intent = new Intent( imagenes.this, obra.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void imagen2(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra",2);
        bundle.putInt("id_obra_bd",id_obras[1]);
        bundle.putIntArray("ids_obras_bd",id_obras);
        Intent intent = new Intent( imagenes.this, obra.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void imagen3(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra",3);
        bundle.putInt("id_obra_bd",id_obras[2]);
        bundle.putIntArray("ids_obras_bd",id_obras);
        Intent intent = new Intent( imagenes.this, obra.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void imagen4(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra",4);
        bundle.putInt("id_obra_bd",id_obras[3]);
        bundle.putIntArray("ids_obras_bd",id_obras);

        Intent intent = new Intent( imagenes.this, obra.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void imagen5(View view){
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra",5);
        bundle.putInt("id_obra_bd",id_obras[4]);
        bundle.putIntArray("ids_obras_bd",id_obras);
        Intent intent = new Intent( imagenes.this, obra.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}