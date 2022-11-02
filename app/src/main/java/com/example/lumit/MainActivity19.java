package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity19 extends AppCompatActivity {
private DBOrg dbOrg;
EditText et07,et08;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        et07=findViewById(R.id.et66);
        et08=findViewById(R.id.et67);
        dbOrg=new DBOrg(this);
        findViewById(R.id.btn63).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ct=et07.getText().toString();
                String pwd=et08.getText().toString();
                boolean valid=dbOrg.checkuser(ct,pwd);
                if(valid) {
                    Toast.makeText(MainActivity19.this, "success..", Toast.LENGTH_SHORT).show();
                    Intent intent03 = new Intent(MainActivity19.this, MainActivity21.class);
                    startActivity(intent03);
                }
                else{
                    Toast.makeText(MainActivity19.this, "invalid credentials..", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        findViewById(R.id.btn64).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent02=new Intent(MainActivity19.this,MainActivity20.class);
                startActivity(intent02);
            }
        });
    }
}

