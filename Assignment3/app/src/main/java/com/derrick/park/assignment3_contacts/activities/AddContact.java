package com.derrick.park.assignment3_contacts.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    private Contact newContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);


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
                TextView newName = (TextView) findViewById(R.id.newNameAdd);
                TextView newPhone = (TextView) findViewById(R.id.newPhoneAdd);

                if (newName.getText().toString().split(" ").length != 2) {
                    Toast.makeText(getApplicationContext(),"Name has to contain two words!",Toast.LENGTH_SHORT).show();
                    //Write into name
                    return;
                }

                if (newPhone.getText().toString().length() != 10) {
                    Toast.makeText(getApplicationContext(),"Phone has to contains 10 digits only!",Toast.LENGTH_SHORT).show();
                    newContact.setCell(newPhone.getText().toString());
                    return;
                }

                MainActivity.mContactList.add(newContact);
                MyList.getInstance().contactList.add(new contact(newName.getText().toString(), newPhone.getText().toString()));
                MyList.getInstance().sortList();

                Toast.makeText(getApplicationContext(),"Contact added!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
