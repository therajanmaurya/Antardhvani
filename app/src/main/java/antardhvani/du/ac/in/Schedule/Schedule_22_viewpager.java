package antardhvani.du.ac.in.Schedule;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 17/2/15.
 */
public class Schedule_22_viewpager extends Fragment {


    public static ViewPager viewPager;
    public static TextView venue;
    static String[] venues;


    public static Schedule_22_viewpager getInstance(int position) {
        Schedule_22_viewpager myFragment = new Schedule_22_viewpager();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.schedule_viewpager, container, false);
        Bundle bundle = getArguments();

        viewPager = (ViewPager) layout.findViewById(R.id.viewPager);
        venue = (TextView)layout.findViewById(R.id.venueId);
        venues = getResources().getStringArray(R.array.venues);
        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TextView venue = (TextView)layout.findViewById(R.id.venueId);
                venue.setText(venues[position]);
            }

            @Override
            public void onPageSelected(int position) {
                TextView venue = (TextView)layout.findViewById(R.id.venueId);
                venue.setText(venues[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return layout;


    }

}

class ViewPagerAdapter2 extends FragmentStatePagerAdapter {



    public Context context;
    public ViewPagerAdapter2(FragmentManager fm) {
        super(fm);


    }


    public Fragment getItem(int num) {

        return Schedule_20th_FEB_2015.getInstance(num);

    }


    @Override
    public int getCount() {
        return 7;
    }



}
