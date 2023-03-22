package com.example.eltex.testlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PhoneAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> users;

    public PhoneAdapter(Context context, List<User> users) {
        super(context, R.layout.item, users);
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(this.users.get(position).getName());

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(this.users.get(position).getPhone());

        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);

        if (this.users.get(position) instanceof Developer) {
            imageView.setImageResource(R.drawable.developer);
        } else if (this.users.get(position) instanceof Manager) {
            imageView.setImageResource(R.drawable.manager);
        } else {
            imageView.setImageResource(R.drawable.user);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toInfo = null;
                if (users.get(position) instanceof Developer) {
                    toInfo = new Intent(context, DevActivity.class);
                } else if (users.get(position) instanceof Manager) {
                    toInfo = new Intent(context, ManagerActivity.class);
                }
                toInfo.putExtra("name", users.get(position).getName());
                toInfo.putExtra("phone", users.get(position).getPhone());
                context.startActivity(toInfo);

//                Toast.makeText(context, users[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
