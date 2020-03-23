package com.java.trucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InteriorActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    Dialog commentDialog;
    static View.OnClickListener interiorOnClick;
    private static ArrayList<InteriorModel> data;
    private static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interior);
        setTitle(R.string.interior);
        commentDialog = new Dialog(this);
        interiorOnClick = new InteriorOnClickListener(this);
        recyclerView = findViewById(R.id.recycler_view_3);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data  = new ArrayList<InteriorModel>();
        for (int i = 0; i < InteriorData.interiorName.length; i++) {
            data.add(new InteriorModel(
                    InteriorData.interiorName[i],
                    InteriorData.id[i]
            ));
        }

        adapter = new InteriorAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    public void popup(View v){
        commentDialog.setContentView(R.layout.commentpopup);
        EditText comment;
        Button submit;
        TextView cancel;
        cancel = commentDialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentDialog.dismiss();
            }
        });
        commentDialog.show();
    }

    private class InteriorOnClickListener implements View.OnClickListener {

        private final Context context;

        private InteriorOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Shown", Toast.LENGTH_SHORT).show();
        }
    }
}
