package com.example.gaurav;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<model> datalist;

    public CustomAdapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.profile,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.fullname.setText(datalist.get(position).Fname);
        holder.Email.setText(datalist.get(position).Email);
        holder.Number.setText(datalist.get(position).MobileNo);

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView fullname, Email, Number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.fullname);
            Email = itemView.findViewById(R.id.Email);
            Number = itemView.findViewById(R.id.Number);
        }

    }
}
