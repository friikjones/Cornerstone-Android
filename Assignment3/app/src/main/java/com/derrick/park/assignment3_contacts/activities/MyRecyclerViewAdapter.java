package com.derrick.park.assignment3_contacts.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Contact> mData;
    private LayoutInflater mInflater;
    private static int VIEW_TYPE_ITEM = 0;
    private static int VIEW_TYPE_HEADER = 1;

    MyRecyclerViewAdapter(Context context, ArrayList<Contact> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_HEADER){
            View view = mInflater.inflate(R.layout.header_file, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = mInflater.inflate(R.layout.contact_item_file, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return VIEW_TYPE_HEADER;
        }else{
            if (mData.get(position).getName().getFirst().charAt(0) != mData.get(position-1).getName().getFirst().charAt(0))
                return VIEW_TYPE_HEADER;
            else {
                return VIEW_TYPE_ITEM;
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Contact person = mData.get(position);

        if(getItemViewType(position) == VIEW_TYPE_HEADER){
            ((HeaderViewHolder) holder).myHeader.setText("" + person.getName().getFirst().charAt(0));
        }else{
            ViewHolder hd = ((ViewHolder) holder);
            hd.myTextView.setText("" + person.getName());
            hd.myNumber.setText(""+person.getCell());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        TextView myNumber;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.myTextView);
            myNumber = itemView.findViewById(R.id.myNumber);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView myHeader;
        HeaderViewHolder(View itemView) {
            super(itemView);
            myHeader = itemView.findViewById(R.id.headerLabel);
        }
    }

}
