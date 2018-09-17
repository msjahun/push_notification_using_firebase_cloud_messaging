package com.example.dc.pushnotificationsfirebasecm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFireBaseMessagingService extends FirebaseMessagingService{
    private static final String TAG = "MyFireBaseMessagingServ";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: "+remoteMessage.getFrom() );

        //check if the message contins data

        if(remoteMessage.getData().size() >0){
            Log.d(TAG, "Message data  " + remoteMessage.getData());
        }

        //check if the message contains notifications

        if(remoteMessage.getNotification() !=null){
            Log.d(TAG, "Message body: " + remoteMessage.getNotification().getBody());


            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }







    }


    void showNotification(String title, String content) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(content)// message for notification

                .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(getApplicationContext(), FireBaseActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());
    }

}
