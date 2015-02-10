package antardhvani.du.ac.in.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import antardhvani.du.ac.in.FlowerShow.FlowerShow;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 10/2/15.
 */

public class Map extends Fragment {
    private TextView textView;

    public static Map getInstance(int position) {
        Map myFragment = new Map();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_my, container, false);

        return layout;

    }

}