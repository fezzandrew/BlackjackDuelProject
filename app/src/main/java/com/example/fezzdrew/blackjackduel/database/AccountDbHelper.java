package com.example.fezzdrew.blackjackduel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static java.security.AccessController.getContext;

public class AccountDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Accounts.db";


    public AccountDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table account(account text, balance text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public boolean insertInAccount(String a1, String b1){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("account", a1);
        contentValues.put("balance", b1);

        long result = db.insert("account", null, contentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
