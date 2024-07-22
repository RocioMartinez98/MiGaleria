package com.example.migaleriav4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class obra extends AppCompatActivity {

    private int id_estilo=0;
    private int id_artista=0;
    private String nombre_artista=null;
    private int id_obra=0;
    private int id_obra_bd=0;
    private int [] ids_obras_bd;
    private ImageView obra;
    private androidx.constraintlayout.widget.ConstraintLayout layout;
    private SwipeListener swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obra);
        Bundle bundle=this.getIntent().getExtras();
        id_estilo=(int)bundle.getInt("estilo");
        id_artista=(int)bundle.getInt("artista");
        nombre_artista=(String)bundle.getString("nombre_artista");
        id_obra=(int)bundle.getInt("id_obra");
        id_obra_bd=(int)bundle.getInt("id_obra_bd");
        ids_obras_bd=(int[])bundle.getIntArray("ids_obras_bd");///
        obra=(ImageView) findViewById(R.id.imagenCompleta);
        layout = (ConstraintLayout) findViewById(R.id.idlayout);
        swipe = new SwipeListener(layout);
        switch (id_estilo){
            case(1):{
                switch (id_obra){
                    case(1):{
                        obra.setImageResource(R.drawable.foto10);
                        break;
                    }
                    case(2):{
                        obra.setImageResource(R.drawable.foto11);
                        break;
                    }
                    case(3):{
                        obra.setImageResource(R.drawable.foto12);
                        break;
                    }
                    case(4):{
                        obra.setImageResource(R.drawable.foto16);
                        break;
                    }
                    case(5):{
                        obra.setImageResource(R.drawable.foto17);
                        break;
                    }
                }
                break;
            }
            case(2):{
                switch (id_obra){
                    case(1):{
                        obra.setImageResource(R.drawable.foto7);
                        break;
                    }
                    case(2):{
                        obra.setImageResource(R.drawable.foto8);
                        break;
                    }
                    case(3):{
                        obra.setImageResource(R.drawable.foto9);
                        break;
                    }
                    case(4):{
                        obra.setImageResource(R.drawable.foto22);
                        break;
                    }
                    case(5):{
                        obra.setImageResource(R.drawable.foto23);
                        break;
                    }
                }
                break;
            }
            case(3):{
                switch (id_obra){
                    case(1):{
                        obra.setImageResource(R.drawable.foto4);
                        break;
                    }
                    case(2):{
                        obra.setImageResource(R.drawable.foto5);
                        break;
                    }
                    case(3):{
                        obra.setImageResource(R.drawable.foto6);
                        break;
                    }
                    case(4):{
                        obra.setImageResource(R.drawable.foto24);
                        break;
                    }
                    case(5):{
                        obra.setImageResource(R.drawable.foto25);
                        break;
                    }
                }
                break;
            }
            case(4):{
                switch (id_obra){
                    case(1):{
                        obra.setImageResource(R.drawable.foto1);
                        break;
                    }
                    case(2):{
                        obra.setImageResource(R.drawable.foto2);
                        break;
                    }
                    case(3):{
                        obra.setImageResource(R.drawable.foto3);
                        break;
                    }
                    case(4):{
                        obra.setImageResource(R.drawable.foto20);
                        break;
                    }
                    case(5):{
                        obra.setImageResource(R.drawable.foto21);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void volver(View view) {
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        Intent intent = new Intent(obra.this, imagenes.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void menuPrinicpal(View view) {
        Intent intent = new Intent(obra.this, MainActivity.class);
        startActivity(intent);
    }
    public void infoObra(View view) {
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra", id_obra);
        bundle.putInt("id_obra_bd", id_obra_bd);
        bundle.putIntArray("ids_obras_bd",ids_obras_bd);///
        Intent intent = new Intent(obra.this, infoImagen.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void oferta(View view) {
        Bundle bundle=new Bundle();
        bundle.putInt("estilo",id_estilo);
        bundle.putInt("artista",id_artista);
        bundle.putString("nombre_artista",nombre_artista);
        bundle.putInt("id_obra", id_obra);
        bundle.putInt("id_obra_bd", id_obra_bd);
        bundle.putIntArray("ids_obras_bd",ids_obras_bd);///
        Intent intent = new Intent(obra.this, oferta.class);
        finish();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private class SwipeListener implements View.OnTouchListener{
        GestureDetector gestureDetector;
        SwipeListener(View view){
            int threshlod=100;
            int velocity = 100;
            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener(){
                        @Override
                        public boolean onDown(MotionEvent e) {
                            return true;
                        };
                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                            float xDiff = e2.getX() - e1.getX();
                            float yDiff = e2.getY() - e1.getY();
                            try {
                                if (Math.abs(xDiff)>Math.abs(yDiff)){
                                    if(Math.abs(xDiff)>threshlod
                                            && Math.abs(velocityX)>velocity){
                                        if(xDiff>0){
                                            if( (id_obra-1) >= 1) {
                                                Bundle bundle = new Bundle();
                                                bundle.putInt("estilo", id_estilo);
                                                bundle.putInt("artista", id_artista);
                                                bundle.putString("nombre_artista", nombre_artista);
                                                bundle.putInt("id_obra", id_obra - 1);
                                                bundle.putInt("id_obra_bd", ids_obras_bd[id_obra - 1] - 1);
                                                bundle.putIntArray("ids_obras_bd", ids_obras_bd);
                                                Intent intent = new Intent(obra.this, obra.class);
                                                finish();
                                                intent.putExtras(bundle);
                                                startActivity(intent);
                                            }
                                        }else{
                                            if((id_obra+1) <= 5) {
                                                Bundle bundle=new Bundle();
                                                bundle.putInt("estilo",id_estilo);
                                                bundle.putInt("artista",id_artista);
                                                bundle.putString("nombre_artista",nombre_artista);
                                                bundle.putInt("id_obra",id_obra+1);
                                                bundle.putInt("id_obra_bd",ids_obras_bd[id_obra-1]+1);
                                                bundle.putIntArray("ids_obras_bd",ids_obras_bd);
                                                Intent intent = new Intent( obra.this, obra.class);
                                                finish();
                                                intent.putExtras(bundle);
                                                startActivity(intent);
                                            }
                                        }
                                        return true;
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return  false;
                        }
                    };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }
}