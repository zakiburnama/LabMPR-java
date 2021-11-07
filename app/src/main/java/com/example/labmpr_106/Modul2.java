package com.example.labmpr_106;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Modul2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2);

        //MODUL 3
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("");

    }

    //MODUL 3
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Modul2.this, query, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //END MODUL 3

    //MODUL 4
    public void snackbar (View view) {
        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.constraintLayout),
                "Belum tersedia",
                Snackbar.LENGTH_SHORT
        );
        snackbar.show();
    }

    public void showlist (View view) {
        final
        String[] warna = {"Merah", "Kuning", "Hijau", "Biru"};
        AlertDialog.Builder showlist = new AlertDialog.Builder(this);
        showlist.setItems(warna, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar snackbar = Snackbar.make(
                        findViewById(R.id.constraintLayout),
                        "Anda memilih warna "+warna[i],
                        Snackbar.LENGTH_SHORT
                );
                snackbar.show();
            }
        }).setTitle("Pilih warna yang anda sukai");
        showlist.create().show();
    }

    public void close (View view) {
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
    }
    //END MODUL 4

    //PINDAH
    public void pindah (View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}