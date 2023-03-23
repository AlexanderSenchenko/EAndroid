package com.example.eltex.testlist;

import static com.example.eltex.testlist.MainActivity.users;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ((RadioGroup) findViewById(R.id.radio_group)).setOnCheckedChangeListener((radioGroup, checkedId) -> {
            int visibilityDeveloperBlock = View.INVISIBLE;
            int visibilityManagerBlock = View.INVISIBLE;

            switch (checkedId) {
                case R.id.button_developer:
                    visibilityDeveloperBlock = View.VISIBLE;
                    visibilityManagerBlock = View.INVISIBLE;
                    break;

                case R.id.button_manager:
                    visibilityDeveloperBlock = View.INVISIBLE;
                    visibilityManagerBlock = View.VISIBLE;
                    break;
            }

            ((LinearLayout) findViewById(R.id.languages_block)).setVisibility(visibilityDeveloperBlock);
            ((LinearLayout) findViewById(R.id.count_projects_block)).setVisibility(visibilityManagerBlock);
        });

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
                    String languages = ((EditText) findViewById(R.id.languages)).getText().toString();

                    MainActivity:users.add(new Developer(name, phone, List.of(languages)));
                    break;

                case R.id.button_manager:
                    String countProjects = ((EditText) findViewById(R.id.count_projects)).getText().toString();

                    MainActivity:users.add(new Manager(name, phone, Integer.valueOf(countProjects)));
                    break;
            }

//            System.out.println(users.get(users.size() - 1).toString());

            finish();
        });
    }
}