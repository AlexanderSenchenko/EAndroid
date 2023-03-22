package com.example.eltex.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        ListView mainList = (ListView) findViewById(R.id.main_list);

        users = new LinkedList<>();

        users.add(new Developer("Alex1", "100", List.of("Java", "Kotlin")));
        users.add(new Developer("Alex2", "200", List.of("C", "C++")));
        users.add(new Manager("Alex3", "300", 3));

        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);

        ((Button) findViewById(R.id.add_button)).setOnClickListener(view -> {
            Intent toAdd = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(toAdd);
        });
    }
}