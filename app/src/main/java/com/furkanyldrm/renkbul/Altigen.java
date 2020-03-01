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

public class Altigen extends AppCompatActivity {

    ImageView iv_buttona,iv_arrowa;
    ProgressBar progressBara;
    Handler handlera;
    Runnable runnablea;
    Random r1;
    TextView tv_pointsb;
    private final static int STATE_BLUEA=1;
    private final static int STATE_REDA =2;
    private final static int STATE_YELLOWA =3;
    private final static int STATE_GREENA=6;
    private final static int STATE_ORANGEA=4;
    private final static int  STATE_PURPLEA=5;
    int buttonStatea=STATE_BLUEA;
    int arrowStatea=STATE_BLUEA;
    int currentTimea=4000;
    int startTimea=4000;
    int currentPointsa=40;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altigen);
        iv_arrowa=findViewById(R.id.iv_arrowa);
        iv_buttona=findViewById(R.id.iv_buttona);
        tv_pointsb=findViewById(R.id.tv_pointsa);
        progressBara=findViewById(R.id.progressBara);
        progressBara.setMax(startTimea);
        progressBara.setProgress(startTimea);
        tv_pointsb.setText("Score: "+currentPointsa);
        r1=new Random();
        arrowStatea= r1.nextInt(6)+1;
        setArrowImageb(arrowStatea);

        iv_buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonImagea(setButtonPositiona(buttonStatea));

            }
        });
        handlera=new Handler();
        runnablea=new Runnable() {
            @Override
            public void run() {
                currentTimea=currentTimea-100;
                progressBara.setProgress(currentTimea);
                if(currentTimea>0){
                    handlera.postDelayed(runnablea,100);
                }
                            else{
                        if(buttonStatea==arrowStatea) {
                                currentPointsa = currentPointsa + 1;
                                tv_pointsb.setText("Score: " + currentPointsa);
                                startTimea = startTimea - 100;
                                if (startTimea < 1000) {
                                    startTimea = 2000;
                                }
                                progressBara.setMax(startTimea);
                                currentTimea = startTimea;
                                progressBara.setProgress(currentTimea);
                                arrowStatea = r1.nextInt(5) + 1;
                                setArrowImageb(arrowStatea);
                                handlera.postDelayed(runnablea, 100);
                            }

                    else{
                        Intent i2=new Intent(getApplicationContext(),Main3Activity.class);
                            i2.putExtra("SCORE",currentPointsa);
                        startActivity(i2);
                    }
                }
            }
        };

        handlera.postDelayed(runnablea,100);

    }

    private void setArrowImageb(int state){
        switch(state){
            case STATE_PURPLEA:
                iv_arrowa.setImageResource(R.drawable.mor);
                arrowStatea=STATE_PURPLEA;
                break;
            case STATE_BLUEA:
                iv_arrowa.setImageResource(R.drawable.lacio);
                arrowStatea=STATE_BLUEA;
                break;
            case STATE_REDA:
                iv_arrowa.setImageResource(R.drawable.red);
                arrowStatea=STATE_REDA;
                break;
            case STATE_YELLOWA:
                iv_arrowa.setImageResource(R.drawable.yellow);
                arrowStatea=STATE_YELLOWA;
                break;
            case STATE_GREENA:
                iv_arrowa.setImageResource(R.drawable.green);
                arrowStatea=STATE_GREENA;
                break;
            case STATE_ORANGEA:
                iv_arrowa.setImageResource(R.drawable.turuncuo);
                arrowStatea=STATE_ORANGEA;
        break;
        }
    }
    private void setRotationa(final ImageView image,final int drawable){
        RotateAnimation rotateAnimation=new RotateAnimation(0,60, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
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

    private int setButtonPositiona(int position){
        position=position+1;
        if(position==7){
            position=1;
        }
        return position;
    }
    private void setButtonImagea(int state) {
        switch (state) {
            case  STATE_PURPLEA:
                setRotationa(iv_buttona,R.drawable.mora);
                buttonStatea=STATE_PURPLEA;
                break;
            case STATE_BLUEA:
                setRotationa(iv_buttona, R.drawable.lacia);
                buttonStatea = STATE_BLUEA;
                break;
            case STATE_REDA:
                setRotationa(iv_buttona, R.drawable.kirmizia);
                buttonStatea = STATE_REDA;
                break;
            case STATE_YELLOWA:
                setRotationa(iv_buttona, R.drawable.saria);
                buttonStatea = STATE_YELLOWA;
                break;
            case STATE_GREENA:
                setRotationa(iv_buttona, R.drawable.yesila);
                buttonStatea = STATE_GREENA;
                break;
            case STATE_ORANGEA:
                setRotationa(iv_buttona,R.drawable.turuncua);
                buttonStatea=STATE_ORANGEA;
                break;
        }
    }
}
