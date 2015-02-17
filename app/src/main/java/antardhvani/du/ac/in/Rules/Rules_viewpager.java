package antardhvani.du.ac.in.Rules;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import antardhvani.du.ac.in.antardhvani.R;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by rajanmaurya on 14/2/15.
 */
public class Rules_viewpager extends ActionBarActivity implements MaterialTabListener {

    public static final String TAG = "VIVZ";

    private Toolbar toolbar;
    private PagerTabStrip tabHost;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_viewpager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Rules");
        tabHost = (PagerTabStrip) findViewById(R.id.materialTabHost);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabSelected(MaterialTab materialTab) {
        viewPager.setCurrentItem(materialTab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }


    class ViewPagerAdapter extends FragmentStatePagerAdapter {


        public Context context;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);


        }


        public Fragment getItem(int num) {
            switch (num) {
                case 0: // Fragment # 0 - This will show image
                    //return Event_non_competitive.getInstance(num);
                    return new Rules_antardhvani();
                case 1: // Fragment # 1 - This will show image
                    return new Rules_competitive();
                //return Event_competitive.getInstance(num);


            }
            return null;

        }


        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            switch (position) {
                case 0:
                    title = "ANTARDHVANI COMPETITIONS";
                    break;
                case 1:
                    title = "SPECIFIC COMPETITIVE EVENTS";
                    break;

            }
            return title;
        }

    }
}