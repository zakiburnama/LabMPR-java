package com.example.labmpr_106;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    String[] text1 = {"Mercedes G Class", "SOON", "SOON", "SOON", "SOON", "SOON", "SOON", "SOON", "SOON"};
    String[] text2 = {"Rp 5M", "SOON", "SOON", "SOON", "SOON", "SOON", "SOON", "SOON", "SOON"};
    int img[] = {R.mipmap.ic_car_foreground, R.drawable.ic_calculating, R.drawable.ic_calculating, R.drawable.ic_calculating, R.drawable.ic_calculating, R.drawable.ic_calculating, R.drawable.ic_calculating, R.drawable.ic_calculating, R.drawable.ic_calculating};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolBar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("");

        // listView
        ListView listView = findViewById(R.id.list_view);
        MyAdapter adapter = new MyAdapter(this, text1, text2, img);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(),Modul2.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(),usefirebase.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), text1[position]+" SOON", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                final
                String[] warna = {"Merah", "Kuning", "Hijau", "Biru"};
                AlertDialog.Builder showlist = new AlertDialog.Builder(this);
                showlist.setItems(warna, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Snackbar snackbar = Snackbar.make(
                                findViewById(R.id.mainactivity),
                                "Anda memilih warna "+warna[i],
                                Snackbar.LENGTH_SHORT
                        );
                        snackbar.show();
                    }
                }).setTitle("Pilih warna yang anda sukai");
                showlist.create().show();
                return true;

            case R.id.action_about:
                Toast.makeText(this, "Aplikasi ini dibust oleh ZAKI 191401106", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_exit:
                final AlertDialog.Builder tutup = new AlertDialog.Builder(this);
                tutup.setMessage("Yakin keluar?")
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).create().show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //

    //MY ADAPTER
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rtext1[];
        String rtext2[];
        int rimg[];

        MyAdapter (Context c, String title[], String desc[], int imgs[]) {
            super(c, R.layout.desain, R.id.negara, title);
            this.context = c;
            this.rtext1 = title;
            this.rtext2 = desc;
            this.rimg = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View design = layoutInflater.inflate(R.layout.desain, parent, false);
            TextView atitle = design.findViewById(R.id.negara);
            TextView adesc = design.findViewById(R.id.ibukota);
            ImageView imageView = design.findViewById(R.id.gambar);

            //
            atitle.setText(rtext1[position]);
            adesc.setText(rtext2[position]);
            imageView.setImageResource(rimg[position]);

            return design;
        }
    }
}