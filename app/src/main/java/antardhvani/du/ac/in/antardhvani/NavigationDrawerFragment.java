package antardhvani.du.ac.in.antardhvani;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import antardhvani.du.ac.in.About.About;
import antardhvani.du.ac.in.Contact.Contact;
import antardhvani.du.ac.in.Event.viewpager;
import antardhvani.du.ac.in.FlowerShow.FlowerShow;
import antardhvani.du.ac.in.Gyanodaya.Gyanodaya;
import antardhvani.du.ac.in.Home.Home;
import antardhvani.du.ac.in.Map.Map;
import antardhvani.du.ac.in.Painting.Painting;
import antardhvani.du.ac.in.Schedule.Schedule_21_viewpager;
import antardhvani.du.ac.in.Schedule.Schedule_22_viewpager;
import antardhvani.du.ac.in.Schedule.Schedule_pre_event;
import antardhvani.du.ac.in.Schedule.Schedule_viewpager;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    /*
    STEPS TO HANDLE THE RECYCLER CLICK

    1 Create a class that EXTENDS RecylcerView.OnItemTouchListener

    2 Create an interface inside that class that supports click and long click and indicates the View that was clicked and the position where it was clicked

    3 Create a GestureDetector to detect ACTION_UP single tap and Long Press events

    4 Return true from the singleTap to indicate your GestureDetector has consumed the event.

    5 Find the childView containing the coordinates specified by the MotionEvent and if the childView is not null and the listener is not null either, fire a long click event

    6 Use the onInterceptTouchEvent of your RecyclerView to check if the childView is not null, the listener is not null and the gesture detector consumed the touch event

    7 if above condition holds true, fire the click event

    8 return false from the onInterceptedTouchEvent to give a chance to the childViews of the RecyclerView to process touch events if any.

    9 Add the onItemTouchListener object for our RecyclerView that uses our class created in step 1
     */
    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private AntardhvaniAdapter adapter;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View containerView;
    private boolean isDrawerOpened = false;
    public static int in;
    boolean scheduleSelected;
    static String[] titles = {"Home", "Events","Flower Show","Gyanodaya", "Painting Competition" ,"Schedule", "Contact","Map", "About Us" };
    static String[] titlesNew = {
            "Home",
            "Events",
            "Flower Show",
            "Gyanodaya",
            "Painting Competition",
            "Schedule",
            "Pre-Event",
            "Day 1 - Feb 20th",
            "Day 2 - Feb 21th",
            "Day 3 - Feb 22th",
            "Contact",
            "Map",
            "About Us"
    };





    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    public static List<Information> getData() {
        //load only static data inside a drawer
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_home_black_24dp, R.drawable.ic_event_note_black_24dp, R.drawable.ic_filter_vintage_black_24dp,R.drawable.ic_directions_train_black_24dp,R.drawable.ic_brush_black_24dp,R.drawable.ic_schedule_black_24dp, R.drawable.ic_quick_contacts_dialer_black_24dp,R.drawable.ic_directions_black_24dp ,R.drawable.ic_tag_faces_black_24dp };

        for (int i = 0; i < 9; i++) {
            Information current = new Information();
            current.iconId = icons[i % icons.length];
            current.title = titles[i % titles.length];
            data.add(current);
        }
        return data;
    }


    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        scheduleSelected=false;
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        adapter = new AntardhvaniAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView,new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                FragmentManager fm = getFragmentManager();
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

                switch (position) {
                    case 0:

                        Home home = new Home();
                        ft.replace(R.id.frame_container, home);
                        ft.commit();
                        mDrawerLayout.closeDrawers();

                        break;

                    case 1:
                        viewpager event = new viewpager();
                        ft.replace(R.id.frame_container, event);
                        Toast.makeText(getActivity().getApplicationContext(), "Click for more detail",
                                Toast.LENGTH_SHORT).show();
                        ft.commit();
                        mDrawerLayout.closeDrawers();
                        break;

                    case 2:
                        FlowerShow flower = new FlowerShow();
                        ft.replace(R.id.frame_container, flower);
                        ft.commit();
                        mDrawerLayout.closeDrawers();
                        break;

                    case 3:
                        Gyanodaya gyanod = new Gyanodaya();
                        ft.replace(R.id.frame_container, gyanod);
                        ft.commit();
                        mDrawerLayout.closeDrawers();
                        break;

                    case 4:
                        Painting pain = new Painting();
                        ft.replace(R.id.frame_container, pain);
                        ft.commit();
                        mDrawerLayout.closeDrawers();
                        break;

                    case 5:
                        if (!scheduleSelected)
                        {
                            Information current = new Information();
                            current.title = "   Pre-event";
                            adapter.data.add(6, current);
                            current = null;
                            current = new Information();
                            current.title = "   Day 1 - Feb 20th";
                            adapter.data.add(7, current);
                            current = null;
                            current = new Information();
                            current.title = "   Day 2 - Feb 21th";
                            adapter.data.add(8, current);
                            current = null;
                            current = new Information();
                            current.title = "   Day 3 - Feb 22th";
                            adapter.data.add(9, current);
                            scheduleSelected=true;
                            adapter.notifyDataSetChanged();
                            mDrawerLayout.openDrawer(Gravity.LEFT);
                        }
                        else
                        {

                            adapter.data.remove(6);
                            adapter.data.remove(6);
                            adapter.data.remove(6);
                            adapter.data.remove(6);
                            scheduleSelected=false;
                            adapter.notifyDataSetChanged();
                            mDrawerLayout.openDrawer(Gravity.LEFT);
                        }
                        break;

                    case 6:
                        if (!scheduleSelected) {
                            Contact cont =  new Contact();
                            ft.replace(R.id.frame_container, cont);
                            ft.commit();
                            mDrawerLayout.closeDrawers();
                        } else {
                            Schedule_pre_event schedulePreEvent = new Schedule_pre_event();
                            ft.replace(R.id.frame_container, schedulePreEvent);
                            ft.commit();
                            mDrawerLayout.closeDrawers();
                        }
                        break;

                    case 7:
                        if (!scheduleSelected) {
                            Map map = new Map();
                            ft.replace(R.id.frame_container, map);
                            ft.commit();
                            mDrawerLayout.closeDrawers();
                        } else {
                            Schedule_viewpager schedulePreEvent = new Schedule_viewpager();
                            ft.replace(R.id.frame_container, schedulePreEvent);
                            ft.commit();
                            in = MainActivity.toolbar.getHeight();
                            mDrawerLayout.closeDrawers();
                        }
                        break;

                    case 8:
                        if (!scheduleSelected) {
                            About about1 = new About();
                            ft.replace(R.id.frame_container, about1);
                            ft.commit();
                            mDrawerLayout.closeDrawers();
                        } else {
                            Schedule_21_viewpager schedulePreEvent = new Schedule_21_viewpager();
                            ft.replace(R.id.frame_container, schedulePreEvent);
                            ft.commit();
                            in = MainActivity.toolbar.getHeight();
                            mDrawerLayout.closeDrawers();
                        }
                        break;

                    case 9:
                        Schedule_22_viewpager schedulePreEvent = new Schedule_22_viewpager();
                        ft.replace(R.id.frame_container, schedulePreEvent);
                        ft.commit();
                        in = MainActivity.toolbar.getHeight();
                        mDrawerLayout.closeDrawers();
                        break;

                    case 10:
                        Contact cont =  new Contact();
                        ft.replace(R.id.frame_container, cont);
                        ft.commit();
                        mDrawerLayout.closeDrawers();
                        break;

                    case 11:
                        Map map = new Map();
                        ft.replace(R.id.frame_container, map);
                        ft.commit();
                        mDrawerLayout.closeDrawers();
                        break;

                    case 12:
                        About about1 = new About();
                        ft.replace(R.id.frame_container, about1);
                        ft.commit();
                        mDrawerLayout.closeDrawers();
                        break;




                }

                recyclerView.setSelected(true);
                if (!scheduleSelected) {
                    MainActivity.toolbar.setTitle(titles[position]);

                }else
                    MainActivity.toolbar.setTitle(titlesNew[position]);

            }



            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return layout;
    }



    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };
        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }



    public static interface ClickListener{
        public void onClick(View view, int position);
        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements  RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private ClickListener clickListener;
        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener){
            this.clickListener=clickListener;
            gestureDetector=new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if(child!=null && clickListener!=null)
                    {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child=rv.findChildViewUnder(e.getX(), e.getY());
            if(child!=null && clickListener!=null && gestureDetector.onTouchEvent(e))
            {
                clickListener.onClick(child, rv.getChildPosition(child));

            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }
    }


}
