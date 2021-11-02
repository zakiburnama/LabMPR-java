package com.example.labmpr_106;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Modul2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
    }

    public boolean onCreateOptionMenu(Menu menu){
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

    public boolean onOptionsItemsSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                return true;

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
}