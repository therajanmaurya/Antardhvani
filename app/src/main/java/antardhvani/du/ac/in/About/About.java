package antardhvani.du.ac.in.About;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 13/2/15.
 */
public class About extends Fragment {


    public static About getInstance(int position) {
        About myFragment = new About();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.about, container, false);

        return layout;

    }


}