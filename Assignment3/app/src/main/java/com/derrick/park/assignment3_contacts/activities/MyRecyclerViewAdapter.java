package com.derrick.park.assignment3_contacts.activities;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contact> mData;
    private ArrayList<String> mHeaders;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Character checkingChar = 0;
    private int headerPosition = 0;
    private boolean headerFlag = true;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, ArrayList<Contact> data, ArrayList<String> headers) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mHeaders = headers;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.contact_item_file, parent, false);
        if(headerFlag){
            view = mInflater.inflate(R.layout.header_file, parent, false);
        }

        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact person = mData.get(position);
        String header = mHeaders.get(headerPosition);

        if(headerFlag){
            holder.myHeader.setText("" + header);
            headerPosition++;
            headerFlag = false;
        }else{
            holder.myTextView.setText("" + person.getName());
            holder.myNumber.setText(person.getCell());
            if(person.getName().getFirst().charAt(0) != checkingChar){
                headerFlag = true;
            }
            checkingChar = person.getName().getFirst().charAt(0);
        }

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        TextView myNumber;
        TextView myHeader;

        ViewHolder(View itemView) {
            super(itemView);
            if(headerFlag){
                myHeader = itemView.findViewById(R.id.headerLabel);
            }else{
                myTextView = itemView.findViewById(R.id.myTextView);
                myNumber = itemView.findViewById(R.id.myNumber);
            }

        }
    }

//    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
