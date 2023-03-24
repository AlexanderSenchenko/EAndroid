package com.example.eltex.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLData;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById(R.id.main_list);

        Developer dev = new Developer();
        dev.fromCSV("Alex5;500;Rust");

        Manager manager = new Manager();
        manager.fromCSV("Alex6;600;4");

        users = new LinkedList<>();

//        users.add(new Developer("Alex1", "100", List.of("Java", "Kotlin")));
//        users.add(new Developer("Alex2", "200", List.of("C", "C++")));
//        users.add(new Manager("Alex3", "300", 3));
//        users.add(dev);
//        users.add(manager);

        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

        ((Button) findViewById(R.id.add_button)).setOnClickListener(view -> {
            Intent toAdd = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(toAdd);
        });

        SharedPreferences preferences = getSharedPreferences("INFO", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("APP_STATUS", "READY");
        editor.commit();

        Toast.makeText(this, preferences.getString("APP_STATUS", "STOP"), Toast.LENGTH_SHORT).show();

        SQLiteDatabase database = new DBHelper(this).getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users;", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            System.out.println("User: " + cursor.getString(1) + ": " + cursor.getString(2));

            switch (cursor.getString(3)) {
                case "D":
                    users.add(new Developer(cursor.getString(1), cursor.getString(2), List.of("")));
                    break;

                case "M":
                    users.add(new Manager(cursor.getString(1), cursor.getString(2), 0));
                    break;
            }

            cursor.moveToNext();
        }
        cursor.close();

        users.add(dev);
        users.add(manager);
    }
}