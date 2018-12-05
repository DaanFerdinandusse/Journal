package com.example.daan.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static EntryDatabase getInstance(Context context){
        if (instance != null){
            return instance;
        } else{
            instance = new EntryDatabase(context, null, null, 1);
            return instance;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table Journal ( _id  INTEGER PRIMARY KEY, titel TEXT, content TEXT, mood INTEGER, time DATETIME DEFAULT CURRENT_TIMESTAMP);";
        db.execSQL(query);

        ContentValues cv = new ContentValues();
        cv.put("titel", "iets");
        cv.put("content", "er is hier content");
        cv.put("mood", 2);
        db.insert("Journal", null, cv);
        ContentValues ev = new ContentValues();
        ev.put("titel", "nog iets");
        ev.put("content", "er is hier content");
        ev.put("mood", 2);
        db.insert("Journal", null, ev);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Journal");
        onCreate(db);
    }

    public Cursor selectAll(){
        SQLiteDatabase db = instance.getWritableDatabase();
        return db.rawQuery("SELECT * FROM Journal", null);
    }

    public void insert(Entry e){
        SQLiteDatabase db = instance.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("titel", e.getTitle());
        cv.put("content", e.getContent());
        cv.put("mood", e.getMood());
        db.insert("Journal", null, cv);
    }

    public void delete(long id){
        SQLiteDatabase db = instance.getWritableDatabase();
        db.delete("Journal", "_id="+id, null);
    }
}
