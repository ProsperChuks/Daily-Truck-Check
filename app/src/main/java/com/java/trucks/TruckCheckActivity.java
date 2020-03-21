package com.java.trucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class TruckCheckActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static RecyclerView.LayoutManager layoutManager;
    private static ArrayList<StatusModel> data;
    static View.OnClickListener truckOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_check);
        setTitle(R.string.truck_check);

        truckOnClickListener = new TruckOnClickListener(this);
        recyclerView = findViewById(R.id.recycler_view_2);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<StatusModel>();
        for(int i = 0;i < StatusData.nameArray2.length; i++){
            data.add(new StatusModel(
                    StatusData.nameArray2[i],
                    StatusData.id_2[i],
                    StatusData.drawableArray2[i]
            ));
        }
        adapter = new statusAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private class TruckOnClickListener implements View.OnClickListener {

        private final Context context;

        private TruckOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Intent thi = new Intent(TruckCheckActivity.this, InteriorActivity.class);
            startActivity(thi);
        }
    }
}
