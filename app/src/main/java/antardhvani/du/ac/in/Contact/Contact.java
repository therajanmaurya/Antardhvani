package antardhvani.du.ac.in.Contact;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by Windows on 23-01-2015.
 */
public class Contact extends Fragment {
    private TextView textView;

    public static Contact getInstance(int position) {
        Contact myFragment = new Contact();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.contact, container, false);
         

        return layout;

    }

}