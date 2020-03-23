package com.java.trucks;

import androidx.appcompat.app.AppCompatActivity;
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
    private static ArrayList<Model> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myOnClickListener = new MyOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_1);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<Model>();
        for (int i = 0; i < Data.nameArray.length; i++) {
            data.add(new Model(
                    Data.nameArray[i],
                    Data.id_[i],
                    Data.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        adapter = new Adapter(data);
        recyclerView.setAdapter(adapter);
    }


    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Intent sec = new Intent(MainActivity.this, TruckCheckActivity.class);
            startActivity(sec);
        }
    }

//        @Override
//        public void onClick(View v) {
//            removeItem(v);
//        }

//        private void removeItem(View v) {
//            int selectedItemPosition = recyclerView.getChildPosition(v);
//            RecyclerView.ViewHolder viewHolder
//                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
//            TextView textViewName
//                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
//            String selectedName = (String) textViewName.getText();
//            int selectedItemId = -1;
//            for (int i = 0; i < Data.nameArray.length; i++) {
//                if (selectedName.equals(Data.nameArray[i])) {
//                    selectedItemId = Data.id_[i];
//                }
//            }
//            removedItems.add(selectedItemId);
//            data.remove(selectedItemPosition);
//            adapter.notifyItemRemoved(selectedItemPosition);
//        }
//    }
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        super.onOptionsItemSelected(item);
//        if (item.getItemId() == R.id.add_item) {
//            //check if any items to add
//            if (removedItems.size() != 0) {
//                addRemovedItemToList();
//            } else {
//                Toast.makeText(this, "Nothing to add", Toast.LENGTH_SHORT).show();
//            }
//        }
//        return true;
//    }
//
//    private void addRemovedItemToList() {
//        int addItemAtListPosition = 1;
//        data.add(addItemAtListPosition, new Model(
//                Data.nameArray[removedItems.get(0)],
//                Data.id_[removedItems.get(0)],
//                Data.drawableArray[removedItems.get(0)]
//        ));
//        adapter.notifyItemInserted(addItemAtListPosition);
//        removedItems.remove(0);
//    }
}