package com.example.idrisadrien.appusers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by idrisadrien on 19/10/2017.
 */

public class UserDataSource {

    private final UserDBHelper helper;
    private SQLiteDatabase db;

    public UserDataSource(Context context){
        helper = new UserDBHelper(context);
    }

    public SQLiteDatabase getDB(){
        if(db == null){
            this.open();
        }
        return db;
    }

    public void open(){
        db = helper.getWritableDatabase();
    }

    public void close(){
        helper.close();
    }


    //factories
    public UserDAO newUserDAO(){
        return new UserDAO(this);
    }

}
