package antardhvani.du.ac.in.Home;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import antardhvani.du.ac.in.antardhvani.R;
import antardhvani.du.ac.in.antardhvani.ScreenSlidePageFragment;

/**
 * Created by Windows on 23-01-2015.
 */
public class Home extends Fragment {
    private TextView title, des, venue, schedule;
    int[] photos = {R.drawable.slider_1_bg, R.drawable.slider_2_bg, R.drawable.slider_3_bg};
    KenBurnsView imageView;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private Timer timer;
    private int count = 0;
    private boolean one_two_three = true;
    public static final int NUM_PAGES = 3;


    public static Home getInstance(int position) {
        Home myFragment = new Home();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.home, container, false);

        title = (TextView) layout.findViewById(R.id.title);
        des = (TextView) layout.findViewById(R.id.titleShortDescription);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sofia-Regular.otf");
        Typeface font2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/D Day Stencil.ttf");
        title.setTypeface(font2);
        des.setTypeface(font);


        imageView = (KenBurnsView) layout.findViewById(R.id.header_picture);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                // change images randomly
                Random ran = new Random();
                int i = ran.nextInt(photos.length);
                //set image resources
                imageView.setImageResource(photos[i]);
                i++;
                if (i > photos.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 7000);  //for interval...
            }
        };
        handler.postDelayed(runnable, 7000); //for initial delay..

        mPager = (ViewPager) layout.findViewById(R.id.pager1);
        mPagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When changing pages, reset the action bar actions since they are dependent
                // on which page is currently active. An alternative approach is to have each
                // fragment expose actions itself (rather than the activity exposing actions),
                // but for simplicity, the activity provides the actions in this sample.
                //invalidateOptionsMenu(getActivity());
            }
        });
        final Handler handler1 = new Handler();

        final Runnable Update = new Runnable() {
            public void run() {
                if (one_two_three) {
                    mPager.setCurrentItem(count++, true);
                } else {
                    mPager.setCurrentItem(count--, true);
                }
                if (count == 0) {
                    one_two_three = true;
                }
                if (count == NUM_PAGES) {
                    one_two_three = false;
                }

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler1.post(Update);
            }
        }, 1000, 5000);

        return layout;

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}