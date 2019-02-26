package com.example.alvin.test;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class barber_feed extends AppCompatActivity implements View.OnClickListener {

    private Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_feed);
//        instantiateComponents();
    }


    private void instantiateComponents(){
        button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Log.e("BUTTON_PRESS", "hello");
//        if(v.getId() == R.id.button_back){
//            startActivity(new Intent(barber_feed.this, MainActivity.class));
//        }
    }
}
