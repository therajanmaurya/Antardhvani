package antardhvani.du.ac.in.antardhvani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
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

import antardhvani.du.ac.in.Database.NotificationSQL;
import antardhvani.du.ac.in.Gcm.GcmRegistrationAsyncTask;
import antardhvani.du.ac.in.Home.Home;
import antardhvani.du.ac.in.Rules.Rules_viewpager;
import it.neokree.materialtabs.MaterialTabHost;


public class MainActivity extends ActionBarActivity {
    public static NotificationSQL db;
    public static Toolbar toolbar;
    public static MaterialTabHost tabHost;
    public static ViewPager viewPager;
    public static String MY_PREFS_NAME="RegStatus";
    public static String KEY="Status";
    private int mNotificationsCount = 0;
    public static int status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        db=new NotificationSQL(this);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        status = getStatusBarHeight();
        SharedPreferences sharPref = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        boolean restoredText = sharPref.getBoolean(KEY,false);
        Log.e("error",( restoredText==false) ? "yes false" : "yes true");
        if(!restoredText){
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            new GcmRegistrationAsyncTask(this).execute();
            editor.putBoolean(KEY,true);
            editor.commit();

        }

        if(!GcmRegistrationAsyncTask.status){
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putBoolean(KEY,false);
            editor.commit();
        }
        if (savedInstanceState == null) {
            Home home = new Home();
            getSupportFragmentManager()

                    .beginTransaction().replace(R.id.frame_container, home)
                    .commit();

        }
        Log.e("where","before ");
        //db = new NotificationSQL(this);
       // db123.addNotification("hello","sagar");

        db.close();
        Log.e("where", "after");
        new FetchCountTask().execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.action_notifications){
            db.close();
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
    private void updateNotificationsBadge(int count) {
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
            db=new NotificationSQL(getApplication());
            int x=db.unread_Num();
            db.close();
            return x ;
        }

        @Override
        public void onPostExecute(Integer count) {
            updateNotificationsBadge(count);
        }

    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
