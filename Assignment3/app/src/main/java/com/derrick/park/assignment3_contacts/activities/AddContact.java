package com.derrick.park.assignment3_contacts.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    private Contact newContact;
    private Contact.Name auxName;
    private String nameStringFirst;
    private String nameStringSecond;
    private String cellString;
    MyRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        adapter = MainActivity.adapter;

        Button btnBack = findViewById(R.id.toolbar_back_button);
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnAdd = (Button) findViewById(R.id.btnAddContact);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newName = (EditText) findViewById(R.id.newNameAdd);
                EditText newPhone = (EditText) findViewById(R.id.newPhoneAdd);

                newContact = new Contact();
                auxName = new Contact.Name();

                if (newName.getText().toString().split(" ").length != 2) {
                    Toast.makeText(getApplicationContext(),"Name has to contain two words!",Toast.LENGTH_SHORT).show();


                    return;
                }else{
                    nameStringFirst = newName.getText().toString().split(" ")[0];
                    nameStringSecond = newName.getText().toString().split(" ")[1];
                }

                if (newPhone.getText().toString().length() != 10) {
                    Toast.makeText(getApplicationContext(),"Phone has to contains 10 digits only!",Toast.LENGTH_SHORT).show();

                    return;
                }else{
                    cellString = newPhone.getText().toString();
                }



                newContact.setCell(cellFormatter(cellString));
                auxName.setFirst(nameStringFirst);
                auxName.setLast(nameStringSecond);
                newContact.setName(auxName);

                Log.i("Check", "check made contact");
                Log.i("Check", newContact.toString());

                Log.i("Check", "check before add");
                MainActivity.mContactList.add(newContact);
                Log.i("Check", "check added");
                MainActivity.sortContactList();
                Log.i("Check", "check sorted");

                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(),"Contact added!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private String cellFormatter(String cell){

        String auxString = "";
        for(int i=0; i<10;i++){
            if(i==3 || i==6){
                auxString += "-";
                auxString += cell.charAt(i);
            }else{
                auxString += cell.charAt(i);
            }
        }
        return auxString;
    }
}
