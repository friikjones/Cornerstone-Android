package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.ContactList;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static ArrayList<Contact> mContactList;
    public static final String TAG = MainActivity.class.getSimpleName();

    MyRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.contact_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactList = new ContactList().getContactList();
        adapter = new MyRecyclerViewAdapter(this, mContactList);
        recyclerView.setAdapter(adapter);

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToAdd();
            }
        });

    }

    void navToAdd() {
        Intent intent = new Intent(this, AddContact.class);
        startActivity(intent);
    }

}