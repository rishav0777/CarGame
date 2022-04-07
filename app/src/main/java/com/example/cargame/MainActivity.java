package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {



    private final int inte=30;
    gammer game;
    Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       game=new gammer(this);
        setContentView(game);
        Timer timer=new Timer();
     timer.schedule(new TimerTask() {
         @Override
         public void run() {
             handler.post(new Runnable() {
                 @Override
                 public void run() {
                     game.invalidate();
                 }
             });
         }
     },0,inte);


    }
}