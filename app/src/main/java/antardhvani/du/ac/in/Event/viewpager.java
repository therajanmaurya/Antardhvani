package antardhvani.du.ac.in.Event;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import antardhvani.du.ac.in.antardhvani.R;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by Windows on 23-01-2015.
 */
public class viewpager extends Fragment implements MaterialTabListener {
    private TextView textView;
    private Toolbar toolbar;
    public static MaterialTabHost tabHost;
    public static TabHost oldTabHost;
    public static ViewPager viewPager;

    int icons[] = {R.drawable.ic_action_home,
            R.drawable.ic_action_articles,
            R.drawable.ic_action_personal,
            R.drawable.ic_action_home};

    public static viewpager getInstance(int position) {
        viewpager myFragment = new viewpager();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            layout = inflater.inflate(R.layout.viewpager, container, false);
            Bundle bundle = getArguments();
            tabHost = (MaterialTabHost) layout.findViewById(R.id.materialTabHost);
            viewPager = (ViewPager) layout.findViewById(R.id.viewPager);

            ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
            viewPager.setAdapter(adapter);
            viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    tabHost.setSelectedNavigationItem(position);
                }
            });

            for (int i = 0; i < adapter.getCount(); i++) {
                tabHost.addTab(
                        tabHost.newTab()
                                //.setIcon(adapter.getPageTitle(i))
                                .setText(adapter.getPageTitle(i))

                                .setTabListener(this));


            }


        }
        else {

            layout = inflater.inflate(R.layout.viewpager_compat, container, false);
            Bundle bundle = getArguments();
            oldTabHost = (TabHost) layout.findViewById(R.id.tabHost);
            viewPager = (ViewPager) layout.findViewById(R.id.viewPagerCompat);

            ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
            viewPager.setAdapter(adapter);
            viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    oldTabHost.setCurrentTab(position);
                }
            });

            for (int i = 0; i < adapter.getCount(); i++) {
                oldTabHost.addTab(
                        oldTabHost.newTabSpec("Str").setIndicator(adapter.getPageTitle(i)));
                                //.setIcon(adapter.getPageTitle(i))
                                //.setText(adapter.getPageTitle(i))

                                //.setTabListener(this));


            }


        }
        return layout;


    }

    public Drawable getIcon(int position) {
        return getResources().getDrawable(icons[position]);
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
}

class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int icons[] = {R.drawable.ic_action_home,
            R.drawable.ic_action_articles,
            R.drawable.ic_action_personal,
            R.drawable.ic_action_home};
    public Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);


    }


    public Fragment getItem(int num) {
        switch (num) {
            case 0: // Fragment # 0 - This will show image
                //return Event_non_competitive.getInstance(num);
                return new Event_non_competitive();
            case 1: // Fragment # 1 - This will show image
                return new Event_competitive();
                //return Event_competitive.getInstance(num);
            case 2:// Fragment # 2-9 - Will show list
                return new Event_special();
//            default:// Fragment # 2-9 - Will show list
//                return Event_non_competitive.getInstance(num);

        }
        return null;
        //return Expand.getInstance(num);
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "Non Competitive";
                break;
            case 1:
                title = "Competitive";
                break;
            case 2:
                title = "Special Attractions";
                break;
        }
        return title;
    }


}
