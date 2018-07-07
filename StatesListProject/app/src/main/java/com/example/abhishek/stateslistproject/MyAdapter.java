package com.example.abhishek.stateslistproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> statesList;
    private Context mycontext;

    // Constructor
    public MyAdapter(ArrayList<String> statesList,Context mycontext) {
        this.statesList=statesList;
        this.mycontext=mycontext;
    }

    // Providing a reference to the views for each data item
    // you provide access to all the views for a data item in a view holder

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView statenameTextView;

        public ViewHolder(View view) {
            super(view);
            statenameTextView = view.findViewById(R.id.textView);

        }
    }
    
   
    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
         View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listviewitem, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.statenameTextView.setText(statesList.get(position));
        holder.statenameTextView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        if(holder.statenameTextView.getText()=="South Carolina")
        {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Columbia,+SC/@34.0371912,-81.2177529,10z/data=!3m1!4b1!4m5!3m4!1s0x88f8a5697931d1e3:0xf32808f4b379fa96!8m2!3d34.0007104!4d-81.0348144"));
            mycontext.startActivity(intent);
        }
        }
    });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return statesList.size();
    }

}
