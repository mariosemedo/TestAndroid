package com.example.alvin.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAdd1;
    private Button buttonAdd2;
    private TextView textCounter1;
    private TextView textCounter2;
    private int counter1 = 6;
    private int counter2 = 0;

    private RadioButton radioYes;
    private RadioButton radioNo;
    private TextView textMid;

    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiateComponents();
    }

    private void instantiateComponents(){
        buttonAdd1 = (Button) findViewById(R.id.button_add_1);
        buttonAdd1.setOnClickListener(this);
        buttonAdd2 = (Button) findViewById(R.id.button_add_2);
        buttonAdd2.setOnClickListener(this);
        textCounter1 = (TextView) findViewById(R.id.text_counter_1);
        textCounter1.setText(counter1+"");
        textCounter2 = (TextView) findViewById(R.id.text_counter_2);
        textCounter2.setText(counter2+"");
        buttonNext = (Button) findViewById(R.id.button_next);
        buttonNext.setOnClickListener(this);
        radioYes = (RadioButton) findViewById(R.id.radioButton_yes);
        radioYes.setOnClickListener(this);
        radioNo = (RadioButton) findViewById(R.id.radioButton_no);
        radioNo.setOnClickListener(this);
        textMid = (TextView) findViewById(R.id.textView_mid);
        textMid.setVisibility(View.VISIBLE);
        updateTextSum();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_add_1:
                counter1++;
                textCounter1.setText(counter1+"");
                 break;
            case R.id.button_add_2:
                counter2++;
                textCounter2.setText(counter2+"");
                break;
            case R.id.button_next:
                if(counter1 == 5 || counter2 == 5){
                    changeScreen(barber_feed.class);
                }else if(counter1 == 6 || counter2 == 6){
                    changeScreen(LoginPage.class);
                }else{
                    changeScreen(Second.class);
                }
                break;
            case R.id.radioButton_yes:
                textMid.setVisibility(View.VISIBLE);
                break;
            case R.id.radioButton_no:
                textMid.setVisibility(View.INVISIBLE);
                break;
        }
        updateTextSum();
    }

    private void changeScreen(Class c){
        startActivity(new Intent(MainActivity.this, c));
    }

    private void updateTextSum(){
        textMid.setText(counter1+counter2 + "");
    }
}
