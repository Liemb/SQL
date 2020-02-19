package com.example.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.sql.gradess.GRADE;
import static com.example.sql.gradess.KEY_ID;
import static com.example.sql.gradess.QUARTER;
import static com.example.sql.gradess.TABLE_GRADES;
import static com.example.sql.Users.ADDRESS;
import static com.example.sql.Users.DAD_NAME;
import static com.example.sql.Users.DAD_NUM;
import static com.example.sql.Users.HOME_P;
import static com.example.sql.Users.MOM_NAME;
import static com.example.sql.Users.MOM_NUM;
import static com.example.sql.Users.NAME;
import static com.example.sql.Users.PHONE;
import static com.example.sql.Users.TABLE_USERS;
import static com.example.sql.gradess.KEY_ID;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;

    public HelperDB(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        strCreate="CREATE TABLE "+TABLE_USERS;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+ADDRESS+" TEXT,";
        strCreate+=" "+PHONE+" INTEGER,";
        strCreate+=" "+HOME_P+" INTEGER,";
        strCreate+=" "+MOM_NAME+" TEXT,";
        strCreate+=" "+MOM_NUM+" INTEGER,";
        strCreate+=" "+DAD_NAME+" TEXT,";
        strCreate+=" "+DAD_NUM+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE " + TABLE_GRADES;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+QUARTER+" INTEGER,";
        strCreate+=" "+GRADE+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        strDelete = "DROP TABLE IF EXISTS "+ TABLE_USERS;
        db.execSQL(strDelete);

        strDelete = "DROP TABLE IF EXISTS "+ TABLE_GRADES;
        db.execSQL(strDelete);

        onCreate(db);

    }
}