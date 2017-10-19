package com.example.idrisadrien.appusers;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idrisadrien on 19/10/2017.
 */

class UserDAO {
    private static final String TABLE_NAME = "User";
    private static final String COL_ID = "id";
    private static final String COL_NOM = "nom";
    private static final String COL_PRENOM = "prenom";
    private static final String COL_GENRE = "sexe";
    private static final String COL_JOB = "metier";
    private static final String COL_SERVICE = "service";
    private static final String COL_MAIL = "mail";
    private static final String COL_PHONE = "tel";
    private static final String COL_RESUME = "resume";
    private static final String CLAUSE = " = ?";
    private final UserDataSource userDataSource;

    public UserDAO(UserDataSource userDataSource){
        this.userDataSource = userDataSource;
    }

    public synchronized User create(User user){
        // Création du tableau associatif
        ContentValues values = new ContentValues();
        values.put(COL_NOM, user.getNom());
        values.put(COL_PRENOM, user.getPrenom());
        values.put(COL_GENRE, user.getSexe());
        values.put(COL_JOB, user.getMetier());
        values.put(COL_SERVICE, user.getService());
        values.put(COL_MAIL, user.getMail());
        values.put(COL_PHONE, user.getTel());
        values.put(COL_RESUME, user.getResume());

        // Insert query
        Integer id = (int)userDataSource.getDB().insert(TABLE_NAME, null,values);


        return user;
    }


    public synchronized User upDate(User user){
        // Création du tableau associatif
        ContentValues values = new ContentValues();
        values.put(COL_NOM, user.getNom());
        values.put(COL_PRENOM, user.getPrenom());
        values.put(COL_GENRE, user.getSexe());
        values.put(COL_JOB, user.getMetier());
        values.put(COL_SERVICE, user.getService());
        values.put(COL_MAIL, user.getMail());
        values.put(COL_PHONE, user.getTel());
        values.put(COL_RESUME, user.getResume());

        // where clause
        String clause = COL_ID + CLAUSE;
        String[] clauseArgs = new String[]{user.getId().toString()};

        // update
        userDataSource.getDB().update(TABLE_NAME, values, clause, clauseArgs);

        // return the user
        return user;
    }

    public synchronized void delete(User user){
        // where clause
        String clause = COL_ID + CLAUSE ;
        String[] clauseArgs = new String[]{user.getId().toString()};

        // delete
        userDataSource.getDB().delete(TABLE_NAME, clause, clauseArgs);
    }


    public User read(User user){
        String[]allColumns = new String[]{COL_ID,COL_NOM,COL_PRENOM,COL_GENRE,COL_JOB,COL_SERVICE,
                COL_MAIL,COL_PHONE,COL_RESUME};

        // Clause
        String clause = COL_ID + CLAUSE;
        String[] clauseArgs = new String[]{user.getId().toString()};

        // select query
        Cursor cursor = userDataSource.getDB().query(TABLE_NAME,allColumns, "ID = ?", clauseArgs, null, null, null);

        // read cursor
        cursor.moveToFirst();
        user.setNom(cursor.getString(1));
        user.setPrenom(cursor.getColumnName(2));
        user.setSexe(cursor.getColumnName(3));
        user.setMetier(cursor.getColumnName(4));
        user.setService(cursor.getColumnName(5));
        user.setMail(cursor.getColumnName(6));
        user.setTel(cursor.getColumnName(7));
        user.setResume(cursor.getColumnName(8));
        cursor.close();

        return user;

    }


    public synchronized List<User> readAll(){
        String allColumns[] = new String[]{COL_ID,COL_NOM,COL_PRENOM,COL_GENRE,COL_JOB,COL_SERVICE,
                COL_MAIL,COL_PHONE,COL_RESUME};
        // Select query
        Cursor cursor = userDataSource.getDB().query(TABLE_NAME,allColumns,null,null,null,null,null);

        List<User> users = new ArrayList<User>();
        // Iteration dans la liste pour lecture de tous les users
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            users.add(new User(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8)));
            cursor.moveToNext();
        }
        cursor.close();

        return users;
    }

}
