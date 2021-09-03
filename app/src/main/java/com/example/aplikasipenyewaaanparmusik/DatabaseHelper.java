package com.example.aplikasipenyewaaanparmusik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
//    public DatabaseHelper(Context context){
//        super(context, "Parmusik.db", null, 1);
//    }
//    @Override
//    public void onCreate(SQLiteDatabase db){
//        db.execSQL("Create table user(email text primary key, password text, nama_lengkap text, no_telepon text, alamat text)");
//    }
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//        db.execSQL("drop table if exists user");
//    }
//    public boolean insert(String email,String password, String nama_lengkap, String no_telepon, String alamat){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("email", email);
//        contentValues.put("password", password);
//        contentValues.put("nama_lengkap", nama_lengkap);
//        contentValues.put("no_telepon", no_telepon);
//        contentValues.put("alamat", alamat);
//        long ins = db.insert("user", null, contentValues);
//        if(ins==-1) return false;
//        else return true;
//    }

    public static final String DATABASE_NAME = "pa2.db";
    public static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table users(email text primary key, nama_lengkap text null, password text null, nama_grup text null, no_telepon text null, alamat null);";
        Log.d("Data", "onCreate:" +sql);
        db.execSQL(sql);
        sql = "Insert INTO users(email, nama_lengkap, password, nama_grup, no_telepon, alamat) VALUES('tiarrotamba24@gmail.com', 'Tiarro Elprida Tamba', 'tiarro1108', 'Raja Parmusik','082277607321','Jakarta');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
    //checking the email and password
    public Boolean emailpassword(String Email, String Pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and password=?", new String[]{Email, Pass});
        if(cursor.getCount()>0) return true;
        else return  false;
    }

    public Boolean insert(String s1, String s2, String s3, String s4, String s5, String s6) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=? and nama_lengkap=? and password=? and nama_grup=? and no_telepon=? and alamat=?", new String[]{s1, s2, s3, s4, s5, s6});
        if(cursor.getCount()>0) return true;
        else return  false;
    }

    public Boolean chkemail(String s2) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?" ,new String[]{s2});
        if(cursor.getCount()>0) return false;
        else return true;
    }
}

