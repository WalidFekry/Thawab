package com.App.Thwaap;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.App.Thwaap.utils.NotificationUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCMService";
    private static final int DAILY_NOTIFICATION_CODE = 1525;
    public static final String RANDOM_KEY = "Name";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        NotificationUtils.createNotificationChannel(this);

        String title = "";
        String body = "";

        if (remoteMessage.getNotification() != null) {
            title = remoteMessage.getNotification().getTitle();
            body = remoteMessage.getNotification().getBody();
        }

        Class<?> targetClass = null;
        if (remoteMessage.getData().containsKey(RANDOM_KEY)) {
            String className = remoteMessage.getData().get(RANDOM_KEY);
            if (className != null && !className.isEmpty()) {
                try {
                    targetClass = Class.forName(className);
                } catch (Exception e) {
                    Log.e(TAG, "Error resolving target class: " + e.getMessage());
                }
            }
        }

        if (targetClass == null) {
            targetClass = MainActivity.class;
        }

        sendNotification(title, body, targetClass);
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d(TAG, "Refreshed FCM token: " + token);
    }

    private void sendNotification(String title, String messageBody, Class<?> targetClass) {
        Intent intent = new Intent(this, targetClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        int flags = PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE;

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                DAILY_NOTIFICATION_CODE,
                intent,
                flags
        );

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NotificationUtils.CHANNEL_ID)
                .setSmallIcon(R.mipmap.icon_ico)
                .setContentTitle(title != null ? title : getString(R.string.app_name))
                .setContentText(messageBody != null ? messageBody : "")
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null) {
            notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
        }
    }
}
