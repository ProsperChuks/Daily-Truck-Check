package com.java.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExteriorActivity extends AppCompatActivity {

    Dialog commentDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exterior);
        setTitle(R.string.exterior);
        commentDialog = new Dialog(this);
    }
    public void popup(View v){
        commentDialog.setContentView(R.layout.commentpopup);
        EditText comment;
        Button submit;
        TextView cancel;
        cancel = (TextView) commentDialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentDialog.dismiss();
            }
        });
        commentDialog.show();
    }
}
