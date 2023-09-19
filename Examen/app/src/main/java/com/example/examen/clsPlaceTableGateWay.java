package com.example.examen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class clsPlaceTableGateWay extends SQLiteOpenHelper {

    private Context ctx;
    private SQLiteDatabase myDb;

    public clsPlaceTableGateWay(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS place(id_place integer primary key autoincrement, adresse text, statut text , plaque_matriculation text);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS place;";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public void Open(){this.myDb = this.getWritableDatabase();}
    public void Close(){this.myDb.close();}

    public void SeedNewPlace()
    {
        this.myDb.execSQL("INSERT INTO place(adresse,statut,plaque_matriculation) values('hochelaga1','occupee','ABC1')");
        this.myDb.execSQL("INSERT INTO place(adresse,statut,plaque_matriculation) values('hochelaga2','occupee','55F')");
        this.myDb.execSQL("INSERT INTO place(adresse,statut,plaque_matriculation) values('hochelaga3','dispo','none')");
        this.myDb.execSQL("INSERT INTO place(adresse,statut,plaque_matriculation) values('hochelaga4','dispo','none')");
        this.myDb.execSQL("INSERT INTO place(adresse,statut,plaque_matriculation) values('hochelaga5','occupee','X5X')");
        this.myDb.execSQL("INSERT INTO place(adresse,statut,plaque_matriculation) values('hochelaga6','dispo','none')");
        this.myDb.execSQL("INSERT INTO place(adresse,statut,plaque_matriculation) values('hochelaga7','dispo','none')");

    }

    public ArrayList<clsPlace> FindALLPlace()
    {

        ArrayList<clsPlace> place = new ArrayList<clsPlace>();

        Cursor cursor = this.myDb.rawQuery("select * from place",null);

        int idIndex = cursor.getColumnIndex("id_place");
        int adressIndex = cursor.getColumnIndex("adresse");
        int StatutIndex = cursor.getColumnIndex("statut");
        int plaqueIndex = cursor.getColumnIndex("plaque_matriculation");



        if((cursor != null) && cursor.moveToFirst())
        {
            do{
                place.add(new clsPlace(cursor.getInt(idIndex),cursor.getString(adressIndex),cursor.getString(StatutIndex),cursor.getString(plaqueIndex)));
            }while(cursor.moveToNext());
        }

        return place;
    }

    public ArrayList<clsPlace> FindJustDipo()
    {
        ArrayList<clsPlace> place = new ArrayList<clsPlace>();

        Cursor cursor = this.myDb.rawQuery("select * from place where statut = 'dispo'", null);

        int idIndex = cursor.getColumnIndex("id_place");
        int adressIndex = cursor.getColumnIndex("adresse");
        int StatutIndex = cursor.getColumnIndex("statut");
        int plaqueIndex = cursor.getColumnIndex("plaque_matriculation");

        if((cursor != null) && cursor.moveToFirst())
        {
            do{
                place.add(new clsPlace(cursor.getInt(idIndex),cursor.getString(adressIndex),cursor.getString(StatutIndex),cursor.getString(plaqueIndex)));
            }while(cursor.moveToNext());
        }

        return place;
    }

    public ArrayList<clsPlace> ChercherPlaceAvecPlaque(String plaque)
    {
        ArrayList<clsPlace> place = new ArrayList<clsPlace>();
        Cursor cursor = this.myDb.rawQuery("select * from place where plaque_matriculation = '"+plaque+"'", null);

        int idIndex = cursor.getColumnIndex("id_place");
        int adressIndex = cursor.getColumnIndex("adresse");
        int StatutIndex = cursor.getColumnIndex("statut");
        int plaqueIndex = cursor.getColumnIndex("plaque_matriculation");

        if((cursor != null) && cursor.moveToFirst())
        {
            do{
                place.add(new clsPlace(cursor.getInt(idIndex),cursor.getString(adressIndex),cursor.getString(StatutIndex),cursor.getString(plaqueIndex)));
            }while(cursor.moveToNext());
        }

        return place;
    }


    public void DeleteAll(){this.myDb.delete("place",null,null);};
}
