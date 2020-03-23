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

public class StatusActivity extends AppCompatActivity {

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

        data = new ArrayList<>();
        for(int i = 0;i < StatusData.nameArray2.length; i++){
            data.add(new StatusModel(
                    StatusData.nameArray2[i],
                    StatusData.id_2[i],
                    StatusData.drawableArray2[i]
            ));
        }
        adapter = new StatusAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private class TruckOnClickListener implements View.OnClickListener {

        private final Context context;

        private TruckOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildLayoutPosition(v);
            String item = data.get(itemPosition).toString();

            if (data.get(0).toString().equals(item)) {

                Intent interior = new Intent(StatusActivity.this, InteriorActivity.class);
                startActivity(interior);

            }else if (data.get(1).toString().equals(item)) {

                Intent safety = new Intent(StatusActivity.this, SafetyActivity.class);
                startActivity(safety);

            }else if (data.get(2).toString().equals(item)) {

                Intent exterior = new Intent(StatusActivity.this, ExteriorActivity.class);
                startActivity(exterior);

            }else if (data.get(3).toString().equals(item)) {

                Intent general = new Intent(StatusActivity.this, GeneralActivity.class);
                startActivity(general);

            }
        }
    }
}
