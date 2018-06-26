package com.sintup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.marin.sintup.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final List<String> listItems =new ArrayList<String>();

        listItems.add("mechanical-engineering");
        listItems.add("electrical-engineering");
        listItems.add("computer science");

        ListView listNews = (ListView) findViewById(R.id.listNews);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, listItems);
        listNews.setAdapter(arrayAdapter);

        EditText activityTitle = (EditText) findViewById(R.id.activityTitle);
        activityTitle.setText("Изберете основна дисциплина.");
        activityTitle.setFocusable(false);

        listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(ProfileActivity.this, HomeActivity.class);
                i.putExtra("subject", listItems.get(position));
                startActivity(i);
            }
        });
    }

}
