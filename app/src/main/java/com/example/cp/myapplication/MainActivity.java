package com.example.cp.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationChannel channel = new NotificationChannel("article_channel", "Article channel", NotificationManager.IMPORTANCE_DEFAULT);

        channel.enableLights(true);
        channel.setLightColor(Color.BLUE);
        channel.enableVibration(true);
        channel.setVibrationPattern(new long[]{100, 100});

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        Notification notification = new Notification.Builder(this, channel.getId())
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("New article")
                .setContentText("There is a new article!")
                .setChannel(channel.getId())
                .build();

        manager.notify(0, notification);
    }
}
