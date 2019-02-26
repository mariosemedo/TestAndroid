package com.example.alvin.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.sql.Time;
import java.util.Timer;

public class LoginPage extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    Button login;
    EditText input_username;
    View rectangle_userinput;
    EditText input_password;
    View rectangle_passinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        instantiateComponents();
    }


    private void instantiateComponents(){
        login = findViewById(R.id.button_login);
        login.setOnClickListener(this);

        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
        rectangle_userinput = findViewById(R.id.rectangle_userinput);
        rectangle_passinput = findViewById(R.id.rectangle_passwinput);

        input_username.setVisibility(View.INVISIBLE);
        rectangle_userinput.setVisibility(View.INVISIBLE);
        input_password.setVisibility(View.INVISIBLE);
        rectangle_passinput.setVisibility(View.INVISIBLE);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == login.getId()){
            Animation testAnim = AnimationUtils.loadAnimation(this, R.anim.test);
            Animation fadeAnim = AnimationUtils.loadAnimation(this, R.anim.fade);
            fadeAnim.setAnimationListener(this);

            login.startAnimation(testAnim);

            input_username.setVisibility(View.VISIBLE);
            input_password.setVisibility(View.VISIBLE);
            rectangle_userinput.setVisibility(View.VISIBLE);
            rectangle_passinput.setVisibility(View.VISIBLE);

            input_username.startAnimation(fadeAnim);
            rectangle_userinput.startAnimation(fadeAnim);
            input_password.startAnimation(fadeAnim);
            rectangle_passinput.startAnimation(fadeAnim);


//            startActivity(new Intent(LoginPage.this, Feed.class));
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        android.view.Display display = ((android.view.WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point parentDimensions = new Point();
        display.getSize(parentDimensions);

        Double hPos = input_username.getHeight()+display.getHeight()*0.9;

        input_username.setText(parentDimensions.x + " " + parentDimensions.y);

        input_username.setY(Math.round(input_username.getY()+(0.1 *parentDimensions.y)));
        input_password.setY(Math.round(input_password.getY()+(0.1 *parentDimensions.y)));
        rectangle_userinput.setY(Math.round(rectangle_userinput.getY()+(0.1 *parentDimensions.y)));
        rectangle_passinput.setY(Math.round(rectangle_passinput.getY()+(0.1 *parentDimensions.y)));
        login.setY(Math.round(login.getY()+(0.1 *parentDimensions.y)));

        input_password.clearAnimation();
        input_username.clearAnimation();
        rectangle_passinput.clearAnimation();
        rectangle_userinput.clearAnimation();
        login.clearAnimation();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
