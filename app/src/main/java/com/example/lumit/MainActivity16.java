package com.example.lumit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity16 extends AppCompatActivity {
    private TextView tva,tvb,tvc,tvd,tve,tvf,tvg,tvh;
    private DBHandler dbHandler;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        tva = findViewById(R.id.tv1);
        tvb = findViewById(R.id.tv2);
        tvc = findViewById(R.id.tv3);
        tvd = findViewById(R.id.tv4);
        tve = findViewById(R.id.tv5);
        tvf = findViewById(R.id.tv6);
        tvg = findViewById(R.id.tv7);
        tvh = findViewById(R.id.tv8);
        builder = new AlertDialog.Builder(this);
        dbHandler = new DBHandler(MainActivity16.this);
        tve.setText(MainActivity4.getValue());
        String un=MainActivity4.getValue();
        Cursor cursor = dbHandler.getDetails(un);
        cursor.moveToFirst();
            tva.setText(cursor.getString(0));
            tvb.setText(cursor.getString(1));
            tvd.setText(cursor.getString(2));
            tvf.setText(cursor.getString(3));
            tvg.setText(cursor.getString(4));
            tvc.setText(cursor.getString(5));
            tvh.setText(cursor.getString(6));
            findViewById(R.id.btn20).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent37=new Intent(MainActivity16.this,MainActivity6.class);
                    startActivity(intent37);
                }
            });
            findViewById(R.id.btn21).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    builder.setMessage("Are you sure!\nYou want to delete your account?")
                            .setCancelable(false)
                            .setTitle("LUMIT says")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dbHandler.deleteuser(un);
                                    finishAffinity();
                                    System.exit(0);
                                    Toast.makeText(getApplicationContext(),"Account Deleted..",
                                            Toast.LENGTH_SHORT).show();
                                }
                                })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("LUMIT says");
                    alert.show();
                }
            });
    }
}





