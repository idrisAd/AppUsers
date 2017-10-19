package com.example.idrisadrien.appusers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by idrisadrien on 19/10/2017.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="User.db";
    public static final int DB_VERSION=1;

    public UserDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static String getQueryCreate(){
        return "CREATE TABLE User("
                +"id Integer PRIMARY KEY AUTOINCREMENT,"
                +"nom Text NOT NULL,"
                +"prenom Text NOT NULL,"
                +"sexe Text NOT NULL,"
                +"metier Text NOT NULL,"
                +"service Text NOT NULL,"
                +"mail Text NOT NULL,"
                +"tel Text NOT NULL,"
                +"resume Text NOT NULL"
                +");";
    }

    public static String getQueryDrop(){
        return "DROP TABLE IF EXISTS User;";
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getQueryCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(getQueryDrop());
        db.execSQL(getQueryCreate());
    }
}
