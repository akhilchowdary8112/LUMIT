package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity18 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);
        findViewById(R.id.btn61).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent00=new Intent(MainActivity18.this,MainActivity2.class);
                startActivity(intent00);
            }
        });
        findViewById(R.id.btn62).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent01=new Intent(MainActivity18.this,MainActivity19.class);
                startActivity(intent01);
            }
        });
    }
}
