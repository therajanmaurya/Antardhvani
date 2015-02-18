package antardhvani.du.ac.in.antardhvani;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
=======
import android.graphics.drawable.LayerDrawable;
>>>>>>> 5b649fe808d5d8a60c79cb553dd8e952295c91c9
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

import antardhvani.du.ac.in.Database.NotificationSQL;
import antardhvani.du.ac.in.Gcm.GcmRegistrationAsyncTask;
import antardhvani.du.ac.in.Home.Home;
import antardhvani.du.ac.in.Notification.Notification;
import antardhvani.du.ac.in.Rules.Rules_viewpager;


public class MainActivity extends ActionBarActivity {
    public static NotificationSQL db;
    public static Toolbar toolbar;
    public  static boolean x;
    public static ViewPager viewPager;

    private int mNotificationsCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        int h=toolbar.getHeight();
        SharedPreferences sharedPreferences = getSharedPreferences("Prefs", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("toolBarHeight", toolbar.getHeight());
        editor.commit();

        db=new NotificationSQL(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        if (savedInstanceState == null) {
            Home home = new Home();
            getSupportFragmentManager()

                    .beginTransaction().replace(R.id.frame_container, home)
                    .commit();

        }
        Log.e("where","before ");
        //db = new NotificationSQL(this);
       // db123.addNotification("hello","sagar");
        new GcmRegistrationAsyncTask(this).execute();
        update();
        db.close();
        Log.e("where", "after");



    }

    private Timer timer;
    private TimerTask timerTask;

    public void onPause(){
        super.onPause();
        x=false;
        timer.cancel();
    }

    public void onResume(){
        super.onResume();
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(0);
        x=true;
        try {
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    //Download file here and refresh
                    update();
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        } catch (IllegalStateException e){
            android.util.Log.i("Damn", "resume error");
        }
    }
    public  void update(){
        FetchCountTask x =new FetchCountTask();
                x.execute();

    }

    @Override
    protected void onStart() {
        super.onStart();
        x=true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        x=false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.action_notifications){
            db.updateBook();
            db.close();
            startActivity(new Intent(this, Notification.class));

            return true;
        }

        if (id == R.id.news) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://antardhvani2015.du.ac.in/"));
            startActivity(browserIntent);
            return true;
        }
        //noinspection SimplifiableIfStatement
       //Like us on faceboook link
        if (id == R.id.facebook) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/UniversityofDelhi"));
            startActivity(browserIntent);
            return true;
        }

        //Rules for competitive events link
        if (id == R.id.rules) {
/*            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://antardhvani2015.du.ac.in/pdf/06022015Rulesforcompetitiveevents.pdf"));
            startActivity(browserIntent);*/
// 1. Instantiate an AlertDialog.Builder with its constructor


// 2. Chain together various setter methods to set the dialog characteristics


// 3. Get the AlertDialog from create()

            startActivity(new Intent(this, Rules_viewpager.class));
//            DialogFragment aboutD = new RulesFragment();
//            aboutD.show(getFragmentManager(), "ABOUT_DIALOG");
            return true;


        }



//        //Download Brochure link
//        if (id == R.id.brochure) {
//            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://antardhvani2015.du.ac.in/pdf/01022015Flowershowbooklet2015.pdf"));
//            startActivity(browserIntent);
//            return true;
//        }

        //Important notices link
        if (id == R.id.notice) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://antardhvani2015.du.ac.in/notifications.html"));
            startActivity(browserIntent);
            return true;
        }



        //Share app link
        if (id == R.id.share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Have a look at Antardhvani 2015 app here :  play.google.com/store/apps/details?id=antardhvani.du.ac.in.antardhvani");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            return true;
        }




        return super.onOptionsItemSelected(item);
    }


    public void sendMail(View view)
    {
        TextView textView = (TextView) view;
        /*Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_)
        intent.putExtra(Intent.EXTRA_EMAIL, textView.getText());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Re: Antardhwani via Official App");

        startActivity(Intent.createChooser(intent, "Send Email"));*/

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + textView.getText()));
        startActivity(intent);
    }
    public void sendDevMail(View v)
    {

        /*Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_)
        intent.putExtra(Intent.EXTRA_EMAIL, textView.getText());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Re: Antardhwani via Official App");

        startActivity(Intent.createChooser(intent, "Send Email"));*/
        String x="mailto: " + "kumarsagar15795@gmail.com,"+"rajanmaurya154@gmail.com,"+"devesh.khandelwal@outlook.com,"+"akoli0082@gmail.com,"+"pawanpal004@gmail.com"+"?subject=" + URLEncoder.encode("Re: From Official Du Antardhvani App");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(x));
        startActivity(intent);
    }
    public void sendDevPage(View v)
    {

        /*Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_)
        intent.putExtra(Intent.EXTRA_EMAIL, textView.getText());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Re: Antardhwani via Official App");

        startActivity(Intent.createChooser(intent, "Send Email"));*/

        String url = "https://github.com/teamDAPSR";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Get the notifications MenuItem and
        // its LayerDrawable (layer-list)
        MenuItem item = menu.findItem(R.id.action_notifications);
        LayerDrawable icon = (LayerDrawable) item.getIcon();

        // Update LayerDrawable's BadgeDrawable
        Utils.setBadgeCount(this, icon, mNotificationsCount);

        return true;
    }


    /*
    Updates the count of notifications in the ActionBar.
     */
    public  void updateNotificationsBadge(int count) {
        mNotificationsCount = count;

        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
    }

    /*
    Sample AsyncTask to fetch the notifications count
    */
    class FetchCountTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
            // example count. This is where you'd
            // query your data store for the actual count.
           NotificationSQL db=new NotificationSQL(getApplication());
            int x=db.unread_Num();
            db.close();
            return x ;
        }

        @Override
        public void onPostExecute(Integer count) {
            updateNotificationsBadge(count);
        }

    }
}
