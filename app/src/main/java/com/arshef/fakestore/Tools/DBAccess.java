package com.arshef.fakestore.Tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBAccess extends SQLiteAssetHelper {
    private static String DATABASE_NAME = "db.db";
    private static int DATABASE_VERSION = 1;
    SQLiteDatabase db;

    public DBAccess(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }

    public SQLiteDatabase getDb() {
        return db;
    }

}
