package com.example.lumit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity23 extends AppCompatActivity {
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;
EditText et201,et202;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        et201=findViewById(R.id.et76);
        et202=findViewById(R.id.et77);
        findViewById(R.id.btn80).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle="LUMIT-Food Donation";
                String subject=et201.getText().toString().trim();
                String body=et202.getText().toString().trim();
                Intent snoozeIntent = new Intent(MainActivity23. this, MainActivity23. class ) ;
                snoozeIntent.setAction( "ACTION_SNOOZE" ) ;
                snoozeIntent.putExtra( "EXTRA_NOTIFICATION_ID" , 0 ) ;
                PendingIntent snoozePendingIntent = PendingIntent. getBroadcast (MainActivity23. this, 0 , snoozeIntent , 0 ) ;
                NotificationManager mNotificationManager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE ) ;
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity23. this, default_notification_channel_id ) ;
                mBuilder.setContentTitle( subject ) ;
                mBuilder.setContentText( body ) ;
                mBuilder.setTicker(tittle) ;
                mBuilder.setSmallIcon(R.drawable. notification) ;
                mBuilder.addAction(R.drawable. ic_launcher_foreground , "Snooze" , snoozePendingIntent) ;
                mBuilder.setAutoCancel( true ) ;
                if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
                    int importance = NotificationManager. IMPORTANCE_HIGH ;
                    NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
                    mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
                    assert mNotificationManager != null;
                    mNotificationManager.createNotificationChannel(notificationChannel) ;
                }
                assert mNotificationManager != null;
                mNotificationManager.notify(( int ) System. currentTimeMillis () , mBuilder.build()) ;
                Toast.makeText(MainActivity23.this, "notification sent..", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn81).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}
