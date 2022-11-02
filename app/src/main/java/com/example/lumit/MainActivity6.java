package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    int total_price=0;
    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent(MainActivity6.this,MainActivity7.class);
                startActivity(intent6);
            }
        });
        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7=new Intent(MainActivity6.this,MainActivity8.class);
                startActivity(intent7);
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8=new Intent(MainActivity6.this,MainActivity9.class);
                startActivity(intent8);
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9=new Intent(MainActivity6.this,MainActivity10.class);
                startActivity(intent9);
            }
        });
        findViewById(R.id.btn10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),Upi.class);
                Bundle bundle = new Bundle();  //create a bundle and send it to activity called upi class.
                bundle.putString("stuffs", Integer.toString(total_price));
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
        findViewById(R.id.ibutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent23 =new Intent(MainActivity6.this,MainActivity16.class);
                startActivity(intent23);
            }
        });
    }
}
