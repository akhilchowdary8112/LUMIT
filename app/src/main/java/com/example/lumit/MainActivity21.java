package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        findViewById(R.id.btn68).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent08=new Intent(MainActivity21.this,MainActivity22.class);
                startActivity(intent08);
            }
        });
        findViewById(R.id.btn69).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent09=new Intent(MainActivity21.this,MainActivity23.class);
                startActivity(intent09);
            }
        });
    }
}
