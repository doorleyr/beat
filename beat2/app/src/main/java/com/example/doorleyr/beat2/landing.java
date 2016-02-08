package com.example.doorleyr.beat2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class landing extends AppCompatActivity {

    private int mode=-1; // -1 for none selected, 0 for cycle, 1 for walk
    private Button mMapButton;
    private Button mManualButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mMapButton = (Button)findViewById(R.id.mapButton);
        mManualButton = (Button)findViewById(R.id.manualButton);
        //wiring up the buttons to the inflated views

        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mode<0){
                    Toast.makeText(landing.this,
                            R.string.modeBlankToast,
                            Toast.LENGTH_SHORT).show();
                } else if (mode==0){
                    Log.v("mapButtonClick", "The Pick Route on Map button has been clicked and mode = Cycle");
                    Intent i = new Intent(landing.this, MapEntry.class);
                    i.putExtra("isPed",mode);
                    landing.this.startActivity(i);
                } else{
                    Log.v("mapButtonClick", "The Pick Route on Map button has been clicked and mode = Walk");
                    Intent i = new Intent(landing.this, MapEntry.class);
                    i.putExtra("isPed",mode);
                    landing.this.startActivity(i);
                }
            }
        });

        mManualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mode<0){
                    Toast.makeText(landing.this,
                            R.string.modeBlankToast,
                            Toast.LENGTH_SHORT).show();
                } else if (mode==0){
                    Log.v("manualButtonClick", "The Enter Route Info Manually button has been clicked and mode = Cycle");
                    Intent i = new Intent(landing.this, manualEntry.class);
                    i.putExtra("isPed",mode);
                    landing.this.startActivity(i);
                } else{
                    Log.v("manualButtonClick", "The Enter Route Info Manually button has been clicked and mode = Walk");
                    Intent i = new Intent(landing.this, manualEntry.class);
                    i.putExtra("isPed",mode);
                    landing.this.startActivity(i);
                }
            }
        });
    }

    public void onRadioButtonClicked(View view){
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // check which radio button is checked
        switch (view.getId()) {
            case R.id.radioWalk:
                if (checked)
                    mode=1;
                    Log.v("modeWalkSelect", "Mode 1, walk, has been selected");
                break;
            case R.id.radioCycle:
                if (checked)
                    mode=0;
                    Log.v("modeCycleSelect", "Mode 0, cycle, has been selected");
                break;
        }


    }
}
