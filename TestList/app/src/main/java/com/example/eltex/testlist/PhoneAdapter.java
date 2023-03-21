package com.example.eltex.testlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PhoneAdapter extends ArrayAdapter<User> {

    private Context context;
    private User[] users;

    public PhoneAdapter(Context context, User[] users) {
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
        name.setText(this.users[position].getName());

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(this.users[position].getPhone());

        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);
        imageView.setImageResource(R.drawable.user);

        return view;
    }
}
