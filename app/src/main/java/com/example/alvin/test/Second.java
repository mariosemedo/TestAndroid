package com.example.alvin.test;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity implements View.OnClickListener {

    private TextView title;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instantiateComponents();
    }

    private void instantiateComponents(){
        title = (TextView) findViewById(R.id.text_title);
        buttonBack = (Button) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button_back){
            startActivity(new Intent(Second.this, MainActivity.class));
        }
    }
}
