package com.caiozero.githubtrendingrepos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.caiozero.githubtrendingrepos.R;

public class OptionActivity extends AppCompatActivity {

    private ListView listView;

    private String[] option ={"Daily","Weekly","Monthly"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        listView = findViewById(R.id.listView);

        final ArrayAdapter<String> adapterList = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                option
        );

        listView.setAdapter(adapterList);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String op = listView.getItemAtPosition(i).toString();

                if(op.equalsIgnoreCase("Daily")){
                  intent.putExtra("Op","Daily");
                }else if((op.equalsIgnoreCase("Weekly"))){
                  intent.putExtra("Op","Weekly");
                }else{
                   intent.putExtra("Op","Monthly");
                }
                startActivity(intent);
              }
        });

    }
}
