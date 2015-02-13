package antardhvani.du.ac.in.Schedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by Windows on 23-01-2015.
 */
public class Schedule extends Fragment {


    public static Schedule getInstance(int position) {
        Schedule myFragment = new Schedule();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.schedule, container, false);


        return layout;

    }

}