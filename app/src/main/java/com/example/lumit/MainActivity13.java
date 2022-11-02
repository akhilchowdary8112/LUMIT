package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity13 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String phoneNo;
    String message;
    Button butn;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        Spinner spin1 = (Spinner) findViewById(R.id.spinner6);
        spin1.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Desire Society(Kukatpally)");
        categories.add("Aadarana(Hyderabad)");
        categories.add("Aarthi(RAJAHMUNDRY )");
        categories.add("Aasha Jyothi Welfare Association For Disabled");
        categories.add("Aasritham(MAHABUBNAGAR)");
        categories.add("Abhaya Foundation(KHAIRATHABAD)");
        categories.add("Abhivrudhi Mahila Sangam(MACHILIPATNAM)");
        categories.add("Actionfor Child(Hyderabad)");
        categories.add("Acts Ngo(Hyderabad)");
        categories.add("Agnus Ganja Bojexio Social Service Society(Narasaraopet )");
        categories.add("A G R A(ANANTAPUR )");
        categories.add("Akshara Educational And Welfare Society(Gopalapatnam)");
        categories.add("Amar Society(Kurnool)");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(dataAdapter2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        findViewById(R.id.btn15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "6301021636";
                String msg = "We would like to donate food on " + str;
                addNotification();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Sms not sent", Toast.LENGTH_SHORT).show();
                }
                Intent intent50=new Intent(MainActivity13.this,MainActivity6.class);
                startActivity(intent50);
            }
        });
    }
    String msg="We received your request.\nYou will be contacted soon about food donation.\nThank you.";
    private void addNotification(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notify)
                .setContentTitle("LUMIT-Food Donation")
                .setContentText(msg)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        Intent notificationIntent = new Intent(this, MainActivity11.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", msg);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId("YOUR_PACKAGE_NAME");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "YOUR_PACKAGE_NAME",
                    "LUMIT",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
        notificationManager.notify(0,builder.build());
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
