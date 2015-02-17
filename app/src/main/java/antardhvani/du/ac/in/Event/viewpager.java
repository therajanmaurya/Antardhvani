package antardhvani.du.ac.in.Event;

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
import android.widget.TabHost;

import antardhvani.du.ac.in.antardhvani.R;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabListener;


public class viewpager extends Fragment implements MaterialTabListener {

    //public static MaterialTabHost tabHost;
    public static TabHost oldTabHost;
    public static ViewPager viewPager;
    public PagerTabStrip tabHost;



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


        layout = inflater.inflate(R.layout.viewpager, container, false);
        Bundle bundle = getArguments();
        tabHost = (PagerTabStrip) layout.findViewById(R.id.materialTabHost);
        viewPager = (ViewPager) layout.findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        return layout;


    }

    @Override
    public void onTabSelected(MaterialTab materialTab) {

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
                    return  Event_non_competitive.getInstance(num);
                case 1: // Fragment # 1 - This will show image
                    return  Event_non_competitive.getInstance(num);
                //return Event_competitive.getInstance(num);
                case 2:// Fragment # 2-9 - Will show list
                    return  Event_non_competitive.getInstance(num);


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
}