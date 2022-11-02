package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity17 extends AppCompatActivity {
    private DBChild dbChild;
    TextView tva,tvname,tvage,tvgender;
    int a=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);

        Intent intent = getIntent();
        String str = intent.getStringExtra("key_age");

        dbChild=new DBChild(this);
        tva=findViewById(R.id.tv41);
        tvname=findViewById(R.id.tv42);
        tvage=findViewById(R.id.tv43);
        tvgender=findViewById(R.id.tv44);
        Cursor cursor1=dbChild.getChild(str);

        int ct=dbChild.total(str);
        tva.setText("Total children are:"+ct);

        findViewById(R.id.btn50).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a<=ct) {
                    tvname.setText("Name  :" + cursor1.getString(0));
                    tvage.setText("Age :" + cursor1.getString(1));
                    tvgender.setText("Gender:" + cursor1.getString(2));
                    cursor1.moveToNext();
                    a++;
                }
                else if(a>ct){
                    Toast.makeText(MainActivity17.this, "Done..", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        findViewById(R.id.btn51).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}
