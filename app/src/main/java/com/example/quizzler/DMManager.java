package com.example.quizzler;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DMManager extends SQLiteOpenHelper {

    public DMManager(Context context ) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(EmailID TEXT primary key,DOB TEXT,PlaceofResidence TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Userdetails");
    }
    public boolean insertuserdata(String EmailID,String DOB,String PlaceofResidence){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("EmailID",EmailID);
        contentValues.put("DOB",DOB);
        contentValues.put("PlaceofResidence",PlaceofResidence);
        long result=DB.insert("Userdetails",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
}
