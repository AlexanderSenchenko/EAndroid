package com.example.eltex.testlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DevActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);

        Intent info = getIntent();
        String id = info.getStringExtra("user_id");
        String name = info.getStringExtra("name");
        String phone = info.getStringExtra("phone");

        ((TextView) findViewById(R.id.user_id)).setText(id);
        ((TextView) findViewById(R.id.name)).setText(name);
        ((TextView) findViewById(R.id.phone)).setText(phone);
    }
}