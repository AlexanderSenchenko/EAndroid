package com.example.eltex.testlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PhoneAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] names;

    public PhoneAdapter(Context context, String[] names) {
        super(context, R.layout.item, names);
        this.context = context;
        this.names = names;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(this.names[position]);
        return view;
    }
}
