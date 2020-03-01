package com.furkanyldrm.renkbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Besgen extends AppCompatActivity {
ImageView iv_buttonb,iv_arrowb;
ProgressBar progressBarb;
Handler handlerb;
Runnable runnableb;
Random r1;
TextView tv_pointsb;
    private final static int STATE_BLUEB=1;
    private final static int STATE_REDB =3;
    private final static int STATE_YELLOWB =4;
    private final static int STATE_GREENB=5;
    private final static int  STATE_PURPLEB=2;
    int buttonStateb=STATE_BLUEB;
    int arrowStateb=STATE_BLUEB;
    int currentTimeb=4000;
    int startTimeb=4000;
    int currentPointsb=25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_besgen);
        iv_arrowb = findViewById(R.id.iv_arrowb);
        iv_buttonb = findViewById(R.id.iv_buttonb);
        tv_pointsb = findViewById(R.id.tv_pointsb);
        progressBarb = findViewById(R.id.progressBarb);
        progressBarb.setMax(startTimeb);
        progressBarb.setProgress(startTimeb);
        tv_pointsb.setText("Score: " + currentPointsb);
        r1 = new Random();
        arrowStateb = r1.nextInt(5) + 1;
        setArrowImageb(arrowStateb);

        iv_buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonImageb(setButtonPositionb(buttonStateb));

            }
        });
        handlerb = new Handler();
        runnableb = new Runnable() {
            @Override
            public void run() {
                currentTimeb = currentTimeb - 100;
                progressBarb.setProgress(currentTimeb);
                if (currentTimeb > 0) {
                    handlerb.postDelayed(runnableb, 100);
                } else {
                    if (buttonStateb == arrowStateb) {
                        if (currentPointsb <= 40) {
                            currentPointsb = currentPointsb + 1;
                        }
                        if (currentPointsb == 40) {
                            Intent i8 = new Intent(getApplicationContext(), Altigen.class);
                            startActivity(i8);
                        }
                        tv_pointsb.setText("Score: " + currentPointsb);
                        startTimeb = startTimeb - 100;
                        if (startTimeb < 1000) {
                            startTimeb = 2000;
                        }
                        progressBarb.setMax(startTimeb);
                        currentTimeb = startTimeb;
                        progressBarb.setProgress(currentTimeb);
                        arrowStateb = r1.nextInt(4) + 1;
                        setArrowImageb(arrowStateb);
                        handlerb.postDelayed(runnableb, 100);
                    } else {
                        if (currentPointsb < 40) {
                            Intent i10 = new Intent(getApplicationContext(), Main3Activity.class);
                            i10.putExtra("SCORE",currentPointsb);
                            startActivity(i10);

                        }
                    }
                }
            }
            }

            ;

            handlerb.postDelayed(runnableb,100);

        }



    private void setArrowImageb(int state){
        switch(state){
            case STATE_PURPLEB:
                iv_arrowb.setImageResource(R.drawable.mor);
                arrowStateb=STATE_PURPLEB;
                break;
            case STATE_BLUEB:
                iv_arrowb.setImageResource(R.drawable.lacio);
                arrowStateb=STATE_BLUEB;
                break;
            case STATE_REDB:
                iv_arrowb.setImageResource(R.drawable.red);
                arrowStateb=STATE_REDB;
                break;
            case STATE_YELLOWB:
                iv_arrowb.setImageResource(R.drawable.yellow);
                arrowStateb=STATE_YELLOWB;
                break;
            case STATE_GREENB:
                iv_arrowb.setImageResource(R.drawable.green);
                arrowStateb=STATE_GREENB;
                break;
        }
    }
    private void setRotationb(final ImageView image,final int drawable){
        RotateAnimation rotateAnimation=new RotateAnimation(0,72, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(100);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.setImageResource(drawable);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        image.startAnimation(rotateAnimation);

    }

private int setButtonPositionb(int position){
        position=position+1;
        if(position==6){
        position=1;
        }
        return position;
        }
    private void setButtonImageb(int state) {
        switch (state) {
            case  STATE_PURPLEB:
                setRotationb(iv_buttonb,R.drawable.morb);
                buttonStateb=STATE_PURPLEB;
                break;
            case STATE_BLUEB:
                setRotationb(iv_buttonb, R.drawable.mavib);
                buttonStateb = STATE_BLUEB;
                break;
            case STATE_REDB:
                setRotationb(iv_buttonb, R.drawable.kirmizib);
                buttonStateb = STATE_REDB;
                break;
            case STATE_YELLOWB:
                setRotationb(iv_buttonb, R.drawable.sarib);
                buttonStateb = STATE_YELLOWB;
                break;
            case STATE_GREENB:
                setRotationb(iv_buttonb, R.drawable.yesilb);
                buttonStateb = STATE_GREENB;
                break;
        }
    }
}
