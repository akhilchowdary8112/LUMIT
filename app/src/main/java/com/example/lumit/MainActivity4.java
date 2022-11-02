package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    private DBHandler dbHandler;
    private EditText detailsPwdEdt, detailsUnameEdt;
    private static String value;
    private long pressedTime;

    public static String getValue() {
        return value;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        detailsUnameEdt=findViewById(R.id.et11);
        detailsPwdEdt=findViewById(R.id.et12);
        dbHandler=new DBHandler(MainActivity4.this);

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String detailsUname = detailsUnameEdt.getText().toString();
                String detailsPwd = detailsPwdEdt.getText().toString();

                value = detailsUnameEdt.getText().toString().trim();

                if (detailsUname.isEmpty() && detailsPwd.isEmpty()) {
                    Toast.makeText(MainActivity4.this, "Please enter the details..", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean a = dbHandler.checkuser(detailsUname, detailsPwd);
                if (a == true) {
                    Toast.makeText(MainActivity4.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent4);
                } else {
                    Toast.makeText(MainActivity4.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0=new Intent(MainActivity4.this,MainActivity12.class);
                startActivity(intent0);
            }
        });
    }
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}
