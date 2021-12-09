package com.example.labmpr_106;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class usefirebase extends AppCompatActivity {

    private DatabaseReference mDatabases;
    EditText name, nim;
    ListView listView;
    List<User> listIndex;
    String selectedID;
    Button tambah, edit, hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usefirebase);

        mDatabases = FirebaseDatabase.getInstance().getReference();
        listView = findViewById(R.id.list_viewX);
        name = findViewById(R.id.name);
        nim = findViewById(R.id.nim);
        tambah = findViewById(R.id.tambah);
        edit = findViewById(R.id.edit);
        hapus = findViewById(R.id.hapus);
        listIndex = new ArrayList<>();

        tambah.setVisibility(View.VISIBLE);
        edit.setVisibility(View.INVISIBLE);
        hapus.setVisibility(View.INVISIBLE);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                User user = listIndex.get(position);
                name.setText(user.getName());
                nim.setText(user.getNim());
                selectedID = user.getId();
                tambah.setVisibility(View.INVISIBLE);
                edit.setVisibility(View.VISIBLE);
                hapus.setVisibility(View.VISIBLE);
                return true;
            }
        });
        GetData();
    }

    private void GetData() {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listIndex.clear();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    User user = ds.getValue(User.class);
                    listIndex.add(user);
                }
                ListAdaptor listAdaptor = new ListAdaptor(usefirebase.this, listIndex);
                listView.setAdapter(listAdaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDatabases.child("users").addValueEventListener(valueEventListener);
    }

    public void tambahuser(View view) {
        String name = this.name.getText().toString();
        String nim = this.nim.getText().toString();

        String id = String.valueOf(System.currentTimeMillis());
        User user = new User(id, name, nim);

        mDatabases.child("users").child(id).setValue(user);
    }

    public void Edit(View view) {
        DatabaseReference reference = mDatabases.child("users").child(selectedID);
        User user = new User(selectedID, name.getText().toString(), nim.getText().toString());
        reference.setValue(user);

        selectedID = "";
        name.setText("");
        nim.setText("");
        tambah.setVisibility(View.VISIBLE);
        edit.setVisibility(View.INVISIBLE);
        hapus.setVisibility(View.INVISIBLE);
    }

    public void Hapus(View view) {
        DatabaseReference reference = mDatabases.child("users").child(selectedID);
        reference.removeValue();

        selectedID = "";
        name.setText("");
        nim.setText("");
        tambah.setVisibility(View.VISIBLE);
        edit.setVisibility(View.INVISIBLE);
        hapus.setVisibility(View.INVISIBLE);
    }
}