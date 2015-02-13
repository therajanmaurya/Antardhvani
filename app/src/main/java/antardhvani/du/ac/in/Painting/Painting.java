package antardhvani.du.ac.in.Painting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 13/2/15.
 */
public class Painting extends Fragment {
    private TextView textView;

    public static Painting getInstance(int position) {
        Painting myFragment = new Painting();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.painting, container, false);


        return layout;

    }


}