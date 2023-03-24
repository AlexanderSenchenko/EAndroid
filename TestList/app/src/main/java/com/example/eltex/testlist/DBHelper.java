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
        db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, phone TEXT NOT NULL, type TEXT CHECK( type IN ('D', 'M') ));");
        db.execSQL("INSERT INTO users (name, phone, type) VALUES (\"Alex1\", \"100\", \"M\"), (\"Alex2\", \"200\", \"M\"), (\"Alex3\", \"300\", \"D\");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users;");
        onCreate(db);
    }
}
