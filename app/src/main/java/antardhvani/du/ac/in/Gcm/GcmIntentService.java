package antardhvani.du.ac.in.Gcm;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.util.logging.Level;
import java.util.logging.Logger;

import antardhvani.du.ac.in.Database.NotificationSQL;
import antardhvani.du.ac.in.antardhvani.MainActivity;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by lusifer on 16/2/15.
 */
public class GcmIntentService extends IntentService {

    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (extras != null && !extras.isEmpty()) {  // has effect of unparcelling Bundle
            // Since we're not using two way messaging, this is all we really to check for
            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Logger.getLogger("GCM_RECEIVED").log(Level.INFO, extras.toString());
                Log.e("chu", extras.getString("message"));
                showToast(extras.getString("message"));
            }
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    protected void showToast(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
               // NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplication());
               // mBuilder.setSmallIcon(R.drawable.antardhvanilogo);
               // ArrayList<String> data=new ArrayList<String>();
               // for (String retval: message.split("@")){
               //         data.add(retval);
               // }
               // mBuilder.setContentTitle(data.get(0));
               // mBuilder.setContentText(data.get(1));
               // db.addNotification("xyz", message);

                NotificationSQL db=new NotificationSQL(getApplication());
                Log.e("ADDNotification","okkkk");
                String [] x=null;
                if(message.contains("@")){
                    x= message.split("@");
                }else{
                   x=new String [2];
                   x[0]=message;
                   x[1]="";
                }

                Log.e(db.getLastNotification(),message);



                if(!db.getLastNotification().equals(message)) {
                    if(!MainActivity.x){

                    db.addNotification(x[0], x[1]);
                    db.close();

                    generateNotification(getApplicationContext(), x[0], x[1]);
                }else{
                        //Toast.makeText(getApplicationContext(), "New Notification", Toast.LENGTH_SHORT).show();
                        db.addNotification(x[0], x[1]);
                        db.close();
                        long pattern[]={0,200,100,300,400};

                        //Start the vibration
                        Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                        //start vibration with repeated count, use -1 if you don't want to repeat the vibration
                        vibrator.vibrate(pattern, -1);
                    }

                }

            }
        });
    }
    private static void generateNotification(Context context, String  x2,String message) {
        int icon = R.drawable.antardhvanilogo;
        long when = System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification(icon, message, when);
        String title = x2;

        Intent notificationIntent = new Intent(context, antardhvani.du.ac.in.Notification.Notification.class);
        // set intent so it does not start a new activity
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent intent =
                PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notification.setLatestEventInfo(context, title, message, intent);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        // Play default notification sound
        notification.defaults |= Notification.DEFAULT_SOUND;

        // Vibrate if vibrate is enabled
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notificationManager.notify(0, notification);

    }

}