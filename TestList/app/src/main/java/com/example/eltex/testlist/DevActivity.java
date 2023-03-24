package com.example.eltex.testlist;

import static com.example.eltex.testlist.MainActivity.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DevActivity extends AppCompatActivity {

    private Integer id;

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

        this.id = Integer.valueOf(id);

        initUpdateButton();
        initRemoveButton();

        System.out.println(">>> DevActivity create");
    }

    public void initUpdateButton() {
        ((Button) findViewById(R.id.update_button)).setOnClickListener(view -> {
            Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show();
        });
    }

    public void initRemoveButton() {
        ((Button) findViewById(R.id.remove_button)).setOnClickListener(view -> {
            Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show();

// Не работает!!! Из базы удаляется, из списка удаляется, но на экране почему-то не обновляется, так
// как getView в адатере не отрабатывает. А при добавленее он почему-то отрабатывает.
// Есть какой-то вариант добраться до адаптера и сделать уведомление, но это выглядит как-то сложно
//            SQLiteDatabase database = new DBHelper(getApplicationContext()).getWritableDatabase();
//            database.execSQL("delete from users where id = " + id + ";");
//
//            MainActivity.users.removeIf(user -> (user.getId().equals(id)));
//
//            finish();
        });
    }
}