package com.java.trucks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class InteriorAdapter extends RecyclerView.Adapter<InteriorAdapter.MyViewHolder> {

    public ArrayList<InteriorModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView interiorName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.interiorName = itemView.findViewById(R.id.interiorName);
        }
    }

    InteriorAdapter(ArrayList<InteriorModel> data){
        this.dataSet = data;
    }

    @NonNull
    @Override
    public InteriorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.interior_card_layout, parent, false);

        view.setOnClickListener(InteriorActivity.interiorOnClick);
        MyViewHolder myView = new MyViewHolder(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull InteriorAdapter.MyViewHolder holder, int position) {
        TextView interiorName = holder.interiorName;

        dataSet.get(position);
        interiorName.setText(dataSet.get(position).getInteriorName());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
