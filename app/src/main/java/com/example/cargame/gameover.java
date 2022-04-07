package com.example.cargame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameover extends AppCompatActivity {
    Button button;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        button=(Button) findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(gameover.this,MainActivity.class));
            }
        });
    }
}