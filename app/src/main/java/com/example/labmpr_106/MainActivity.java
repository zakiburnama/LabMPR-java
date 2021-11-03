package com.example.labmpr_106;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] text1 = {"Indonesi", "Jepang", "Russia", "Inggris", "Inggris", "Inggris"};
    String[] text2 = {"Jakarta", "Tokyo", "Moskow", "London", "Inggris", "Inggris"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        ArrayList<HashMap<String, String>>arrayList = new ArrayList<>();

        for (int i=0; i<text1.length; i++){
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("negara", text1[i]);
            hashMap.put("ibukota", text2[i] + "");
            arrayList.add(hashMap);
        }

        String[] from = {"negara", "ibukota"};
        int[] to = {R.id.negara, R.id.ibukota};
        SimpleAdapter adapter = new SimpleAdapter(
                this, arrayList,
                R.layout.desain,
                from,to
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), text1[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}