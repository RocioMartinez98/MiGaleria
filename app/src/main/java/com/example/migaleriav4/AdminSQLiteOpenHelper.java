package com.example.migaleriav4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable
            String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL("create table estilo (id_estilo int primary key not null,nombre_estilo text not null)");
        baseDeDatos.execSQL("create table artista (id_artista int primary key not null,nombre_artista text not null)");
        baseDeDatos.execSQL("create table obras_artista (id_obra int primary key not null,id_artista int not null,id_estilo int not null,nombre_obra text not null,año_creacion int not null,precio_estimado float not null,nombre_dueño text not null,nro_telefono bigint not null,foreign key (id_artista) references artista(id_artista),foreign key (id_estilo) references estilo(id_estilo))");
        baseDeDatos.execSQL("create table oferta (id_oferta integer primary key autoincrement not null,id_obra int not null,nombre text not null,apellido text not null,correo_electronico text not null,nro_telefono bigint not null,monto float not null,foreign key (id_obra) references obra(id_obra))");
        baseDeDatos.execSQL("insert into estilo(id_estilo, nombre_estilo) values (1,'Bodegon')");
        baseDeDatos.execSQL("insert into estilo(id_estilo, nombre_estilo) values (2,'Abstracto')");
        baseDeDatos.execSQL("insert into estilo(id_estilo, nombre_estilo) values (3,'Religion')");
        baseDeDatos.execSQL("insert into estilo(id_estilo, nombre_estilo) values (4,'Paisaje')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (1,'Carmen Sarai')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (2,'Jose Dias')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (3,'Pablo Elias')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (4,'Luis Quioga')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (5,'Paola Yan')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (6,'Carola Luz')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (7,'Pedro Funez')");
        baseDeDatos.execSQL("insert into artista(id_artista, nombre_artista) values (8,'Dalma Perez')");

        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (1,1,1,'foto10',2022,1550,'Carmen Sarai',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (2,1,1,'foto11',2021,15000,'Carmen Sarai',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (3,1,1,'foto12',2000,50000,'Carmen Sarai',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (4,1,1,'foto16',2022,54450,'Carmen Sarai',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (5,1,1,'foto17',1986,5880,'Carmen Sarai',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (6,1,2,'foto7',1888,8000,'Carmen Sarai',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (7,1,2,'foto8',1988,8000,'Carmen Sarai',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (8,1,2,'foto9',1978,8000,'Carmen Sarai',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (9,1,2,'foto22',1999,10000,'Carmen Sarai',2664101220)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (10,1,2,'foto23',1963,10000,'Carmen Sarai',2664101220)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (11,2,3,'foto4',2005,15000,'Jose Dias',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (12,2,3,'foto5',2003,15000,'Jose Dias',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (13,2,3,'foto6',2014,155000,'Jose Dias',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (14,2,3,'foto24',2015,200000,'Jose Dias',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (15,2,3,'foto25',2003,20000,'Jose Dias',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (16,2,4,'foto1',2000,750000,'Jose Dias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (17,2,4,'foto2',2001,10000,'Jose Dias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (18,2,4,'foto3',2002,1000,'Jose Dias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (19,2,4,'foto20',2018,100000,'Jose Dias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (20,2,4,'foto21',2017,50000,'Jose Dias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (21,3,2,'foto7',2015,60000,'Pablo Elias',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (22,3,2,'foto8',2014,50000,'Pablo Elias',2664101220)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (23,3,2,'foto9',2014,120000,'Pablo Elias',2664101220)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (24,3,2,'foto22',2013,12000,'Pablo Elias',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (25,3,2,'foto23',2014,520000,'Pablo Elias',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (26,3,3,'foto4',2011,15000,'Pablo Elias',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (27,3,3,'foto5',2012,50000,'Pablo Elias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (28,3,3,'foto6',2012,65000,'Pablo Elias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (29,3,3,'foto24',2013,50000,'Pablo Elias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (30,3,3,'foto25',2015,54000,'Pablo Elias',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (31,4,4,'foto1',2016,32000,'Luis Quioga',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (32,4,4,'foto2',2011,35000,'Luis Quioga',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (33,4,4,'foto3',2009,50000,'Luis Quioga',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (34,4,4,'foto20',2008,540000,'Luis Quioga',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (35,4,4,'foto21',2007,50000,'Luis Quioga',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (36,4,3,'foto4',2017,54000,'Luis Quioga',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (37,4,3,'foto5',2018,50000,'Luis Quioga',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (38,4,3,'foto6',2022,5000,'Luis Quioga',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (39,4,3,'foto24',2014,5000,'Luis Quioga',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (40,4,3,'foto25',2003,1000,'Luis Quioga',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (41,5,1,'foto10',2015,10000,'Paola Yan',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (42,5,1,'foto11',2012,10000,'Paola Yan',2664101220)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (43,5,1,'foto12',2000,100000,'Paola Yan',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (44,5,1,'foto26',2000,15000,'Paola Yan',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (45,5,1,'foto17',2000,15000,'Paola Yan',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (46,5,3,'foto4',2000,54000,'Paola Yan',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (47,5,3,'foto5',2001,10000,'Paola Yan',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (48,5,3,'foto6',2001,1000,'Paola Yan',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (49,5,3,'foto24',2001,10000,'Paola Yan',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (50,5,3,'foto25',2002,15000,'Paola Yan',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (51,6,2,'foto7',2003,1500,'Carola Luz',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (52,6,2,'foto8',2003,5000,'Carola Luz',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (53,6,2,'foto9',2003,40000,'Carola Luz',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (54,6,2,'foto22',2005,4000,'Carola Luz',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (55,6,2,'foto23',2006,15000,'Carola Luz',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (56,6,1,'foto10',2005,15000,'Carola Luz',2664012856)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (57,6,1,'foto11',2004,54000,'Carola Luz',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (58,6,1,'foto12',2005,50000,'Carola Luz',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (59,6,1,'foto16',2005,50000,'Carola Luz',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (60,6,1,'foto17',2002,50000,'Carola Luz',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (61,7,1,'foto10',1985,15000,'Pedro Funez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (62,7,1,'foto11',1775,15000,'Pedro Funez',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (63,7,1,'foto12',1899,15000,'Pedro Funez',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (64,7,1,'foto16',1898,5000,'Pedro Funez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (65,7,1,'foto17',1989,5000,'Pedro Funez',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (66,7,4,'foto1',1985,50000,'Pedro Funez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (67,7,4,'foto2',1985,50000,'Pedro Funez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (68,7,4,'foto3',1968,50000,'Pedro Funez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (69,7,4,'foto20',1986,15000,'Pedro Funez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (70,7,4,'foto21',1987,150000,'Pedro Funez',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (71,8,2,'foto7',1978,15000,'Dalma Perez',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (72,8,2,'foto8',1975,15000,'Dalma Perez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (73,8,2,'foto9',1976,1500,'Dalma Perez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (74,8,2,'foto22',1994,15000,'Dalma Perez',2665878806)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (75,8,2,'foto23',1996,15000,'Dalma Perez',2664101220)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (76,8,4,'foto1',1998,15000,'Dalma Perez',2664012545)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (77,8,4,'foto2',1999,15000,'Dalma Perez',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (78,8,4,'foto3',1998,15000,'Dalma Perez',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (79,8,4,'foto20',1999,15000,'Dalma Perez',2664015487)");
        baseDeDatos.execSQL("insert into obras_artista(id_obra, id_artista,id_estilo,nombre_obra,año_creacion,precio_estimado,nombre_dueño,nro_telefono) " +
                "values (80,8,4,'foto21',1999,15000,'Dalma Perez',2664015487)");



    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

}
