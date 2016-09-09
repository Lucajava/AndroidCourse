package course.dstech.it.androidcourse.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import course.dstech.it.androidcourse.MainActivity;
import course.dstech.it.androidcourse.R;

/**
 * Created by federico on 02/02/16.
 */
public class NotificationUtil {

    public static final int NOTIFICATION_ID = 0x1;

    private static final String TAG = "NotificationUtil";

    public static void sendNotification(Context context, String notificationText) {
        try {
            Intent notifyIntent = new Intent(context, MainActivity.class);
            PendingIntent intent = PendingIntent.getActivity(context, 0,
                    notifyIntent, PendingIntent.FLAG_CANCEL_CURRENT);
            String appName = context.getString(R.string.app_name);
            String trickerMessage = notificationText;
            String contentTitle = appName;


            NotificationCompat.Builder builder = new  NotificationCompat.Builder(context)

                    .setTicker(trickerMessage)
                    .setContentTitle(contentTitle)
                    .setContentText(notificationText)
                    .setSmallIcon(R.mipmap.ic_launcher)
//        .setLargeIcon(bitmap)
                    .setContentIntent(intent);

		/*
		 * Su versioni inferiori a jelly beans la large appare insieme al
		 * custom layout
		 */
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN ) {
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher);
                builder.setLargeIcon(bitmap);
            }

            builder.setAutoCancel(true);


            Notification notification = builder.build();
            notification.defaults = Notification.DEFAULT_ALL;
//            if (!isVibrate() && !isSound()) {
//                notification.defaults = 0;
//            } else if (isVibrate() && isSound()) {
//                notification.defaults = Notification.DEFAULT_ALL;
//            } else if (isVibrate()) {
//                notification.defaults = 0;
//                notification.defaults = Notification.DEFAULT_VIBRATE;
//            } else if (isSound()) {
//                notification.defaults = 0;
//                notification.defaults = Notification.DEFAULT_SOUND;
//            }


            NotificationManager mNotificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(NOTIFICATION_ID, notification);


        } catch (Exception e) {
            Log.d(TAG, "sendNotification", e);
        }
    }


}
