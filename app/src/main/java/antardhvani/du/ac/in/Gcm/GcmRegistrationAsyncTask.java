package antardhvani.du.ac.in.Gcm;

import android.content.Context;
import android.os.AsyncTask;

import com.example.lusifer.myapplication.backend.registration.Registration;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by lusifer on 16/2/15.
 */
public  class GcmRegistrationAsyncTask extends AsyncTask<Void, Void, String> {
    private  Registration regService = null;
    private GoogleCloudMessaging gcm;
    private Context context;
    public static boolean status;
    // TODO: change to your own sender ID to Google Developers Console project number, as per instructions above
    private  String SENDER_ID ;

    public GcmRegistrationAsyncTask(Context context) {
        this.context = context;
        SENDER_ID=context.getResources().getString(R.string.GoogleGCMid);
    }

    @Override
    protected String doInBackground(Void... params) {
        if (regService == null) {
            Registration.Builder builder = new Registration.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // Need setRootUrl and setGoogleClientRequestInitializer only for local testing,
                    // otherwise they can be skipped
                    .setRootUrl(context.getResources().getString(R.string.url));

            // end of optional local run code

            regService = builder.build();

        }

        String msg = "";
        try {
            if (gcm == null) {
                gcm = GoogleCloudMessaging.getInstance(context);
            }
            String regId = gcm.register(SENDER_ID);
            msg = "Device registered, registration ID=" + regId;
            status=true;
            // You should send the registration ID to your server over HTTP,
            // so it can use GCM/HTTP or CCS to send messages to your app.
            // The request to your server should be authenticated if your app
            // is using accounts.
            regService.register(regId).execute();

        } catch (IOException ex) {
            ex.printStackTrace();
            msg = "Error: " + ex.getMessage();
            status=false;

        }
        return msg;
    }

    @Override
    protected void onPostExecute(String msg) {
        //Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        Logger.getLogger("REGISTRATION").log(Level.INFO, msg);
    }
}