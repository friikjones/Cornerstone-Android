package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.ContactList;
import com.derrick.park.assignment3_contacts.network.ContactClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    public static ArrayList<Contact> mContactList;
    public static final String TAG = MainActivity.class.getSimpleName();
    public static MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.contact_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Call<ContactList> call = ContactClient.getContacts(30);
        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                if (response.isSuccessful()) {
                    mContactList = response.body().getContactList();
                    sortContactList();
                    addDummyContacts();
                    sortContactList();

                    for(Contact contact: mContactList) {
                        Log.d(TAG, "onResponse: " + mContactList.size());
                        Log.d(TAG, "onResponse: " + contact.toString());
                    }
                    adapter = new MyRecyclerViewAdapter(MainActivity.this, mContactList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {
                Log.i("Check", "check Failure");
            }
        });


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

    public static void printContactList(){
        for (Contact c : mContactList) {
            Log.i("Contact", "Name: "+ c.getName()+", phone: "+c.getCell());
        }
    }

    public static void sortContactList(){
        Collections.sort(mContactList, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().toString().compareTo(o2.getName().toString());
            }
        });

    }

    public static void addDummyContacts(){
        Character auxChar = 'Z';

        ArrayList<Contact> outputList = (ArrayList) mContactList.clone();

        int j = 0;

        for(int i=0; i<mContactList.size();i++){
            if(auxChar != mContactList.get(i).getName().getFirst().charAt(0)){
                Contact dummy = new Contact();
                dummy.setName(new Contact.Name());
                dummy.getName().setFirst(""+mContactList.get(i).getName().getFirst().charAt(0));
                outputList.add(j,dummy);
                j++;
            }
            auxChar = mContactList.get(i).getName().getFirst().charAt(0);
            j++;
        }

        mContactList = (ArrayList) outputList.clone();
    }


}