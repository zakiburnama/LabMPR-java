package com.example.labmpr_106;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdaptor extends ArrayAdapter<User>{
    private Activity contex;
    private List<User> userList;
    public ListAdaptor(usefirebase context, List<User> userList) {
        super(context, R.layout.list_user, userList);
        this.contex = context;
        this.userList = userList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = contex.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_user, null, true);
        TextView name = listViewItem.findViewById(R.id.name);
        TextView nim = listViewItem.findViewById(R.id.nim);
        User user = userList.get(position);
        name.setText(user.getName());
        nim.setText(user.getNim());
        return listViewItem;
    }
}
