package com.example.eltex.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = (ListView) findViewById(R.id.main_list);

        User[] users = {
                new User("Alex1", "100"),
                new Developer("Alex2", "200", List.of("C", "C++")),
                new Manager("Alex3", "300", 3)
        };
        PhoneAdapter phoneAdapter = new PhoneAdapter(this, users);
        mainList.setAdapter(phoneAdapter);
    }
}