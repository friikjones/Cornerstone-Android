package com.example.project_assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_assignment3.database.Contact
import com.example.project_assignment3.database.ContactKt
import com.example.project_assignment3.database.ContactList
import com.example.project_assignment3.network.ContactClient
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    lateinit var ContactList: MutableList<ContactKt>;

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        populateList()
        fetchList()
    }

    fun populateList(){
        val thisContact = ContactKt("John Doe", "0123456789")
        ContactList = mutableListOf(thisContact)

        val newContact = ContactKt("Jane Jones", "0011223344")
        ContactList.add(newContact)

//        for(c in ContactList)
//            Log.i("List", "Contact name: ${c.name}, cell: ${c.cell}")
    }

    fun fetchList(){
            val call = ContactClient.getContacts(10);
            val result = call.execute().body();

            Log.i("CALL", "Result: ${result.toString()}")
    }

}
