package com.java.trucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<MainModel> data;
    static View.OnClickListener myOnClickListener;
    AppCompatCheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOnClickListener = new MyOnClickListener(this);
        recyclerView = findViewById(R.id.recycler_view_1);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        check = findViewById(R.id.imageView);

        data = new ArrayList<MainModel>();
        for (int i = 0; i < MainData.nameArray.length; i++) {
            data.add(new MainModel(
                    MainData.nameArray[i],
                    MainData.id_[i],
                    MainData.drawableArray[i]
            ));
        }
        adapter = new MainAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

            Intent checkActivity = new Intent(MainActivity.this, StatusActivity.class);
            startActivity(checkActivity);

        }
    }
}