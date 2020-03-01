package com.furkanyldrm.renkbul;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
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

public class MainActivity extends AppCompatActivity {
ImageView iv_button,iv_arrow;
TextView tv_points;
ProgressBar progressBar;
Handler handler;
Runnable runnable;
ImageView yildiz1;
ImageView yildiz2;
ImageView yildiz3;
Random r;
    private final static int STATE_BLUE =1;
    private final static int STATE_RED =4;
    private final static int STATE_YELLOW =2;
    private final static int STATE_GREEN =3;
    int buttonState=STATE_BLUE;
    int arrowState=STATE_BLUE;
  int currentTime=4000;
  int startTime=4000;
  int currentPoints=0;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 iv_button=findViewById(R.id.iv_button);

 iv_arrow=findViewById(R.id.iv_arrow);
 tv_points=findViewById(R.id.tv_points);
progressBar=findViewById(R.id.progressBar);
progressBar.setMax(startTime);
progressBar.setProgress(startTime);
tv_points.setText("Score: "+currentPoints);
r=new Random();
arrowState=r.nextInt(4)+1;
setArrowImage(arrowState);


iv_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
setButtonImage(setButtonPosition(buttonState));
    }
});
handler=new Handler();
runnable=new Runnable() {
    @Override
    public void run() {
        currentTime=currentTime-100;
        progressBar.setProgress(currentTime);
        if(currentTime>0){
            handler.postDelayed(runnable,100);
        }
        else{
            if(buttonState==arrowState){
                if(currentPoints<=25) {
                    currentPoints = currentPoints + 1;
                }
                if(currentPoints==25){
                    Intent i5=new Intent(getApplicationContext(),Besgen.class);
                    startActivity(i5);
                }
                tv_points.setText("Score: "+currentPoints);
            startTime=startTime-100;
            if(startTime<1000){
                startTime=2000;
            }
            progressBar.setMax(startTime);
            currentTime=startTime;
            progressBar.setProgress(currentTime);
            arrowState=r.nextInt(4)+1;
            setArrowImage(arrowState);
            handler.postDelayed(runnable,100);
            }
            else{
                if(currentPoints<25){
                    Intent i6=new Intent(getApplicationContext(),Main3Activity.class);
                    i6.putExtra("SCORE",currentPoints);

                    startActivity(i6);
                    
                }
            }

        }
    }
};
handler.postDelayed(runnable,100);

    }
    private void setArrowImage(int state){
        switch(state){
            case STATE_BLUE:
iv_arrow.setImageResource(R.drawable.blue);
arrowState=STATE_BLUE;
                break;
            case STATE_RED:
iv_arrow.setImageResource(R.drawable.red);
arrowState=STATE_RED;
                break;
            case STATE_YELLOW:
iv_arrow.setImageResource(R.drawable.yellow);
arrowState=STATE_YELLOW;
                break;
            case STATE_GREEN:
iv_arrow.setImageResource(R.drawable.green);
arrowState=STATE_GREEN;
                break;
        }
    }
    private void setRotation(final ImageView image,final int drawable){
        RotateAnimation rotateAnimation=new RotateAnimation(0,90, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
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
    private int setButtonPosition(int position){
        position=position+1;
        if(position==5){
            position=1;
        }
        return position;
    }
    private void setButtonImage(int state){
        switch(state){
            case STATE_BLUE:
                setRotation(iv_button,R.drawable.blues);
                buttonState=STATE_BLUE;
                break;
            case STATE_RED:
                setRotation(iv_button,R.drawable.reds);
                buttonState=STATE_RED;
                break;
            case STATE_YELLOW:
                setRotation(iv_button,R.drawable.yelows);
                buttonState=STATE_YELLOW;
                break;
            case STATE_GREEN:
                setRotation(iv_button,R.drawable.greens);
                buttonState=STATE_GREEN;
                break;
    }
}}
