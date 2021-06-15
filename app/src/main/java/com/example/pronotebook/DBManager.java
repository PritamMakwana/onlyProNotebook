package com.example.pronotebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    //constructer
    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESC, desc);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor fetch1() {
        String[] columns = new String[]{DatabaseHelper.ID,DatabaseHelper.SUBJECT,DatabaseHelper.DESC};

        Cursor cursor1 = database.query(DatabaseHelper.TABLE_NAME,columns,
                null,null,null,null,null);
        if (cursor1 != null) {
            cursor1.moveToFirst();
        }
        return cursor1;
    }

    public int update(long id,String name,String decs){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT,name);
        contentValues.put(DatabaseHelper.DESC,decs);

        int i =database.update(DatabaseHelper.TABLE_NAME,contentValues,DatabaseHelper.ID
                        +" = "+ id,null);

        return i;
    }

    public void delete(long id){
        database.delete(DatabaseHelper.TABLE_NAME,DatabaseHelper.ID + "="+ id,null);
    }

    public void update(String name, String decs) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT,name);
        contentValues.put(DatabaseHelper.DESC,decs);

        database.update(DatabaseHelper.TABLE_NAME,contentValues,DatabaseHelper.ID
                +" = ",null);
    }
}