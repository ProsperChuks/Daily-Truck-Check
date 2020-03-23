package com.java.trucks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class statusAdapter extends RecyclerView.Adapter<statusAdapter.MyViewHolder> {

    private ArrayList<StatusModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView statusTextName;
        AppCompatCheckBox imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.statusTextName = itemView.findViewById(R.id.textViewName2);
            this.imageViewIcon = itemView.findViewById(R.id.imageView2);
        }
    }

    public statusAdapter(ArrayList<StatusModel> data){
        this.dataSet = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.status_card_layout, parent, false);

        view.setOnClickListener(TruckCheckActivity.truckOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int Position) {

        TextView statusTextName = holder.statusTextName;
        AppCompatCheckBox imageView = holder.imageViewIcon;

        dataSet.get(Position);
        statusTextName.setText(dataSet.get(Position).getStatusName());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
