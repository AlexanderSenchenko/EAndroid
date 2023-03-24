package com.example.eltex.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUsers();

        ListView mainList = (ListView) findViewById(R.id.main_list);
        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

        ((Button) findViewById(R.id.add_button)).setOnClickListener(view -> {
            Intent toAdd = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(toAdd);
        });

        testPreferences();
        System.out.println(">>> MainActivity create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(">>> MainActivity start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(">>> MainActivity resume");
        System.out.println(">>>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(">>> MainActivity pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(">>> MainActivity restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(">>> MainActivity stop");
        System.out.println(">>>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(">>> MainActivity destroy");
    }

    private void initUsers() {
        users = new LinkedList<>();

        SQLiteDatabase database = new DBHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users;", null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            switch (cursor.getString(3)) {
                case Developer.TYPE:
                    users.add(new Developer(Integer.valueOf(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            List.of("")));
                    break;

                case Manager.TYPE:
                    users.add(new Manager(Integer.valueOf(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            0));
                    break;
            }

            cursor.moveToNext();
        }

        cursor.close();
        database.close();

//        Developer dev = new Developer();
//        dev.fromCSV("Alex5;500;Rust");
//        Manager manager = new Manager();
//        manager.fromCSV("Alex6;600;4");
//        users.add(dev);
//        users.add(manager);
    }

    private void testPreferences() {
        SharedPreferences preferences = getSharedPreferences("INFO", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("APP_STATUS", "READY");
        editor.commit();

        Toast.makeText(this, preferences.getString("APP_STATUS", "STOP"), Toast.LENGTH_SHORT).show();
    }
}