package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        findViewById(R.id.btn20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent21=new Intent(MainActivity14.this,MainActivity5.class);
                startActivity(intent21);
            }
        });
    }
}
