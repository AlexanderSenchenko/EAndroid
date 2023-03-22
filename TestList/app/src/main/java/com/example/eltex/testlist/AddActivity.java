package com.example.eltex.testlist;

import static com.example.eltex.testlist.MainActivity.users;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ((Button) findViewById(R.id.add_button)).setOnClickListener(view -> {
            int checkedRadioButtonId = ((RadioGroup) findViewById(R.id.radio_group)).getCheckedRadioButtonId();
            String name = ((EditText) findViewById(R.id.name)).getText().toString();
            String phone = ((EditText) findViewById(R.id.phone)).getText().toString();

            if (name.isEmpty() || phone.isEmpty() || checkedRadioButtonId == -1) {
                Toast.makeText(this, "Input data is empty", Toast.LENGTH_SHORT).show();
                return;
            }

            switch (checkedRadioButtonId) {
                case R.id.button_developer:
                    MainActivity:users.add(new Developer(name, phone, List.of("")));
                    break;

                case R.id.button_manager:
                    MainActivity:users.add(new Manager(name, phone, 0));
                    break;
            }

            System.out.println(name + " " + phone);

            finish();
        });
    }
}