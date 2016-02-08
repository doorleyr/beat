package com.example.doorleyr.beat2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class manualEntry extends AppCompatActivity {
    private int isPed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_entry);

        //get Intent from previous screen
        isPed= getIntent().getIntExtra("isPed", 0);
        TextView mIsPedText=(TextView)findViewById(R.id.isPedText);
        if(isPed==1){
            mIsPedText.setText("Ped");
    }
        else mIsPedText.setText("Cycle");

        }
}
