package com.example.eltex.testlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "PHONES", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id NUMBER, name TEXT, phone TEXT);");
        db.execSQL("INSERT INTO USERS values (1, \"Alex1\", \"100\"), (2, \"Alex2\", 200), (3, \"Alex3\", 300);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users;");
        onCreate(db);
    }
}
