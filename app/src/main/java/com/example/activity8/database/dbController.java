package com.example.activity8.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class dbController extends SQLiteOpenHelper {
    public dbController(Context context) {
        super(context, "ProdiTI", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Teman (id integer primary key, nama text, telepon text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Teman");
        onCreate(db);
    }

    public void insertData(HashMap<String,String> queryValues){
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama",queryValues.get("nama"));
        nilai.put("telepon",queryValues.get("telepon"));

        basisdata.insert("Teman",null,nilai);
        basisdata.close();
    }

    public void UpdateData(HashMap<String, String> queryValues){
        SQLiteDatabase basisdata = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("telepon", queryValues.get("telepon"));
        basisdata.update("Teman", nilai, "id=?", new String[]{queryValues.get("id")});
        basisdata.close();
    }

    public void DeleteData(HashMap<String, String> queryValues){
        SQLiteDatabase basisdata = getWritableDatabase();
        basisdata.delete("Teman", "id=?", new String[]{queryValues.get("id")});
        basisdata.close();
    }

    public ArrayList<HashMap<String,String>> getAllTeman() {
        ArrayList<HashMap<String,String>> daftarTeman;
        daftarTeman = new ArrayList<HashMap<String,String>>();
        String selectQuery = "Select * From Teman";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("nama", cursor.getString(1));
                map.put("telepon", cursor.getString(2));
                daftarTeman.add(map);
            }while (cursor.moveToNext());
        }
        db.close();
        return daftarTeman;
    }


}
