package com.furkanyldrm.renkbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
Button b1;
TextView t1;
TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    b1=findViewById(R.id.button);
    t1=findViewById(R.id.textView4);
t2=findViewById(R.id.textView5);
int score=getIntent().getIntExtra("SCORE",0);
t1.setText("Your Score: "+score);

        SharedPreferences settings=getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highscore =settings.getInt("HIGH_SCORE",0);
        if(score>highscore){
            t2.setText("High Score: "+score);
            SharedPreferences.Editor editor=settings.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }
        else{
            t2.setText("High Score: "+highscore);

        }
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i3=new Intent(getApplicationContext(),MainActivity.class);
    startActivity(i3);
    }
});
    }
}
