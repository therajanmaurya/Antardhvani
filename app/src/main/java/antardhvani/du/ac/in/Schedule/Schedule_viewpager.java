package antardhvani.du.ac.in.Schedule;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antardhvani.du.ac.in.antardhvani.R;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by rajanmaurya on 13/2/15.
 */
public class Schedule_viewpager extends Fragment implements MaterialTabListener {

    public static PagerTabStrip tabHost;
    public static ViewPager viewPager;



    public static Schedule_viewpager getInstance(int position) {
        Schedule_viewpager myFragment = new Schedule_viewpager();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.schedule_viewpager, container, false);
        Bundle bundle = getArguments();
        tabHost = (PagerTabStrip) layout.findViewById(R.id.materialTabHost);
        viewPager = (ViewPager) layout.findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
//        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                tabHost.setSelectedNavigationItem(position);
//            }
//        });
//
//        for (int i = 0; i < adapter.getCount(); i++) {
//            tabHost.addTab(
//                    tabHost.newTab()
//                            //.setIcon(adapter.getPageTitle(i))
//                            .setText(adapter.getPageTitle(i))
//
//                            .setTabListener(this));
//
//
//        }


        return layout;


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


    public Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);


    }


    public Fragment getItem(int num) {
        switch (num) {
            case 0: // Fragment # 0 - This will show image
                //return Event_non_competitive.getInstance(num);
                return new Schedule_pre_event();
            case 1: // Fragment # 1 - This will show image
                return new Schedule();
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
                title = "PreEvent Schedule";
                break;
            case 1:
                title = "Schedule";
                break;

        }
        return title;
    }


}

