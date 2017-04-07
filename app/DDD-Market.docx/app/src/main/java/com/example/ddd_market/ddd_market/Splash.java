package com.example.ddd_market.ddd_market;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {


    ImageView lgSplash;
    Animation aumentar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        lgSplash = (ImageView)findViewById(R.id.logoSplash);

        miHilo xx = new miHilo();
        xx.start();
        aumentar = AnimationUtils.loadAnimation(this, R.anim.ampliar);
        aumentar.reset();
        lgSplash.setAnimation(aumentar);


    }

    public void ir(){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    class miHilo extends Thread{

        public void run(){

            for(int i =0;i<=5;i++){
                i++;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ir();

        }
    }
}
