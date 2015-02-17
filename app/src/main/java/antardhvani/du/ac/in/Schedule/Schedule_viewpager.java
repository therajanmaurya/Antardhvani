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
            case 0:
                return Schedule_20th_FEB_2015.getInstance(num);

            case 1:
                return Schedule_20th_FEB_2015.getInstance(num);

            case 2:
                return Schedule_20th_FEB_2015.getInstance(num);

            case 3:
                return Schedule_20th_FEB_2015.getInstance(num);

            case 4:
                return Schedule_20th_FEB_2015.getInstance(num);

            case 5:
                return Schedule_20th_FEB_2015.getInstance(num);

            case 6:
                return Schedule_20th_FEB_2015.getInstance(num);

            case 7:
                return Schedule_20th_FEB_2015.getInstance(num);


              //return Event_competitive.getInstance(num);


        }
        return null;

    }


    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case 0:
                title = "Indoor Stadium, Ground Floor";
                break;
            case 1:
                title = "Indoor Stadium, Ground Floor Rooms";
                break;
            case 2:
                title = "Indoor Stadium, First Floor Hall-BAITHAK";
                break;
            case 3:
                title = "Indoor Stadium, Basement & nearby Grounds";
                break;
            case 4:
                title = "Rugby Sevens,G-20- A";
                break;
            case 5:
                title = "Open Air Stage (Next to  UIC)";
                break;
            case 6:
                title = "Rugby Sevens,G-20- B & C";
                break;

        }
        return title;
    }


}

