package com.example.pronotebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Table name
    public static final String TABLE_NAME="NOTEBOOK";
//    Table Colum
    public static final String ID="_id";
    public static final String SUBJECT="subject";
    public static  final  String DESC="decription";

    //DataBASE information
    static final String DB_NAME="DATA_OF_NOTEBOOK";


    //database version
    static final int DB_VERSTION=1;

    //Creating Table Query
    private static final String  CREATE_TABLE= "create table " + TABLE_NAME + "(" + ID
            + "INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT + " TEXT NOT NULL, "
            + DESC + "TEXT);";

    public DatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSTION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //executing the query
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }


}
