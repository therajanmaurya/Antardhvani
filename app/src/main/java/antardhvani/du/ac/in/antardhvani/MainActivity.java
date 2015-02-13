package antardhvani.du.ac.in.antardhvani;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import antardhvani.du.ac.in.Home.Home;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import antardhvani.du.ac.in.antardhvani.R;


public class MainActivity extends ActionBarActivity {

    public static Toolbar toolbar;
    public static MaterialTabHost tabHost;
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       //Like us on faceboook link
        if (id == R.id.facebook) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/UniversityofDelhi"));
            startActivity(browserIntent);
            return true;
        }

        //Rules for competitive events link
        if (id == R.id.rules) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://antardhvani2015.du.ac.in/pdf/06022015Rulesforcompetitiveevents.pdf"));
            startActivity(browserIntent);
            return true;
        }

        //Download Brochure link
        if (id == R.id.brochure) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://antardhvani2015.du.ac.in/pdf/01022015Flowershowbooklet2015.pdf"));
            startActivity(browserIntent);
            return true;
        }

        //Important notices link
        if (id == R.id.notice) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://antardhvani2015.du.ac.in/notifications.html"));
            startActivity(browserIntent);
            return true;
        }

        //Rate app link
        if (id == R.id.rate) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("play.google.com/store/apps/details?id=antardhvani.du.ac.in.antardhvani"));
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

        //Source code on github link
        if (id == R.id.code) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/teamDAPSR/Antardhvani"));
            startActivity(browserIntent);
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

}
